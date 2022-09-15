package com.masai;


import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	// Creating an instant with a default Number
	private static MobilePhone mobilePhone = new MobilePhone("000 443 876");

	public static void main(String[] args) {	
				
		boolean quite = false;
		startPhone();
		printAction();
		while(!quite) {
			System.out.println("\n Enter action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch (action) {
			case 0:
				System.out.println("\n Shuting down .. ");
				quite = true;
				break;
				
			case 1:
				mobilePhone.printContacts();
				break;
				
			case 2:
				addNewContact();
				break;
				
			case 3: 
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printAction();
				break;

			 
			}
			
				
			
		}

	}
	private static void addNewContact() {
		System.out.println("Enter new Contact Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter phone Number: ");
		String phone = scanner.nextLine();
		Contacts newContact = Contacts.createContact(name, phone);
		if(mobilePhone.addNewContact(newContact)) {
			System.out.println("New Contact Added: name = "+ name + " , phone" + phone );
		}else {
			System.out.println("Can't add, " + name +" already on file");
		}
	}
	
	
	private static void updateContact() {
		System.out.println("Enter existing contact name : ");
		String name = scanner.nextLine();
		Contacts extContact = mobilePhone.queryContact(name);
		if(extContact == null) 
		{
			System.out.println("Cannot found contact");
			return;
		}
		
		System.out.println("Enter new Conatct Name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new Phone Number: ");
		String newNumber = scanner.nextLine();
		
		Contacts newContact = Contacts.createContact(newName, newNumber);
		if(mobilePhone.updateContact(extContact, newContact)) 
		{
			System.out.println("Successfully updated");
		}else {
			System.out.println("Error Updating Contact");
		}
	}
	
	private static void removeContact() {
		System.out.println("Enter existing contact name : ");
		String name = scanner.nextLine();
		Contacts extContact = mobilePhone.queryContact(name);
		if(extContact == null) 
		{
			System.out.println("Cannot found contact");
			return;
		}
		
		if(mobilePhone.removeContact(extContact)) {
			System.out.println("Successfully deleted");
		}else {
			System.out.println("Error Deleting Contact");
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter existing contact name : ");
		String name = scanner.nextLine();
		Contacts extContact = mobilePhone.queryContact(name);
		if(extContact == null) 
		{
			System.out.println("Cannot found contact");
			return;
		}
		
		System.out.println("Name : " + extContact.getName() + 
				           " Phone Number is: " + extContact.getPhoneNumber());
	}
	
	
	private static void startPhone() {
		System.out.println("Starting Phone . . .");
	}
	
	private static void printAction() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("0 - to shutDown\n" + 
						"1 - to print contacts\n"+
						"2 - to add a new contact\n"+
						"3 - to update an existing contact\n"+
						"4 - to remove and existing contact\n"+
						"5 - query for existing contact\n"+
						"6 - to print a list of available actions.");
				System.out.println("Choose Your Action: ");
	}

}