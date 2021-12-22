var itemsApi = Vue.resource('/item{/name}');

Vue.component('item-form', {
    props: [ 'items', 'itemAttr'],
    data: function() {
        return {
            name: ''
        }
    },
    watch: {
        itemAttr: function(newVal, oldVal) {
            this.name = newVal.name;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="New task..." v-model="name" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var item = '"' + this.name + '"';

            itemsApi.save({}, item).then(result => {
                this.items.push(result.body);
                this.name = ''
                window.location.reload()
            })

        }
    }
});

Vue.component('item-row', {
    props: ['item', 'items'],
    template: '<div>' +
        '{{ item.name }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        del: function() {
            itemsApi.remove({name: this.item.name}).then(result => {
                if (result.ok) {
                    this.items.splice(this.items.indexOf(this.item), 1)
                }
            })
        }
    }
});

Vue.component('items-list', {
    props: ['items'],
    data: function() {
        return {
            item: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<item-form :items="items" :itemAttr="item" />' +
        '<item-row v-for="item in items" :item="item" :items="items" />' +
        '</div>',
    created: function() {
        itemsApi.get().then(result =>
            result.body.forEach(item =>  {
                this.items.push(item)
            })
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<items-list :items="items" />',
    data: {
        items: []
    }
});