package hugo.lol.bases.estructurasdedatos.map;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        // HashMap: clave → valor, sin orden, búsqueda O(1)
        //consultar datos rapidamente
        HashMap<String, Integer> health = new HashMap<>();

        health.put("Jinx", 560);
        health.put("Darius", 980);
        health.put("Lux", 490);
        health.put("Thresh", 700);
        health.put("Jinx", 600);

        System.out.println("Health: " + health);

        // clave
        System.out.println("Darius: " + health.get("Darius"));

        // existe
        System.out.println("exists Zed " + health.containsKey("Zed"));

        // foreach
        for (var entrada : health.entrySet()) {
            System.out.println(entrada.getKey() + " has " + entrada.getValue() + " HP");
        }

        health.remove("Lux");
        System.out.println("Lux: " + health);

        System.out.println("Zed: " + health.getOrDefault("Zed", 0));
    }
}
