import java.util.Scanner;

public class GradeConverterApp {
    
    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Letter Grade Converter");
        System.out.println();  // print a blank line

        // create the Scanner object
        Scanner sc = new Scanner(System.in);

        // perform conversions until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get numerical grade from user
            System.out.print("Enter numerical grade: ");
            int numericalGrade = sc.nextInt();

            // convert numerical grade to letter grade
            String letterGrade = "";
            if (numericalGrade >= 88)
                letterGrade = "A";
            else if (numericalGrade >= 80)
                letterGrade = "B";
            else if (numericalGrade >= 67)
                letterGrade = "C";
            else if (numericalGrade >= 60)
                letterGrade = "D";
            else
                letterGrade = "F";

            // display the result of the conversion
            System.out.println("Letter grade: " + letterGrade + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
        sc.close();
    }
}