package ui;

import java.util.Arrays;

import business.User;
import db.DAO;
import db.UserList;
import util.Console;

public class PRSConsoleApp {
	private static DAO<User> userDAO = new UserList();

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS Console App!");
		
		int command = 0;
		
		while (!(command == 99)) {
			System.out.println("MENU:");
			System.out.println("=======================");
			System.out.println("1)\tList Users");
			System.out.println("2)\tAdd User");
			System.out.println("3)\tGet User By ID");
			System.out.println("99)\tExit");
			System.out.println();
			
			command = Console.getInt("Command? --> ", 0, 100);
			System.out.println();
			switch (command) {
			case 1:
				if (userDAO.getAll().isEmpty()) {
					System.out.println("User list is empty.. add some users!");
				}
				else {
					for (User u: userDAO.getAll()) {
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
				userDAO.add(u);
				System.out.println("User added!");
				break;
			case 3:
				id = Console.getInt("User ID to retrieve? ", 0, Integer.MAX_VALUE);
				User user = userDAO.getById(id);
				if (user != null) {
					System.out.println("User Found!!!");
					System.out.println(user);
				}
				else {
					System.out.println("No user found for id: "+id);
				}
				break;
			}
			
		}
		
		System.out.println("Bye");

	}

}
