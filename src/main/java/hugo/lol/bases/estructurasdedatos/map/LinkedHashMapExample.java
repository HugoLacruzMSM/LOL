package hugo.lol.bases.estructurasdedatos.map;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {

        // mantiene el orden de inserción
        LinkedHashMap<String, Integer> kills = new LinkedHashMap<>();

        kills.put("Darius", 3);
        kills.put("Jinx", 7);
        kills.put("Ahri", 5);
        kills.put("Yasuo", 2);

        System.out.println("Kills: " + kills);

        // actualizar kills
        kills.put("Jinx", kills.get("Jinx") + 1);
        System.out.println("Updated kills: " + kills);

        // MVP
        String mvp = null;
        int maxKills = 0;
        for (var entry : kills.entrySet()) {
            if (entry.getValue() > maxKills) {
                maxKills = entry.getValue();
                mvp = entry.getKey();
            }
        }
        System.out.println("MVP: " + mvp + " with " + maxKills + " kills");
    }
}