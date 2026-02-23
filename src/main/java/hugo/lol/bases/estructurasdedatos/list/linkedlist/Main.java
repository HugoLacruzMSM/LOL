package hugo.lol.bases.estructurasdedatos.list.linkedlist;

import hugo.lol.entity.Champion;
import hugo.lol.entity.healer.Healer;
import hugo.lol.entity.mage.Mage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Healer> healers = new LinkedList<>();
        healers.add(createChamp("Manolo"));
        healers.add(createChamp("Hugo"));
        healers.add(createChamp("Juanra"));
        healers.add(createChamp("Dani"));

        ((LinkedList<Healer>)healers).addFirst(createChamp("CR7"));
        healers.removeLast();
        System.out.println(healers);
    }

    static Healer createChamp(String champName) {
        return new Healer(champName,"Healer",100,100,100);
    }
}
