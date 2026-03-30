package hugo.lol.entity.item.equipment;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.Equippable;
import hugo.lol.entity.item.Item;
import lombok.Getter;

@Getter
public class EquipmentItem extends Item implements Equippable {
    private final int bonusHealth;
    private final int bonusDamage;

    public EquipmentItem(String name, int price, int width, int height, int bonusHealth, int bonusDamage) {
        super(name, price, width, height);
        this.bonusHealth = bonusHealth;
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void applyEffect(Champion champion) {
        champion.setMaxHealth(champion.getMaxHealth() + bonusHealth);
        champion.setHealth(champion.getHealth() + bonusHealth);
        champion.setDamage(champion.getDamage() + bonusDamage);

        System.out.println(champion.getName() + " equipped " + getName() + " [+" + bonusHealth + " HP, +" + bonusDamage + " DMG]");
    }

    @Override
    public void removeEffect(Champion champion) {
        champion.setMaxHealth(champion.getMaxHealth() - bonusHealth);
        champion.setHealth(Math.min(champion.getHealth(), champion.getMaxHealth()));
        champion.setDamage(champion.getDamage() - bonusDamage);

        System.out.println(champion.getName() + " unequipped " + getName());
    }
}