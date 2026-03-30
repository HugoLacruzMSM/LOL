package hugo.lol.entity.item.consumable;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.Consumable;
import hugo.lol.entity.interfaces.Stackable;
import hugo.lol.entity.item.Item;

public class ConsumableItem extends Item implements Consumable, Stackable {
    private final int healAmount;
    private int quantity;

    public ConsumableItem(String name, int price, int healAmount) {
        super(name, price, 1, 1);
        this.healAmount = healAmount;
        this.quantity = 1;
    }

    @Override
    public void consume(Champion champion) {
        if (isEmpty()) {
            System.out.println("No " + getName() + " left.");
            return;
        }
        int newHealth = Math.min(champion.getHealth() + healAmount, champion.getMaxHealth());
        champion.setHealth(newHealth);
        removeStack(1);
        System.out.println(
                champion.getName() + " used " + getName()
                        + " [+" + healAmount + " HP]. HP: " + champion.getHealth() + "/" + champion.getMaxHealth() + " | Remaining: " + quantity
        );
    }

    @Override
    public int getQuantity() { return quantity; }

    @Override
    public void addStack(int amount) { this.quantity += amount; }

    @Override
    public void removeStack(int amount) {
        this.quantity = Math.max(0, this.quantity - amount);
    }

    @Override
    public boolean isEmpty() { return quantity <= 0; }
}