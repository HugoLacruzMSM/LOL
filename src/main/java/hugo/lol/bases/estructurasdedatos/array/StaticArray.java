package hugo.lol.bases.estructurasdedatos.array;

public class StaticArray {
        public static void main(String[] args) {

            // Array estático: tamaño FIJO al crearlo
            int[] bag = {5, 10, 20, 20, 20};

            int money = 0;
            for (int nota : bag) {
                money += nota;
            }

            double average = (double) money / bag.length;
            System.out.println("Average: " + average);

            if (average >= 50) {
                System.out.println("Can buy item");
            } else {
                System.out.println("Can't buy item");
            }

            // bag[5] = 7; → ArrayIndexOutOfBoundsException
        }
}
