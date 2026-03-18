package hugo.lol.entity.item.consumable;

import hugo.lol.entity.Champion;
import hugo.lol.entity.item.Item;

public class ConsumableItem extends Item {
    private final int healAmount;

    public ConsumableItem(String name, int price, int healAmount) {
        super(name, price, 1, 1);
        this.healAmount = healAmount;
    }

    @Override
    public void applyEffect(Champion champion) {
        int newHealth = Math.min(champion.getHealth() + healAmount, champion.getMaxHealth());
        champion.setHealth(newHealth);
    }

    public int getHealAmount() { return healAmount; }
}
