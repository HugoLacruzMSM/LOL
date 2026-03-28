package hugo.lol.bases.estructurasdedatos.set;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        // TreeSet: no duplicados y orden automáticamente
        TreeSet<String> champs = new TreeSet<>();

        champs.add("Yasuo");
        champs.add("Ahri");
        champs.add("Darius");
        champs.add("Jinx");
        champs.add("Lux");
        champs.add("Ahri");

        System.out.println(champs);

        System.out.println("First: " + champs.first());
        System.out.println("Last: "  + champs.last());

        System.out.println("Before Lux: " + champs.headSet("Lux"));

        System.out.println("After Jinx: " + champs.tailSet("Jinx"));
    }
}
