package ui;

import java.util.Arrays;

import business.User;
import util.Console;

public class PRSConsoleApp {
	private static User[] users;

	public static void main(String[] args) {
		System.out.println("Welcome tot the PRS Console App!");
		
		int command = 0;
		
		while (!(command == 99)) {
			System.out.println("MENU:");
			System.out.println("=======================");
			System.out.println("1)\tList Users");
			System.out.println("2)\tAdd User");
			System.out.println("99)\tExit");
			System.out.println();
			
			command = Console.getInt("Command? --> ", 0, 100);
			System.out.println();
			switch (command) {
			case 1:
				if (users==null) {
					System.out.println("User list is null.. add some users!");
				}
				else {
					for (User u: users) {
						System.out.println(u);
					}
				}
				break;
			case 2:
				int id = Console.getInt("Id? ", 0, Integer.MAX_VALUE);
				String un = Console.getRequiredString("User Name? ");
				String pw = Console.getRequiredString("Password? ");
				String fn = Console.getRequiredString("First Name? ");
				String ln = Console.getRequiredString("Last Name? ");
				String pn = Console.getRequiredString("Phone Number? ");
				String em = Console.getRequiredString("Email? ");
				String adm = Console.getChoiceString("Admin? (y/n) ", "y", "n");
				String rvw = Console.getChoiceString("Reviewer? (y/n) ", "y", "n");
				boolean admin = (adm.equalsIgnoreCase("y")) ? true: false;
				boolean reviewer = (rvw.equalsIgnoreCase("y")) ? true: false;
				
				User u = new User(id, un, pw, fn, ln, pn, em, admin, reviewer);
				addUserToList(u);
				System.out.println("User added!");
			}
			
		}
		
		System.out.println("Bye");

	}

	private static void addUserToList(User u) {
		// 1. expand list of users by 1
		if (users!=null)
			users = Arrays.copyOf(users, users.length);
		else
			users = new User[1];
		
		// 2. add u to end of list
		users[users.length-1] = u;
		
	}

}
