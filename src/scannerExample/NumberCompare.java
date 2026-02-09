package scannerExample;

import java.util.Scanner;

import static utils.Utils.add;
import static utils.Utils.difference;

public class NumberCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int firstNumber = getNumber(input,"Enter the first number: ");
        int secondNumber = getNumber(input,"Enter the second number: ");

        printArithmeticOptions(firstNumber, secondNumber);

        compareNumbers(firstNumber, secondNumber);

        System.out.print("End");
        input.close();
    }
    public static int getNumber(Scanner scanner, String message){
        System.out.println(message);
        return scanner.nextInt();
    }

    public static void printArithmeticOptions(int a, int b){
        System.out.println("the sum a + b is: " + add(a,b));
        System.out.println("The difference a - b is: " + difference(a,b));
    }

    public static void compareNumbers(int first, int second){
        if (first == second) {
            System.out.println(first + " is equal to " + second);
        }
        if (first > second) {
            System.out.println(first + " is greater than " + second);
        }
        else {
            System.out.println(second + " is greater than " + first);
        }
    }
}
