package hugo.lol.entity.inventory;


import hugo.lol.entity.item.Item;

public class InventoryCell {

    private Item item;

    public boolean isOccupied() {
        return item != null;
    }

    public boolean place(Item item) {
        if (isOccupied()) {
            return false;
        }

        this.item = item;
        return true;
    }

    public Item remove() {
        Item removed = this.item;
        this.item = null;
        return removed;
    }

    public Item peek() {
        return item;
    }

    @Override
    public String toString() {
        return isOccupied() ? "[" + item.getName() + "]" : "[ ]";
    }
}