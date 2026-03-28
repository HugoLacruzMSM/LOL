package hugo.lol.bases.estructurasdedatos.map;

import java.util.*;

public class MapComparison {
    public static void main(String[] args) {

        // mismos datos, tres comportamientos distintos
        List<String[]> data = List.of(
            new String[]{"Yasuo", "Mid"},
            new String[]{"Ahri", "Mid"},
            new String[]{"Darius", "Top"},
            new String[]{"Jinx", "ADC"}
        );

        Map<String, String> hashMap       = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> treeMap       = new TreeMap<>();

        for (String[] entry : data) {
            hashMap.put(entry[0], entry[1]);
            linkedHashMap.put(entry[0], entry[1]);
            treeMap.put(entry[0], entry[1]);
        }

        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}