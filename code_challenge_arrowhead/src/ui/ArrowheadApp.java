package ui;

import util.Console;

public class ArrowheadApp {

	public static void main(String[] args) {
		System.out.println("Arrowhead App!");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int size = Console.getInt("Enter size of arrowhead to create: ", 0, Integer.MAX_VALUE);
			int midpoint = size/2 + 1;
			
			// top half of arrowhead
			// outer for loop = rows
			for (int i=0; i <= midpoint; i++) {
				// build each row, c refers to characters per line
				String row = "";
				// building the line
				for (int c=1; c<=i; c++) {
					row +=">";
				}
				System.out.println(row);
			}
			
			// bottom half of arrowhead
			// midpoint line already printed
			for (int i=(midpoint-1); i > 0; i--) {
				String row = "";
				for (int c = 1; c <= i; c++) {
					row += ">";
				}
				System.out.println(row);
			}
			choice = Console.getChoiceString("Go again? ", "y", "n");
		}
		
		System.out.println("Bye");

	}

}
