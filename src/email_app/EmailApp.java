package email_app;

import java.util.Scanner;

public class EmailApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// User info
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();

		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();

		// Creating object of Email class
		Email em = new Email(firstName, lastName);

		int choice = -1;

		do {
			System.out.println(
					"\n***\nEnter your choice \n1.Show info \n2.Change password \n3.Change mailbox capacity \n4.Set alternate mail \n5.Store data in file \n6.Display data from file \n7.Exit");

			choice = sc.nextInt();
			switch (choice) {

			case 1:
				em.getInfo();
				break;
			case 2:
				em.setPassword();
				break;
			case 3:
				em.setMailCapacity();
				break;
			case 4:
				em.setAlternateMail();
				break;
			case 5:
				em.storeFile();
				break;
			case 6:
				em.readFile();
				break;
			case 7:
				System.out.println("Thank you for using application!");
				break;
			default:
				System.out.println("Invalid choice, enter valid choice!");
			}

		} while (choice != 7);

		// closing Scanner
		sc.close();

	}

}
