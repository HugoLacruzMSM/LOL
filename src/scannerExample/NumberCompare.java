package scannerExample;

import java.util.Scanner;

public class NumberCompare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = input.nextInt();

        System.out.print("Enter the second number: ");
        int secondNumber = input.nextInt();

        if (firstNumber == secondNumber) {
            System.out.println(firstNumber + " is equal to " + secondNumber);
        }
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " is greater than " + secondNumber);
        }
        else {
            System.out.println(secondNumber + " is greater than " + firstNumber);
        }

        System.out.print("End");
        input.close();
    }
}
