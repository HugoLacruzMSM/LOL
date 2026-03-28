package hugo.lol.bases.estructurasdedatos.set;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {

        // HashSet: no duplicados, orden impredecible
        // cuando importa saber si esta
        HashSet<String> availableChamps = new HashSet<>();

        availableChamps.add("Jinx");
        availableChamps.add("Yasuo");
        availableChamps.add("Lux");
        availableChamps.add("Ahri");
        availableChamps.add("Jinx");

        System.out.println("Champions: " + availableChamps);
        // El orden no se sabe, no es el de add

        System.out.println("Jinx? " + availableChamps.contains("Jinx"));
        System.out.println("Zed? "  + availableChamps.contains("Zed"));

        availableChamps.remove("Yasuo");
        System.out.println("after remove: " + availableChamps);
    }
}
