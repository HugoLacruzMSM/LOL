package model.entity;

public class Champion {
    String name;
    double size;
    boolean mana;
    String category;
    String description;


    public Champion() {}
    public Champion(String name,double size,boolean mana,String category,String description) {
        this.name = name;
        this.size = size;
        this.mana = mana;
        this.category = category;
        this.description = description;
    }

    void greet(){
        System.out.println("Hello I am " + name + " " + description);
    }

    String getCategory() {
        return category;
    }

}
