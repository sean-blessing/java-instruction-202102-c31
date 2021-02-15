import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the change calculator!");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			// prompt for cents: int
			System.out.println("Enter number of cents (0-99): ");
			int cents = sc.nextInt();
			
			// biz logic - calculate quarters, dimes, nickels and pennies as ints
			int quarters = cents / 25;
			cents = cents % 25;
			int dimes = cents / 10;
			cents = cents % 10;
			int nickels = cents / 5;
			cents = cents %5;
			int pennies = cents;
			
			// display values of all variables above
			System.out.println("Quarters: "+quarters);
			System.out.println("Dimes:    "+dimes);
			System.out.println("Nickels:  "+nickels);
			System.out.println("Pennies:  "+pennies);
			
			System.out.println("Continue (y/n)? ");
			choice = sc.next();
		}
		
		sc.close();
		System.out.println("Bye");
	}

}
