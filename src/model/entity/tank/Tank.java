package model.entity.tank;

import model.entity.Champion;
import model.entity.interfaces.AggressiveChampion;
import model.entity.interfaces.HealerChampion;

public class Tank extends Champion implements AggressiveChampion, HealerChampion {

    public Tank(String name, String role, int health, int damage) {
        super(name, role, health, damage);
    }

    @Override
    public void receiveDamage(int damage) {
        {
            setHealth(getHealth()-damage);
            if (getHealth() < 0) {
                setHealth(0);
            }
            System.out.println("The champion"+ getName() +" has taken " + damage + " damage. ");
        }
    }

    @Override
    public void specialAbility(Champion champion) {

    }

    @Override
    public void attack(Champion objective) {

    }

    @Override
    public void heal() {

    }
}
