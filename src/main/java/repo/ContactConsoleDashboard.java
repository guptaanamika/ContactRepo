package repo;

import java.util.Scanner;

public class ContactConsoleDashboard {

	public static void main(String[] args) {

		Contact trie = new Contact();
		while (true) {
			System.out.println("1.AddContact 2.Search 3.Exit");
			Scanner scan = new Scanner(System.in);

			int choice = Integer.valueOf(scan.nextLine());
			switch (choice) {
			case 1:
				System.out.print("Enter name:");
				String name = scan.nextLine();
				trie.addContact(name);
				break;
			case 2:
				System.out.print("Enter name:");
				String searchName = scan.nextLine();
				for (String contact : trie.searchContact(searchName))
					System.out.println(contact);
				break;
			case 3:
				System.out.println("Happy Searching");
				scan.close();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

}
