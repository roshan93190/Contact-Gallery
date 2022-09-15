package com.masai;

import java.util.ArrayList;

public class MobilePhone {
	
	private String myNumber;
	private ArrayList <Contacts> myContacts;
	
	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contacts>();
	}
	
	
	// Adding a new contact
	public boolean addNewContact(Contacts contact) {
		
		// Before adding a contact we are checking that its exist or not
		
		if(findContact(contact.getName()) >= 0) {
			System.out.println("Contact is already on file");
		}
		
		//If Not exist then add our contact
		myContacts.add(contact);
		return true;
	}
	
	//Update Contact using set method
	public boolean updateContact(Contacts oldContact , Contacts newContact) {
		int foundPosition = findContact(oldContact);
		if(foundPosition < 0) {
			System.out.println(oldContact.getName() + " , was not found");
			return false;
		}
		
		this.myContacts.set(foundPosition, newContact);
		System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
		return true;
	}
	
	// Remove Contact
	public boolean removeContact(Contacts contact) {
		int foundPosition = findContact(contact);
		if(foundPosition < 0) {
			System.out.println(contact.getName() + " , was not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		System.out.println(contact.getName() + " was deleted");
		return true;
	}
	
	
	// Find Contact Position
	private int findContact(Contacts contact) {
		return this.myContacts.indexOf(contact);
	}
	
	// Find Contact Names
	private int findContact(String contactName) {
		 for(int i =0; i < myContacts.size(); i++) {
			 // Creating another temporary object to hold the name and compare
			 Contacts contacts = this.myContacts.get(i);
			 if(contacts.getName().equals(contactName)) {
				 return i;
			 }
		 }
		 return -1;
	}
	
	// query contact
	public String queryContact(Contacts contact) {
		if(findContact(contact) >= 0) {
			return contact.getName();
		}
		return null;
	}
	
	public Contacts queryContact(String name) {
		int position = findContact(name);
		if(position >=0) {
			return this.myContacts.get(position);
		}
		return null;
	}
	
	
	public void printContacts() {
		System.out.println("Contact list");
		for(int i = 0; i < this.myContacts.size(); i++) {
			System.out.println((i+1) + " ." + 
								this.myContacts.get(i).getName() + 
								" -> " + this.myContacts.get(i).getPhoneNumber());
		}
	}
 
}