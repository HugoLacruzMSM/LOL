package model.entity.mage;

import model.entity.Champion;
import model.entity.interfaces.AggressiveChampion;
import model.entity.interfaces.HealerChampion;

public class Mage extends Champion implements AggressiveChampion {
    int mana;
    public Mage(String name, String role, int health, int damage, int mana) {
        super(name, role, health, damage);
        this.mana = mana;
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(getHealth()-damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
        System.out.println("The champion"+ getName() +" has taken " + damage + " damage. ");
    }

    @Override
    public void specialAbility(Champion champion) {

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(Champion objective) {

    }
}
