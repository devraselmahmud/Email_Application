package email_app;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {

	Scanner sc = new Scanner(System.in); // Creating global Scanner class

	// Creating some private instance variables to not access directly
	private String firstName;
	private String lastName;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity = 700;
	private String alter_email;

	// Constructor to receive first name and last name
	public Email(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

		System.out.println("New Employee: " + this.firstName + " " + this.lastName);

		// calling methods
		this.dept = this.setDept(); // Department
		this.password = this.generatePassword(12); // Password
		this.email = this.generateEmail(); // Email generation

	}

	// Generate email method
	private String generateEmail() {
		return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.dept.toLowerCase() + "."
				+ "returncontinue.com";
	}

	// Asking employee for department
	private String setDept() {

		System.out.println("Department Code : \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");

		boolean flag = false;

		// print at least once
		do {

			System.out.println("Enter Department Code: ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 0:
				return "None";
			default:
				System.out.println("Invalid choice, please enter the code again!");

			}

		} while (!flag);

		return null;
	}

	// Generate password method
	private String generatePassword(int length) {

		Random random = new Random();
		String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallChars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%&?";
		String values = capitalChars + smallChars + numbers + symbols;
		String password = "";

		for (int i = 0; i < length; i++) {
			password = password + values.charAt(random.nextInt(values.length()));
		}

		return password;
	}

	// Change password method
	public void setPassword() {
		boolean flag = false;

		do {
			System.out.println("Do you want to change your password? (Y/N)");
			char choice = sc.next().charAt(0);

			if (choice == 'Y' || choice == 'y') {
				flag = true;
				System.out.println("Enter current password: ");

				String temp = sc.nextLine();

				if (temp.equals(this.password)) {
					System.out.println("Enter new password: ");
					this.password = sc.nextLine();
					System.out.println("Password changed successfully");
				} else {
					System.out.println("Incorrect Password!");
				}
			} else if (choice == 'N' || choice == 'n') {
				flag = true;
				System.out.println("Password change option cancelled!");
			} else {
				System.out.println("Enter valid choice: ");
			}
		} while (!flag);
	}

	// Set mailbox capacity
	public void setMailCapacity() {
		System.out.println("Current mailbox capacity: " + this.mailCapacity + " mb");
		System.out.println("Enter new mailbox capacity: ");

		this.mailCapacity = sc.nextInt();
		System.out.println("Mailbox capacity is successfully updated");
	}

	// Set alternate mail
	public void setAlternateMail() {
		System.out.println("Enter new alternate email: ");
		this.alter_email = sc.nextLine();
		System.out.println("Alternate email is set");
	}

	// Display information
	public void getInfo() {
		System.out.println("Name: " + this.firstName + " " + this.lastName);
		System.out.println("Department: " + this.dept);
		System.out.println("Email: " + this.email);
		System.out.println("Password: " + this.password);
		System.out.println("Mailbox Capacity: " + this.mailCapacity);
		System.out.println("Alternate Email: " + this.alter_email);
	}

	// Store in file
	public void storeFile() {
		try {
			FileWriter fw = new FileWriter("info.txt");
			fw.write("First name: " + this.firstName);
			fw.append("\nLast name: " + this.lastName);
			fw.append("\nEmail: " + this.email);
			fw.append("\nPassword: " + this.password);
			fw.append("\nCapacity: " + this.mailCapacity);
			fw.append("\nAlternate Email: " + this.alter_email);
			// closing file writer
			fw.close();

			System.out.println("Data Stored...");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Reading file method
	public void readFile() {
		try {
			FileReader fr = new FileReader("info.txt");
			int i;
			// unless empty
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
			
			// closing file reader
			fr.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
