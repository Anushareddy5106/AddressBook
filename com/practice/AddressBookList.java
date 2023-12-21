package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookList {

    static Scanner scanner = new Scanner(System.in);

    public ArrayList<AddressBook> addressBookList = new ArrayList<>();

    public void operations(String option) {
        System.out.println("Enter the Book name to (retrieve/add/edit/delete)");
        String bookName = scanner.next();

        boolean found = false;
        for (int i = 0; i < addressBookList.size(); i++) {
            if (addressBookList.get(i).name.equals(bookName)) {
                System.out.println("Address book found");
                found = true;

                switch (option) {
                    case "display-book":
                        addressBookList.get(i).display();
                        break;

                    case "add-contact":
                        System.out.println(
                                "----Enter the details to add the contact to AddressBook " + bookName + "-----");
                        Contact contact = new Contact();
                        addressBookList.get(i).add(contact);
                        break;

                    case "edit-contact":
                        addressBookList.get(i).edit();
                        break;

                    case "delete-contact":
                        addressBookList.get(i).delete();
                        break;
                }
            }
        }

        if (!found) {
            System.out.println("Enter a valid book name");
        }
    }

    public void addBook(AddressBook book) {
        addressBookList.add(book);
    }

}
