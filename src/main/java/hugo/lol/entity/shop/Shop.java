package hugo.lol.entity.shop;

import hugo.lol.entity.Champion;
import hugo.lol.entity.inventory.Inventory;
import hugo.lol.entity.item.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {

    private final String name;
    private final List<Item> stock;

    public Shop(String name) {
        this.name = name;
        this.stock = new ArrayList<>();
    }

    public void addStock(Item item) {
        stock.add(item);
    }

    public boolean sell(Item item, Champion champion, Inventory inventory) {
        if (!stock.contains(item)) {
            System.out.println(name + ": item not in stock.");
            return false;
        }
        if (champion.canAfford(item.getPrice())) {
            System.out.println(champion.getName() + " can't afford " + item.getName() + ".");
            return false;
        }

        // condicion si el inventario esta lleno y no puedo comprar
        champion.spendGold(item.getPrice());
        stock.remove(item);
        System.out.println(champion.getName() + " bought " + item.getName() + ".");
        return true;
    }

    public List<Item> getStock() {
        return Collections.unmodifiableList(stock);
    }

    public void printStock() {
        System.out.println("=== " + name + " ===");
        if (stock.isEmpty()) {
            System.out.println("No items in stock.");
            return;
        }
        stock.forEach(System.out::println);
    }
}