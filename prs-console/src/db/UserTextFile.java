package db;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserTextFile implements DAO<User> {
	private static final String USER_FILE_NAME = "users.txt";
	List<User> users = new ArrayList<>();
	
	public UserTextFile() {
		// fill user list with users from text file
		getAll();
	}

	@Override
	public User getById(int id) {
//		User u = null;
//		for (User user: users) {
//			if (user.getId()==id) {
//				u = user;
//			}
//		}
//		return u;
		
		// another way
		for (User user: users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		if (users.size()==0) {
			try {
				BufferedReader in = new BufferedReader(
									new FileReader(USER_FILE_NAME));
				String line = in.readLine();
				while (line != null) {
					// this is ORM in core Java!
					String[] fields = line.split("\t");
					// after split we should have 9 fields per line
					String idStr = fields[0];
					int id = Integer.parseInt(idStr);
					String un = fields[1];
					String pwd = fields[2];
					String fn = fields[3];
					String ln = fields[4];
					String pn = fields[5];
					String em = fields[6];
					String rvStr = fields[7];
					boolean rv = Boolean.parseBoolean(rvStr);
					String admStr = fields[8];
					boolean adm = Boolean.parseBoolean(admStr);
					
					User u = new User(id, un, pwd, fn, ln, pn, em, rv, adm);
					users.add(u);
					
					//get the next line in the file
					line = in.readLine();
				}
				in.close();
			}
			catch (Exception e) {
				System.out.println("Error getting user records from file.");
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public boolean add(User u) {
		users.add(u);
		return saveAll();
	}

	@Override
	public boolean update(User u) {
		// not yet implemented
		return false;
	}

	@Override
	public boolean delete(User u) {
		users.remove(u);
		return saveAll();
	}
	
	// this method will be called for any maintence function (add, update, delete)
	private boolean saveAll() {
		boolean success = true;
		Path usersPath = Paths.get(USER_FILE_NAME);
		File usersFile = usersPath.toFile();
		
		try (PrintWriter out = new PrintWriter(
							  new BufferedWriter(
							  new FileWriter(usersFile)))) {
			for (User u: users) {
				out.print(u.getId()+"\t");
				out.print(u.getUserName()+"\t");
				out.print(u.getPassword()+"\t");
				out.print(u.getFirstName()+"\t");
				out.print(u.getLastName()+"\t");
				out.print(u.getPhoneNumber()+"\t");
				out.print(u.getEmail()+"\t");
				out.print(u.isReviewer()+"\t");
				out.println(u.isAdmin());				
			}			
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

}
