package quanquen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import quanquen.model.*;

public class Setup {
	public static void main(String[] args) {

		// Begin - Setup default group
		/*
		 * LinkedHashSet<String> adminPermission = new LinkedHashSet<String>();
		 * adminPermission.add("admin"); adminPermission.add("member"); Group
		 * adminGroup = new Group("admin", new LinkedHashSet<Member>(),
		 * adminPermission); LinkedHashSet<String> memberPermission = new
		 * LinkedHashSet<String>(); memberPermission.add("member"); Group
		 * memberGroup = new Group("member", new LinkedHashSet<Member>(),
		 * memberPermission);
		 * 
		 * pm.makePersistent(adminGroup); pm.makePersistent(memberGroup);
		 */
		// End - Setup default group

		// Close PersistenceManager
		// pm.close();
		Setup.addMember();
	}

	public static void addGroup() {
		// Create scanner for input.
	}

	public static void addMember() {
		// Scanner for input
		Scanner in = new Scanner(System.in);

		// Welcome
		System.out.println("Add Member!");

		// Read username
		System.out.print("Username: ");
		String username = in.nextLine();

		// Read password
		System.out.print("Password: ");
		String password = Setup.md5(in.nextLine());

		// Read email
		System.out.print("Email: ");
		String email = in.nextLine();

		// Read birthday
		System.out.print("Birthday (dd mm yy): ");
		int dayOfMonth = in.nextInt();
		//System.out.println(dayOfMonth);
		int month = in.nextInt();
		//System.out.println(month);
		int year = in.nextInt();
		//System.out.println(year);
		Date birthday = new Date(year, month, dayOfMonth);
		in.nextLine();

		// Choose member group
		System.out.print("Member group: ");
		String groupName = in.nextLine();

		// Set activation
		System.out.print("Is actived: ");
		boolean isActive = in.nextBoolean();
		in.nextLine();

		// Last comfirm
		System.out.print("Just do it? (yes/no) ");
		String status = in.nextLine();

		// Start jobs
		if (status.toLowerCase().equals("yes")
				|| status.toLowerCase().equals("y")) {
			// Setup PersistenceManager for Datastore functions
			PersistenceManagerFactory pmf = JDOHelper
					.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			// Begin - transaction
			tx.begin();
			// Get group
			Query q1 = pm.newQuery(quanquen.model.Group.class);
			q1.setFilter("name == n");
			q1.declareParameters("String n");
			q1.compile();
			List<Group> r1 = (List<Group>) q1.execute(groupName);
			Group mG;
			// If no group found, set to member group.
			if (r1.size() <= 0) {
				// Try getting group named member
				List<Group> r12 = (List<Group>) q1.execute("member");
				if (r12.size() > 0) {
					mG = r12.get(0);
				} else {
					LinkedHashSet<String> permissions = new LinkedHashSet<String>();
					permissions.add("member");
					mG = new Group("member", new LinkedHashSet<Member>(),
							permissions);
				}
			} else
				mG = r1.get(0);
			Member m = new Member(username, password, email, birthday, mG,
					isActive);
			pm.makePersistent(m);
			tx.commit();
			pm.close();
			System.out.println("Member added!");
			// End - transaction
		}
	}

	public static String md5(String input) {
		String res = "";

		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(input.getBytes());

			byte[] md5 = algorithm.digest();
			String tmp = "";

			for (int i = 0; i < md5.length; i++) {
				tmp = (Integer.toHexString(0xFF & md5[i]));

				if (tmp.length() == 1) {
					res += "0" + tmp;
				} else {
					res += tmp;
				}
			}
		} catch (NoSuchAlgorithmException ex) {
		}
		return res;
	}

}
