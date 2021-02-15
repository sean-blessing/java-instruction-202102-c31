import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Tip Calculator");
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			// get input - costOfMeal: BigDecimal
			// create bd from string
			System.out.println("Cost of meal? ");
			//String costOfMealStr = sc.next();
			BigDecimal costOfMeal = sc.nextBigDecimal();
			
			// biz logic - calculate tip and meal cost for 15%, 20%, 25%
			// try to use a for loop??
			NumberFormat percent = NumberFormat.getPercentInstance();
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			
			for (double d = .15; d <= .25; d+=.05) {
				System.out.println(percent.format(d));
				BigDecimal tipPct = new BigDecimal(d);
				BigDecimal tipAmt = costOfMeal.multiply(tipPct);
				System.out.println("Tip Amount:\t"+currency.format(tipAmt));
				BigDecimal total = costOfMeal.add(tipAmt);
				System.out.println("Total Amount:\t"+currency.format(total));
			}

			// display amounts
			
			System.out.println("Continue? (y/n)");
			choice = sc.next();
		}
		
		sc.close();
		System.out.println("Bye");

	}

}
