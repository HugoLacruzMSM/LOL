package model.entity;

public class ChampMain {
    public static void main(String[] args) {
        Champion lux = new Champion("lux",1.50,true,"Mage","Luxxxxx");

        System.out.println(lux.name);
        System.out.println(lux.size);
        System.out.println(lux.mana);
        System.out.println(lux.category);
        System.out.println(lux.description);


        Champion garen = new Champion();
        garen.name = "Garen";
        garen.size= 1.90;
        garen.category = "Tank";
        garen.mana=false;
        garen.description="DEMACIAAAAAAA";

        garen.greet();
        String garenCategory = garen.getCategory();
        System.out.println("Category: "+garenCategory);


    }
}
