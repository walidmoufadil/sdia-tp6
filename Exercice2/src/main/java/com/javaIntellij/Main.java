package com.javaIntellij;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

                DossierContact dossierContact = new DossierContact();
                Scanner scanner = new Scanner(System.in);
                int choice = 0;
                while (choice != 5) {
                    System.out.println("1-FIND CONTACT");
                    System.out.println("2-ADD CONTACT");
                    System.out.println("3-DELETE CONTACT");
                    System.out.println("4-UPDATE CONTACT");
                    System.out.println("5-EXIT");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter the name of the contact: ");
                            String name = scanner.next();
                            System.out.println(dossierContact.getContact(name));
                            break;
                        case 2:
                            System.out.println("Enter the name of the contact: ");
                            String contactName = scanner.next();
                            System.out.println("Enter the number of the contact: ");
                            String contactNumber = scanner.next();
                            dossierContact.addContact(contactName, contactNumber);
                            break;
                        case 3:
                            System.out.println("Enter the name of the contact: ");
                            String contactToDelete = scanner.next();
                            dossierContact.deleteContact(contactToDelete);
                            break;
                        case 4:
                            System.out.println("Enter the name of the contact: ");
                            String contactToUpdate = scanner.next();
                            System.out.println("Enter the new number of the contact: ");
                            String newNumber = scanner.next();
                            dossierContact.updateContactNumber(contactToUpdate, newNumber);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
                scanner.close();
                System.out.println("Goodbye!");
            }

}