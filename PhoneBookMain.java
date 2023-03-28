/*Lianna Patel 
ICS3U0
Class Object and Methods
Dec. 1, 2022
Contact application for the user. The user can enter any command (add, edit, lookup, delete, view all, and exit). The phone book must support all of the following data: first name, last name, phone number, email, and company name */

import java.util.Scanner;
 
class PhoneBookMain {
   static String[][] contacts; //store users contacts
   static Scanner kb; 
   static int entry; 
   public static void main(String[] args) {
       {
 
            kb = new Scanner(System.in);
           int numEntries = 0; //initializations of number of entries
 
           MyPhoneBook pb = new MyPhoneBook(); 
           pb.read(); //reading the information from file
 
           int choice = 0, i = 0, newNum; 
           String firstName = "", lastName = "", num = "", company = "", email = "", name = "";
 
           System.out.println("Welcome to Lianna's greatest Phonebook!");
 
           while (true) { //show the user what they can chose from 
              
               System.out.println("\n"+"1) Add new contact");
               System.out.println("2) Lookup a contact");
               System.out.println("3) Delete a contact");
               System.out.println("4) Show all contacts");
               System.out.println("5) Edit a contact");
               System.out.println("6) Exit");
               System.out.print("\n" + "Enter your choice (1-6): ");
               choice = kb.nextInt();// get user choice 
               kb.nextLine(); 
 
               if (choice < 1 || choice > 8) { 
                   System.out.println("Error, try again!");
               } else {
                   switch (choice) {
                       case 1: // contact case
                           numEntries = pb.EntryCount(); // amount of entries
                       
                           System.out.print("\nEnter first name: ");
                           firstName = kb.nextLine();// get first name
                           System.out.print("Enter last name: ");
                           lastName = kb.nextLine();// get last name
                           System.out.print("Enter phone number: ");
                           num = kb.nextLine();// get phone number 
                           System.out.print("Enter company: ");
                           company = kb.nextLine();// get company name
                           System.out.print("Enter email: ");
                           email = kb.nextLine();// get email
                           pb.add(firstName, lastName, num, company, email); //save the information in the 2d array 
                           break;
 
                       case 2: // lookup 
 
                           System.out.println("Which name or email are you trying to find: "); 
                           
                           String newName = kb.nextLine();// get name or email from user
                           System.out.print("Is it a first name ('f') or email ('e'): "); 
                       
                           String choices = kb.next(); // determine if it is first name or email
 
                           int val = pb.determine(choices); // find out if the user put either email or first name 
                       
                           boolean check2 = pb.check2(newName, val); //check to see if they can find the user's input 
 
                           if (check2 == false) { //check if the name of email is found 
                             
                               System.out.println("\nName was not found!");
                           } else {// if name or email is found
                               System.out.println("Name is found!"); 
 
                               contacts = pb.lookUp(newName, val); // finds name or email in array
                               int people = pb.people(newName, val); 
 
                               for (i = 0; i < people; i++) { // find all the contacts that match
                                   System.out.println("\nFirst Name: " + contacts[i][0]);
                                   System.out.println("Last Name: " + contacts[i][1]);
                                   System.out.println("Number: " + contacts[i][2]);
                                   System.out.println("Address: " + contacts[i][3]);
                                   System.out.println("Email: " + contacts[i][4]);
                               }
                           }
                           break;
                       case 3: // delete 
                           
                           System.out.print("\n" + "Enter the first name: ");
                           firstName = kb.nextLine(); // first name
                           System.out.print("Enter the last name: ");
                           lastName = kb.nextLine(); //last anme
                           boolean removed = pb.remove(firstName, lastName); // 
                           if (removed == true) { 
                               System.out.println("Deleted successfully!");
                           } else { 
                               System.out.println("Name not found...");
                           }
                           break;
 
                       case 4: // Show all 
                           contacts = pb.viewAll(); // 
                           for (i = 0; i < contacts.length - 1; i++) { //show all the contacts 
                               if (contacts[i][0] != null) {
                                   System.out.println("\nFirst Name: " + contacts[i][0]);
                               }
                               if (contacts[i][1] != null) {
                                   System.out.println("Last Name: " + contacts[i][1]);
                               }
                               if (contacts[i][2] != null) {
                                   System.out.println("Number: " + contacts[i][2]);
                               }
                               if (contacts[i][3] != null) {
                                   System.out.println("Address: " + contacts[i][3]);
                               }
                               if (contacts[i][4] != null) {
                                   System.out.println("Email: " + contacts[i][4]);
                               }
 
                           }
                           break;
 
                       case 5:// edit 
                           System.out.print("\nEnter the first name: ");
                           firstName = kb.nextLine();
                           System.out.print("Enter the last name: ");
                           lastName = kb.nextLine();
                           boolean check = pb.check(firstName, lastName);// checks if first and last name matches 
                           if (check == true) { //check if name is found 
                               System.out.println("Name is found!"); 
 
                               System.out.print("\nNew First Name: ");
                               String newfirstName = kb.nextLine();// get new first name
 
                               System.out.print("New Last Name: ");
                               String newlastName = kb.nextLine();// get new last name 
 
                               System.out.print("New Number: ");
                               num = kb.nextLine(); //get new number 
 
                               System.out.print("New Company: ");
                               company = kb.nextLine();// get new company
 
                               System.out.print("New email: ");
                               email = kb.nextLine();// get new email
                               boolean edit = pb.edit(firstName, lastName, num, company, email, newfirstName, newlastName);// puts the new input into arrays
                               if (edit == true) { 
                                   System.out.println("Contacts successfully changed! ");
                               } else { 
                                   System.out.println("Name not found...");
                               }
                           } else {//if user input is not found 
                               System.out.println("\nName is not found"); 
                           }
                           break;
 
                       case 6: // leave the program 
                           System.out.println("Exiting Program");
                           pb.write();
 
                           System.exit(0);
                           break;
 
                   }
               }
           }
       }
 
   }
}

 
