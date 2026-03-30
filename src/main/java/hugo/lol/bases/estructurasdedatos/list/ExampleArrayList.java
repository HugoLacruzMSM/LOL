package hugo.lol.bases.estructurasdedatos.list;

import hugo.lol.entity.mage.Mage;

import java.util.ArrayList;

public class ExampleArrayList {

    public static void main(String[] args) {

        ArrayList<Mage> mages = new ArrayList<>();
        mages.add(createChamp("Manolo"));
        mages.add(createChamp("Hugo"));
        mages.add(createChamp("Juanra"));
        mages.add(createChamp("Dani"));
        mages.add(createChamp("R2D2"));

        System.out.println(mages);
        System.out.println(mages.get(1));
        mages.set(2,createChamp("Valen"));
        System.out.println("Set: "+mages);

        mages.add(1,createChamp("Alberto"));
        System.out.println(mages);


    }

     static Mage createChamp(String champName) {
        return new Mage(champName,100,100,100);
    }

}
