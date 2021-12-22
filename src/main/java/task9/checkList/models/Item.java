package task9.checkList.models;

public class Item {

    private String name;

    public Item(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Item other = (Item) o;

        return this.name.equals(other.name);
    }
}
