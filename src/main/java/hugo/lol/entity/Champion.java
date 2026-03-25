package hugo.lol.entity;

import hugo.lol.entity.inventory.Inventory;

import java.util.Objects;

public abstract class Champion {
   private String name;
   private int health;
   private int maxHealth;
   private int damage;
   private int level;
    private int gold;
    private final Inventory inventory;

    public Champion(String name, int health, int damage, Inventory inventory) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.level = 1;
        this.gold = 500;
        this.inventory = new Inventory(6,5,5);
    }

    public boolean canAfford(int amount) {
        return gold >= amount;
    }

    public void spendGold(int amount) throws IllegalStateException {
        if (canAfford(amount)){
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


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() { return gold; }

    public Inventory getInventory() { return inventory; }

    @Override
    public String toString() {
        return "Champion{" +
                "damage=" + damage +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", level=" + level +
                '}';
    }

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
