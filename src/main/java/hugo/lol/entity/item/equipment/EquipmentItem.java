package hugo.lol.entity.item.equipment;

import hugo.lol.entity.Champion;
import hugo.lol.entity.item.Item;

public class EquipmentItem extends Item {
    private final int bonusDamage;
    private final int bonusHealth;

    public EquipmentItem(String name, int price, int width, int height,
                         int bonusDamage, int bonusHealth) {
        super(name, price, width, height);
        this.bonusDamage = bonusDamage;
        this.bonusHealth = bonusHealth;
    }

    @Override
    public void applyEffect(Champion champion) {
        champion.setDamage(champion.getDamage() + bonusDamage);
        champion.setHealth(champion.getHealth() + bonusHealth);
        champion.setMaxHealth(champion.getMaxHealth() + bonusHealth);
        System.out.println(champion.getName() + " equipped " + getName()
                + " [+" + bonusHealth + " HP, +" + bonusDamage + " dmg]");
    }

    public int getBonusDamage() { return bonusDamage; }
    public int getBonusHealth() { return bonusHealth; }

    @Override
    public String toString() {
        return getName() + " [+" + bonusHealth + " HP, +" + bonusDamage + " dmg] (" + getPrice() + "g)";
    }
}


