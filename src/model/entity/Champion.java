package model.entity;

public class Champion {
   private String name;
   private double size;
   private boolean mana;
   private String category;
   private String description;
   private int age;


    public Champion() {}
    public Champion(String name, double size, boolean mana, String category, String description, int age) {
        this.name = name;
        this.size = size;
        this.mana = mana;
        this.category = category;
        this.description = description;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void greet(){
        System.out.println("Hello I am " + name + " " + description);
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isMana() {
        return mana;
    }

    public void setMana(boolean mana) {
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", mana=" + mana +
                ", descriptionnnnn='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
