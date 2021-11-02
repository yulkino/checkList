package task9.checkList.models;

public class Item {

    private final String itemName;

    public Item(String name){
        this.itemName = name;
    }


    public String getItemName() {
        return itemName;
    }

    @Override
    public int hashCode() {
        return this.itemName.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Item other = (Item) o;

        return this.itemName.equals(other.itemName);
    }
}
