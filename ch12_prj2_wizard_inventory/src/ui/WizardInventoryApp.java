package ui;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class WizardInventoryApp {
	// intialize list of 'items': ArrayList<String>
	// defining items as a 'List' demonstrates polymorphism!!!!
	private static List<String> items = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome to the Wizard Inventory App!!!");
		//put 3 starting items in 'items'
		items.add("wooden staff");
		items.add("wizard hat");
		items.add("cloth shoes");
		
		String command = "";
		
		// while loop start
		while (!command.equalsIgnoreCase("exit")) {
			// display command menu
			System.out.println("COMMAND MENU:");
			System.out.println("show - show all items");
			System.out.println("grab - grab an item");
			System.out.println("edit - edit an item");
			System.out.println("drop - remove an item");
			System.out.println("exit - exit app");
			// prompt user for 'command'
			String[] validEntries = {"show","grab","edit","drop","exit"};
			command = Console.getChoiceString("COMMAND:  ", validEntries);
			
			// determine the command to perform
			switch (command) {
			case "show":
				// show - show all items - loop through 'items' and display each
				//			NOTE: item # is NOT the index #, its index + 1
				for (int i = 0; i < items.size(); i++) {
					System.out.println((i+1)+". "+items.get(i));
				}
				break;
			case "grab":
				// check # of items.  max is 4
				if (items.size()>=4) {
					System.out.println("Max items reached.  Drop an item before adding.");
				}
				else {
					// grab - grab an item (add new item to 'items')
					//			Prompt user for new item name and add to 'items'
					String name = Console.getRequiredString("Name: ");
					items.add(name);
					System.out.println(name+ " was added.");
				}
				break;
			case "edit":
				// edit - change the name of an item
				//			Prompt user for item #, validate that item #
				int itemNbr = Console.getInt("Number: ", 0, (items.size()+1));
				//			Prompt user for updated name, save that in the list
				if (validateItemNumber(itemNbr)) {
					String updName = Console.getRequiredString("Updated name: ");
					items.set((itemNbr-1), updName);
					System.out.println("Item "+itemNbr+" was updated.");
					//			"Item x was updated"
				}
				else {
					System.out.println("Item nbr not valid.");
				}
				break;
			case "drop":
				// drop - drop an item (remove from 'items')
				//			Prompt user for item #, validate that item #
				itemNbr = Console.getInt("Number: ", 0, (items.size()+1));
				if (validateItemNumber(itemNbr)) {
					//			Remove item from list and capture item name
					//			"'Item name' was dropped"
					String droppedItem = items.remove(itemNbr-1);
					System.out.println(droppedItem+" was dropped.");
				}
				else {
					System.out.println("Item nbr not valid.");
				}
				break;
			case "exit":
				// exit - exit the app
				break;
			default:
				System.out.println("Invalid command, try again.");
				break;
			}
		}
		
		System.out.println("Bye");

	}
	
	// because our item numbers start at zero the index will
	// always be 1 less than item number
	private static boolean validateItemNumber(int itemNbr) {
		return (items.get(itemNbr - 1) != null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
