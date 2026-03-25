package hugo.lol.entity.inventory;

import hugo.lol.entity.Champion;
import hugo.lol.entity.item.consumable.ConsumableItem;

import java.util.ArrayList;
import java.util.List;

public class ConsumableBag {

    private final List<ConsumableItem> items;
    private final int capacity;

    public ConsumableBag(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    public boolean add(ConsumableItem item) {
        if (isFull()){
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean use(int index, Champion champion) {
        if (index < 0 || index >= items.size()){
            return false;
        }
        ConsumableItem item = items.remove(index);
        item.applyEffect(champion);
        return true;
    }

    public ConsumableItem get(int index) {
        if (index < 0 || index >= items.size()){
            return null;
        }
        return items.get(index);
    }

    public int getSize() { return items.size(); }
    public boolean isFull() { return items.size() >= capacity; }
    public boolean isEmpty() { return items.isEmpty(); }

    public void print() {
        System.out.println("=== Consumables ===");
        if (isEmpty()) {
            System.out.println("Empty.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + i + "] " + items.get(i));
        }
    }
}