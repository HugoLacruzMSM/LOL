package hugo.lol.bases.estructurasdedatos.list.linkedlist;

import hugo.lol.entity.healer.Healer;

import java.util.LinkedList;

public class ExampleLinkedList {
    public static void main(String[] args) {
        LinkedList<Healer> healers = new LinkedList<>();
        healers.add(createChamp("Manolo"));
        healers.add(createChamp("Hugo"));
        healers.add(createChamp("Juanra"));
        healers.add(createChamp("Dani"));

        System.out.println(healers+"\n");

        healers.addFirst(createChamp("Ahri"));
        System.out.println("Ahri: " + healers);

        Healer first = healers.removeFirst();
        System.out.println(first + "\n");
        System.out.println(healers+"\n");

        healers.addLast(createChamp("Darius"));
        System.out.println("Darius last:");

        // Acceso por índice: O(n) tiene que recorrer nodo a nodo
        System.out.println("Campeón en posición 2: " + healers.get(2));
    }

    static Healer createChamp(String champName) {
        return new Healer(champName,100,100,100);
    }
}
