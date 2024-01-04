package com.practice;

import java.util.Scanner;

public class Contact {
    private static Scanner scanner = new Scanner(System.in);
    // UC1

    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phoneNumber;
    public String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
            String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact() {
        this(getInput("Enter the Firstname: "),
                getInput("Enter the Lastname: "),
                getInput("Enter the Address: "),
                getInput("Enter the City: "),
                getInput("Enter the State: "),
                getInput("Enter the Zip: "),
                getInput("Enter the Phonenumber: "),
                getInput("Enter the Email: "));

    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public void displayContact() {

        System.out.println("Firstname: " + this.firstName);
        System.out.println("Lastname: " + this.lastName);
        System.out.println("Address: " + this.address);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip: " + this.zip);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Email: " + this.email);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
