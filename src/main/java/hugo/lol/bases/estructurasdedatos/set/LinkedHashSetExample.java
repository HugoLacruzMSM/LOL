package hugo.lol.bases.estructurasdedatos.set;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        // LinkedHashSet: no duplicados y orden de add
        // para no duplicados y orden de add
        LinkedHashSet<String> picks = new LinkedHashSet<>();

        picks.add("Ahri");
        picks.add("Thresh");
        picks.add("Jinx");
        picks.add("Darius");
        picks.add("Ahri");

        System.out.println("Picks: " + picks);

        System.out.println(picks.size());
    }
}
