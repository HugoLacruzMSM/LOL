package bases.bucles;

public class Bucle {
    public static void main(String[] args) {

        final int MAX_GOLD = 5;
        for (int currentGold = 0;  currentGold <= MAX_GOLD; currentGold++) {
            System.out.println(currentGold);
        }
        System.out.println("Exit");

        int gold = 0;
        int totalGold = 0;

        while (gold < 5) {
            System.out.println(gold);
            totalGold = totalGold +gold;
            gold++;
        }
        System.out.println("Salida"+ totalGold);

        do{
            System.out.println(gold);
            gold++;
        }while (gold == 10);
    }
}
