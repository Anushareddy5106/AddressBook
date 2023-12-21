package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the AddressBook");

        // UC2
        AddressBookList bookList = new AddressBookList();

        int option;

        do {
            System.out.println("----------------------------------------");
            System.out.println("Enter 1. To add a new address book");
            System.out.println("Enter 2. To display a particular AddressBook");
            System.out.println("Enter 3. To add a contact in a particular AddressBook");
            System.out.println("Enter 4. To edit a contact in a particular AddressBook");
            System.out.println("Enter 5. To delete a contact from a particular AddressBook");
            System.out.println("Enter 0. To end");
            System.out.println("----------------------------------------");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the name of the address book: ");
                    String bookName = scanner.next();
                    AddressBook addressBook = new AddressBook(bookName);
                    bookList.addBook(addressBook);
                    break;
                case 2:
                    bookList.operations("display-book");
                    break;
                case 3:
                    bookList.operations("add-contact");
                    break;
                case 4:
                    bookList.operations("edit-contact");
                    break;
                case 5:
                    bookList.operations("delete-contact");
                    break;
                default:
                    break;

            }
        } while (option != 0);
    }
}