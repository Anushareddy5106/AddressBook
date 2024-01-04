package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookList {

    static Scanner scanner = new Scanner(System.in);
    public Map<String, ArrayList<Contact>> ContactDetailsBasedOnCity = new HashMap<>();
    public Map<String, ArrayList<Contact>> ContactDetailsBasedOnState = new HashMap<>();

    // UC6
    public Map<String, AddressBook> addressBookList = new HashMap<>();

    public void operations(String option) {
        System.out.println("Enter the Book name to (retrieve/add/edit/delete)");
        String bookName = scanner.next();

        boolean found = false;
        if (addressBookList.containsKey(bookName)) {
            System.out.println("Address book found");
            found = true;

            switch (option) {
                case "display-book":
                    addressBookList.get(bookName).display();
                    break;

                case "add-contact":
                    System.out.println(
                            "----Enter the details to add the contact to AddressBook " + bookName + "-----");
                    Contact contact = new Contact();
                    if (addressBookList.get(bookName).isDuplicateName(contact.firstName) == false) {
                        addressBookList.get(bookName).add(contact);
                        if (ContactDetailsBasedOnState.containsKey(contact.state))
                            ContactDetailsBasedOnState.get(contact.state).add(contact);
                        else {
                            ArrayList<Contact> contacts = new ArrayList<>();
                            contacts.add(contact);
                            ContactDetailsBasedOnState.put(contact.state, contacts);
                        }

                        if (ContactDetailsBasedOnCity.containsKey(contact.city))
                            ContactDetailsBasedOnCity.get(contact.state).add(contact);
                        else {
                            ArrayList<Contact> contacts = new ArrayList<>();
                            contacts.add(contact);
                            ContactDetailsBasedOnCity.put(contact.city, contacts);
                        }

                    } else {
                        System.out.println("** Duplicate Entry is found in the Address Book **");
                    }
                    break;

                case "edit-contact":
                    addressBookList.get(bookName).edit();
                    break;

                case "delete-contact":
                    addressBookList.get(bookName).delete();
                    break;
            }
        }

        if (!found) {
            System.out.println("Enter a valid book name");
        }
    }

    public void addBook(AddressBook book) {
        if (addressBookList.containsKey(book.name))
            System.out.println("Book already exists");
        else
            addressBookList.put(book.name, book);
    }

    // UC8
    public void searchContactBasedOnState(String state, String person) {
        boolean flag = false;
        if (ContactDetailsBasedOnState.containsKey(state)) {
            for (Contact contact : ContactDetailsBasedOnState.get(state)) {
                if (contact.firstName.equals(person)) {
                    System.out.println(contact.toString());
                    flag = true;
                }
            }
        }

        if (!flag)
            System.out.println("No contacts found with this " + person + " name in " + state);
    }

    public void searchContactBasedOnCity(String city, String person) {
        boolean flag = false;
        if (ContactDetailsBasedOnCity.containsKey(city)) {
            for (Contact contact : ContactDetailsBasedOnCity.get(city)) {
                if (contact.firstName.equals(person)) {
                    System.out.println(contact.toString());
                    flag = true;
                }
            }
        }
        if (!flag)
            System.out.println("No contacts found with this " + person + " name in " + city);
    }

    // UC9
    public void viewContactBasedOnCity(String city) {
        boolean flag = false;
        if (ContactDetailsBasedOnCity.containsKey(city)) {
            for (Contact contact : ContactDetailsBasedOnCity.get(city)) {
                System.out.println(contact.toString());
                flag = true;
            }
        }
        if (!flag)
            System.out.println("No contacts found in " + city);
    }

    public void viewContactBasedOnState(String state) {
        boolean flag = false;
        if (ContactDetailsBasedOnState.containsKey(state)) {
            for (Contact contact : ContactDetailsBasedOnState.get(state)) {
                System.out.println(contact.toString());
                flag = true;
            }
        }

        if (!flag)
            System.out.println("No contacts found in " + state);
    }

    // UC10
    public int countBasedOnCity(String city) {
        if (ContactDetailsBasedOnCity.containsKey(city)) {
            return ContactDetailsBasedOnCity.get(city).size();
        }

        return 0;
    }

    public int countBasedOnState(String state) {
        if (ContactDetailsBasedOnState.containsKey(state)) {
            return ContactDetailsBasedOnState.get(state).size();
        }

        return 0;
    }

    // UC11
    public void sortViaPersonName(String nameOfAddressBook) {
        ArrayList<Contact> contacts = addressBookList.get(nameOfAddressBook).contactList;
        Comparator<Contact> firstNameComparator = Comparator.comparing(Contact::getFirstName);
        Collections.sort(contacts, firstNameComparator);

        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    // UC12

    public void sortViaPersonsCity(String nameOfAddressBook) {
        ArrayList<Contact> contacts = addressBookList.get(nameOfAddressBook).contactList;
        Comparator<Contact> cityComparator = Comparator.comparing(Contact::getCity);
        Collections.sort(contacts, cityComparator);

        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void sortViaPersonsState(String nameOfAddressBook) {
        ArrayList<Contact> contacts = addressBookList.get(nameOfAddressBook).contactList;
        Comparator<Contact> stateComparator = Comparator.comparing(Contact::getState);
        Collections.sort(contacts, stateComparator);

        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void sortViaPersonsZip(String nameOfAddressBook) {
        ArrayList<Contact> contacts = addressBookList.get(nameOfAddressBook).contactList;
        Comparator<Contact> zipComparator = Comparator.comparing(Contact::getZip);

        Collections.sort(contacts, zipComparator);

        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

}
