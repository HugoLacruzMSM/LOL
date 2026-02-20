package main.entity;

public abstract class Champion {
   private String name;
   private String role;
   private int health;
   private int maxHealth;
   private int damage;
   private int level;

    public Champion(String name, String role, int health, int damage) {
        this.name = name;
        this.role = role;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.level = 1;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
