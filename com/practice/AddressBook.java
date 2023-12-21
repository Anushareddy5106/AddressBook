package com.practice;

import java.util.*;

public class AddressBook {

    public static Scanner scanner = new Scanner(System.in);
    String name;
    ArrayList<Contact> contactList;

    AddressBook(String name) {
        this.contactList = new ArrayList<Contact>();
        this.name = name;
    }

    public void display() {
        if (contactList.size() == 0) {
            System.out.println("<----- Your Address Book is empty ----->");
        }

        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("-------------");
            System.out.println("Contact " + (i + 1) + ": ");
            System.out.println("-------------");
            contactList.get(i).displayContact();
        }
    }

    // UC2

    public void add(Contact contact) {
        contactList.add(contact);
        System.out.println("** Contact is added to  the Address Book **");
    }

    // UC3
    public void edit() {

        System.out.println("Enter Firstname:");
        String firstN = scanner.nextLine();
        System.out.println("Enter Lastname:");
        String lastN = scanner.nextLine();

        int found = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).firstName.equals(firstN) && contactList.get(i).lastName.equals(lastN)) {
                System.out.println("your Contact do exit");
                System.out.println("enter the Contact details to edit");

                Contact editContact = new Contact();
                contactList.set(i, editContact);

                System.out.println("** Contact is edited in the Address Book **");
                found = 1;
                break;
            }
        }

        if (found == 0) {
            System.out.println("** Contact you are trying to edit is not found **");
        }

    }

    // UC4
    public void delete() {
        System.out.println("Enter Firstname:");
        String firstN = scanner.nextLine();
        System.out.println("Enter Lastname:");
        String lastN = scanner.nextLine();

        int found = 0;
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).firstName.equals(firstN) && contactList.get(i).lastName.equals(lastN)) {
                contactList.remove(i);
                System.out.println("** Contact deleted from the Address Book **");
                found = 1;
                break;
            }
        }

        if (found == 0) {
            System.out.println("** Contact you are trying to delete is not found **");
        }

    }
}
