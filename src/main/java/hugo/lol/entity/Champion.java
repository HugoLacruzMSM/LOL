package hugo.lol.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
@Setter
@Getter
@ToString
public abstract class Champion {
   private String name;
   private int health;
   private int maxHealth;
   private int damage;
   private int level;
   private int gold;

    public Champion(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.level = 1;
        this.gold = 500;
    }

    public boolean canAfford(int amount) {
        return gold >= amount;
    }

    public void spendGold(int amount) throws IllegalStateException {
        if (!canAfford(amount)){
            throw new IllegalStateException("Not enough gold.");
        }
        this.gold -= amount;
    }

    public void earnGold(int amount) {
        this.gold += amount;
    }

    public void receiveDamage(int damage){
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println("The champion"+ this.name +" has taken " + damage + " damage. ");
    }

    public void levelUp(){
        level++;
        maxHealth += 50;
        health += 50;
        damage += 10;
        System.out.println("The champion "+ getName() +" leveled up to " + level);
    }
    public abstract void specialAbility(Champion champion);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return health == champion.health && maxHealth == champion.maxHealth && damage == champion.damage && level == champion.level && Objects.equals(name, champion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, maxHealth, damage, level);
    }
}
