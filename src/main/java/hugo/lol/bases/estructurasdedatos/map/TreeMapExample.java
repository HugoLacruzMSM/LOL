package hugo.lol.bases.estructurasdedatos.map;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {

        // claves ordenadas alfabéticamente
        TreeMap<String, String> roles = new TreeMap<>();

        roles.put("Yasuo", "Mid");
        roles.put("Ahri", "Mid");
        roles.put("Darius", "Top");
        roles.put("Jinx", "ADC");
        roles.put("Thresh", "Support");

        System.out.println("Roles: " + roles);
        System.out.println("First: " + roles.firstKey());
        System.out.println("Last: " + roles.lastKey());
        System.out.println("Before Jinx: " + roles.headMap("Jinx"));
    }
}