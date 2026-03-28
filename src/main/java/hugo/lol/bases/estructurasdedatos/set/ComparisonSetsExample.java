package hugo.lol.bases.estructurasdedatos.set;

import java.util.*;

public class ComparisonSetsExample {
    public static void main(String[] args) {

        List<String> campeones = List.of("Yasuo", "Ahri", "Jinx", "Darius", "Ahri", "Yasuo");

        Set<String> hashSet       = new HashSet<>(campeones);
        Set<String> linkedHashSet = new LinkedHashSet<>(campeones);
        Set<String> treeSet       = new TreeSet<>(campeones);

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet " + treeSet);
    }
}
