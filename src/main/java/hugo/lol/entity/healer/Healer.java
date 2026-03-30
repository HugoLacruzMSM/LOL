package hugo.lol.entity.healer;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.CanHeal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Healer extends Champion implements CanHeal {
    int mana;
    private int healPower;

    public Healer(String name, int health, int mana, int healPower) {
        super(name, health, 0);
        this.mana = mana;
        this.healPower = healPower;
    }

    @Override
    public void specialAbility(Champion champion) {
        int manaCost = 50;
        if (mana >= manaCost) {
            System.out.println(getName() + " casts SUPER HEAL on " + champion.getName());
            champion.setHealth(champion.getMaxHealth());
            mana -= manaCost;
            System.out.println(champion.getName() + " is fully restored! HP: "
                    + champion.getHealth() + "/" + champion.getMaxHealth());
            System.out.println(getName() + " remaining mana: " + mana);
        } else {
            System.out.println(getName() + " has no mana. Uses basic heal instead.");
            heal(champion);
        }
    }

    @Override
    public void heal(Champion objective) {
        int newHealth = objective.getHealth() + healPower;

        if (newHealth > objective.getMaxHealth()) {
            newHealth = objective.getMaxHealth();
        }
        objective.setHealth(newHealth);
        System.out.println(getName() + " heals " + objective.getName()
                + " for " + healPower + " HP. HP: "
                + objective.getHealth() + "/" + objective.getMaxHealth());
    }
}
