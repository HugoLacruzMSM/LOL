package main.bases.grades;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            boolean repeat;
            do{
                System.out.print("Enter Student age ");
                int studentAge = input.nextInt();
                System.out.print("Enter the first grade ");
                int studentFirstGrade = input.nextInt();
                System.out.print("Enter the second grade ");
                int studentSecondGrade = input.nextInt();
                System.out.print("Enter the third grade ");
                int studentThirdGrade = input.nextInt();

                int sumGrades = studentFirstGrade + studentSecondGrade+ studentThirdGrade;
                double gradeAverage =  sumGrades / 3.0;

                System.out.println("The average at the grade is " + gradeAverage);
                if(gradeAverage >= 6) {
                    System.out.println("Approved");
                }else {
                    System.out.println("Rejected");
                }
                System.out.print("Do you want to repeat? 1 for yes 0 for no ");
                repeat = (input.nextInt() == 1);

        }while (repeat);
            System.out.print("END");
            input.close();


        }catch (Exception e){
            throw new RuntimeException("Invalid Input: "+ e.getMessage());
        }

    }
}
