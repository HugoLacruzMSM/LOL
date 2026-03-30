package hugo.lol.entity.mage;

import hugo.lol.entity.Champion;
import hugo.lol.entity.interfaces.CanAttack;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Mage extends Champion implements CanAttack {
    int mana;

    public Mage(String name, int health, int damage, int mana) {
        super(name, health, damage);
        this.mana = mana;
    }

    @Override
    public void attack(Champion objective) {
        System.out.println(getName() + " casts a magic bolt at " + objective.getName());
        objective.receiveDamage(getDamage());
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
        System.out.println(getName() + " has taken " + damage + " damage. HP: "
                + getHealth() + "/" + getMaxHealth());
    }

    @Override
    public void specialAbility(Champion champion) {
        int manaCost = 50;
        if (mana >= manaCost) {
            int magicDamage = getDamage() * 2;
            System.out.println(getName() + " casts FIREBALL on " + champion.getName());
            champion.receiveDamage(magicDamage);
            mana -= manaCost;
            System.out.println(getName() + " remaining mana: " + mana);
        } else {
            System.out.println(getName() + " has no mana! Uses basic attack instead.");
            attack(champion);
        }
    }
}
