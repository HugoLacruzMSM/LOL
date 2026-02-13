package model.entity.tank;

import model.entity.Champion;

public class Tank extends Champion {

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
}
