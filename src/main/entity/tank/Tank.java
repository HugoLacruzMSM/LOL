package main.entity.tank;

import main.entity.Champion;
import main.entity.interfaces.AggressiveChampion;
import main.entity.interfaces.HealerChampion;

public class Tank extends Champion implements AggressiveChampion, HealerChampion {

    int armor;

    public Tank(String name, String role, int health, int damage) {
        super(name, role, health, damage);
        this.armor = 50;
    }

    @Override
    public void receiveDamage(int damage) {
        int reducedDamage = damage - this.armor;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        System.out.println(getName() + " strengthens his armor " + damage + " -> " + reducedDamage + " damage.");
        super.receiveDamage(reducedDamage);
    }

    @Override
    public void specialAbility(Champion champion) {
        int armorBoost = 20;
        this.armor += armorBoost;
        System.out.println(getName() + " strengthens his armor +" + armorBoost
                + " armor. Total armor: " + this.armor);
    }

    @Override
    public void attack(Champion objective) {
        System.out.println(getName() + " hits " + objective.getName());
        objective.receiveDamage(getDamage());
    }

    @Override
    public void heal(Champion objective) {
        int healAmount = 50;
        int newHealth = objective.getHealth() + healAmount;
        if (newHealth > objective.getMaxHealth()){
            newHealth = objective.getMaxHealth();
        }
        objective.setHealth(newHealth);
        System.out.println(getName() + " patches up " + objective.getName()
                + " for " + healAmount + " HP. HP: "
                + objective.getHealth() + "/" + objective.getMaxHealth());
    }

    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
}
