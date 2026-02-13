package model.entity.assasin;

import model.entity.Champion;
import model.entity.composer.ChampionComposer;

public class Assassin extends Champion implements ChampionComposer {
    int critical;

    public Assassin(String name, String role, int health, int damage) {
        super(name, role, health, damage);
        this.critical = 0;
    }

    @Override
    public void specialAbility(Champion champion) {

    }

    @Override
    public void attack(Champion objective) {
        System.out.println("The champion"+ getName() +" is attacking to "+ objective.getName());
        objective.receiveDamage(getDamage());
    }

    @Override
    public void receiveDamage(int damage) {
        setHealth(getHealth()-damage);
        if (getHealth() < 0) {
            setHealth(0);
        }
        System.out.println("The champion"+ getName() +" has taken " + damage + " damage. ");
    }

    public int getCritical() {
        return critical;
    }
    public void setCritical(int critical) {
        this.critical = critical;
    }
}
