package main.entity.assasin;

import main.entity.Champion;
import main.entity.interfaces.AggressiveChampion;

public class Assassin extends Champion implements AggressiveChampion {
    int critical;

    public Assassin(String name, String role, int health, int damage) {
        super(name, role, health, damage);
        this.critical = 20;
    }

    @Override
    public void specialAbility(Champion champion) {
        int critDamage = (getDamage() + critical) * 2;
        System.out.println(getName() + " executes CRITICAL STRIKE on " + champion.getName());
        champion.receiveDamage(critDamage);
    }

    @Override
    public void attack(Champion objective) {
        System.out.println("The champion"+ getName() +" is attacking to "+ objective.getName());
        objective.receiveDamage(getDamage());
    }

    public int getCritical() {
        return critical;
    }
    public void setCritical(int critical) {
        this.critical = critical;
    }
}
