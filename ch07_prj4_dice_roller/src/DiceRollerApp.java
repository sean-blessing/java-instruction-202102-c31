import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the dice roller app!");
		Scanner sc = new Scanner(System.in);
		System.out.print("Roll the dice? (y/n) ");
		String choice = sc.next();
		
		while (choice.equalsIgnoreCase("y")) {
			// create instance of Dice
			Dice dice = new Dice();
			// roll the dice
			dice.roll();
			// print result
			System.out.println(dice.getRollResultString());
					
			System.out.print("Roll again (y/n)? ");
			choice = sc.next();
		}
		
		
		
		sc.close();
		System.out.println("Bye");

	}

}
