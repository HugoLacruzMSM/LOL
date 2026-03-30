package hugo.lol.bases.estructurasdedatos.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    public static void main(String[] args) {

        List<String> arrayListExample   = new ArrayList<>();
        List<String> linkedListExample  = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrayListExample.add("Campeon " + i);
            linkedListExample.add("Campeon " + i);
        }

        // por índice (ArrayList mejor)
        long inicio = System.nanoTime();
        arrayListExample.get(50000);
        System.out.println("ArrayList: " + (System.nanoTime() - inicio) + " ns");

        inicio = System.nanoTime();
        linkedListExample.get(50000); // 50.000 nodos
        System.out.println("LinkedList: " + (System.nanoTime() - inicio) + " ns");

        // add (LinkedList mejpor)
        inicio = System.nanoTime();
        arrayListExample.add(0, "Nuevo");
        System.out.println("ArrayList: " + (System.nanoTime() - inicio) + " ns");

        inicio = System.nanoTime();
        ((LinkedList<String>) linkedListExample).addFirst("Nuevo");
        System.out.println("LinkedList: " + (System.nanoTime() - inicio) + " ns");
    }
}
