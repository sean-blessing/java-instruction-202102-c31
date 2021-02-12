import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class MPGApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Miles Per Gallon calculator");
        System.out.println();  // print a blank line
        
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            double miles = sc.nextDouble();
            
            System.out.print("Enter gallons of gas used: ");
            double gallons = sc.nextDouble();
            
            double mpg = miles/gallons;
            // round to 2 decimal places - old school method
            //mpg = (double)Math.round(mpg*100)/100;

            // round to 3 decimal places using NumberFormat
            //NumberFormat nbr  = NumberFormat.getNumberInstance();
            // round to 2 decimal places
            //nbr.setMaximumFractionDigits(2);
            
            // use  big decimal to divide and round
            BigDecimal milesBD = new BigDecimal(miles);
            BigDecimal gallonsBD = new BigDecimal(gallons);
            
            BigDecimal mpgBD = milesBD.divide(gallonsBD, 2, RoundingMode.HALF_UP);
            
            System.out.println("Miles per gallon is " + mpgBD + ".");
            System.out.println(); 
            
            System.out.print("Calculate another MPG? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
    
}
