package com.practice;

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
            System.out.println("Enter 6. To get a contact with person in a state");
            System.out.println("Enter 7. To get a contact with person in a city");
            System.out.println("Enter 8. To retrieve the contact List of the state");
            System.out.println("Enter 9. To retrieve the contact List of the city");
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
                case 6:
                    System.out.println("Enter the name of the state: ");
                    String state = scanner.next();
                    System.out.println("Enter the name of the person: ");
                    String personByState = scanner.next();
                    bookList.searchContactBasedOnState(state, personByState);
                    break;
                case 7:
                    System.out.println("Enter the name of the city: ");
                    String city = scanner.next();
                    System.out.println("Enter the name of the person: ");
                    String personByCity = scanner.next();
                    bookList.searchContactBasedOnCity(city, personByCity);
                case 8:
                    System.out.println("Enter the name of the state: ");
                    String stateName = scanner.next();
                    bookList.viewContactBasedOnState(stateName);
                    break;
                case 9:
                    System.out.println("Enter the name of the city: ");
                    String cityName = scanner.next();
                    bookList.viewContactBasedOnCity(cityName);
                    break;
                case 10:
                    System.out.println("Enter the name of the state: ");
                    String stateName1 = scanner.next();
                    bookList.countBasedOnState(stateName1);
                    break;
                case 11:
                    System.out.println("Enter the name of the city: ");
                    String cityName1 = scanner.next();
                    bookList.countBasedOnCity(cityName1);
                    break;
                case 12:
                    System.out.println("Enter the name of the addressbook to sort based on PersonName: ");
                    String adrsbook = scanner.next();
                    bookList.sortViaPersonName(adrsbook);
                    break;
                case 13:
                    System.out.println("Enter the name of the addressbook to sort based on City: ");
                    String adrsbook1 = scanner.next();
                    bookList.sortViaPersonsCity(adrsbook1);
                    break;
                case 14:
                    System.out.println("Enter the name of the addressbook to sort based on State: ");
                    String adrsbook2 = scanner.next();
                    bookList.sortViaPersonsState(adrsbook2);
                    break;
                case 15:
                    System.out.println("Enter the name of the addressbook to sort based on Zip: ");
                    String adrsbook3 = scanner.next();
                    bookList.sortViaPersonsZip(adrsbook3);
                    break;
                default:
                    break;

            }
        } while (option != 0);
    }
}