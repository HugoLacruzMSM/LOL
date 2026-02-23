package hugo.lol.bases.estructurasdedatos.list.arraylist;

import hugo.lol.entity.mage.Mage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mage> mages = new ArrayList<>();
        mages.add(createChamp("Manolo"));
        mages.add(createChamp("Hugo"));
        mages.add(createChamp("Juanra"));
        mages.add(createChamp("Dani"));
        mages.add(createChamp("R2D2"));

        System.out.println(mages);
        System.out.println(mages.get(1));

    }

     static Mage createChamp(String champName) {
        return new Mage(champName,100,100,100);
    }

}
