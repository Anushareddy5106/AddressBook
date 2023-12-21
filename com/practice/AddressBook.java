package com.practice;

import java.util.*;

public class AddressBook {

    public static Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contactList;

    AddressBook() {
        this.contactList = new ArrayList<Contact>();
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

}
