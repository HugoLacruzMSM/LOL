package hugo.lol.bases.estructurasdedatos.array;

import java.util.ArrayList;
import java.util.Collections;

public class DinamicArray {
    public static void main(String[] args) {

        // ArrayList: tamaño VARIABLE, crece automáticamente
        ArrayList<Integer> championsKills = new ArrayList<>();

        // add añade al final, el tamaño crece solo
        championsKills.add(8);
        championsKills.add(6);
        championsKills.add(4);
        championsKills.add(9);
        championsKills.add(5);

        System.out.println("Champion kills before: " + championsKills);
        System.out.println("Total champions: " + championsKills.size());

        Integer minNota = Collections.min(championsKills);
        championsKills.remove(minNota);// con remove borro por valor (no por indice)

        System.out.println("Champions kills after delete min champion kills: " + championsKills);

        int sum = 0;
        for (int championKills : championsKills) {
            sum += championKills;
        }

        double average = (double) sum / championsKills.size();
        System.out.println("Final average: " + average);
    }
}
