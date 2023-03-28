/* Lianna Patel
ICS3U0
Class Object and Methods
Dec. 1, 2022
Contact application for the user. The user can enter any command (add, edit, lookup, delete, view all, and exit). The phone book must support all of the following data: first name, last name, phone number, email, and company name  */

import java.io.*;
class MyPhoneBook {
 
   static int numEntries; // counts the number of entries 
   String[][] contacts; // storing entry contracts 
   String[][] conR;
 
 
   public MyPhoneBook() { //Method one 
       numEntries = 0; 
       contacts = new String[100][5];
       conR = new String[100][5];
   } 
 
 
   public void add(String firstName, String lastName, String num, String company, String email) // save users input
  
   {
       contacts[numEntries][0] = firstName;// to add input in array
       contacts[numEntries][1] = lastName;
       contacts[numEntries][2] = num;
       contacts[numEntries][3] = company;
       contacts[numEntries][4] = email;
       numEntries++;
   }
 
   public String[][] lookUp(String newName, int val) //lookup
   {
       int entry = 0, cnt = 0, cou = 0;
     
       for (cnt = 0; cnt <= numEntries; cnt++) { // difrrent entries  
         
           if (newName.equals(contacts[cnt][val])) { //user either inputs name or email 
               for (cou = 0; cou <= 4; cou++) { // fo find all the contents of the specific name 
                   conR[entry][cou] = contacts[cnt][cou];
               }
               entry++;
           }
          
           }
      
       return conR;
   }
 
public int people(String newName, int val) {
 
 int people = 0;
 for (int c = 0; c < numEntries; c++){
     if (newName.equals(contacts[c][val])) {// if the name user asks for is equal to the first name email 
       
     people ++;
 }
 }
 return people;
 
}
 
public int determine(String choices){
 
int number = 0;
 
 switch (choices) 
       {
           case "f":
               number = 0; //the index number for email is 0 (first name) 
               break;
           case "e":
               number = 4; //the index number for email is 4 (email)
               break;
       }
       return number;
}
 
 
   public boolean remove(String firstName, String lastName) { //method 4 
       for (int cnt = 0; cnt < numEntries; cnt++) { //keep going until the number of entries excels
           if (firstName.equals(contacts[cnt][0]) && lastName.equals(contacts[cnt][1])) { //find matches with the user 
               for (int cnt1 = cnt + 1; cnt++ < numEntries; cnt1++) {
                   contacts[cnt1 - 1][0] = contacts[cnt1][0];
                   contacts[cnt1 - 1][1] = contacts[cnt1][1];
                   contacts[cnt1 - 1][2] = contacts[cnt1][2];
                   contacts[cnt1 - 1][3] = contacts[cnt1][3];
                   contacts[cnt1 - 1][4] = contacts[cnt1][4];
               }
               numEntries--; 
               return true; //name is match 
           }
       }
       return false; // otherwise the name is not matched 
   } 
 
 
   public boolean edit(String firstName, String lastName, String num, String company, String email, String newfirstName, String newlastName) { // save all users entries 
 
       for (int cnt = 0; cnt <= numEntries; cnt++) { // for different entries 
            if (firstName.equals(contacts[cnt][0]) && lastName.equals(contacts[cnt][1])) { 
               contacts[cnt][0] = newfirstName;
               contacts[cnt][1] = newlastName;
               contacts[cnt][2] = num;
               contacts[cnt][3] = company;
               contacts[cnt][4] = email;
              
           }
 
           return true;
       }
 
       return false;
   }
 
     public String[][] viewAll()
    
     { 
      return contacts;
     }
 
 
  public String write() {
 
   try 
       {
           PrintWriter output; //object to connect to a file
           output = new PrintWriter (new PrintWriter ("data.txt")); 
     for (int i = 0; i < numEntries; i++){
         output.println( contacts[i][0]);
     output.println(contacts[i][1]);
     output.println(contacts[i][2]);
     output.println(contacts[i][3]);
     output.println(contacts[i][4]);
}     
           output.close(); // close object to the save file 
           System.out.println ("data.txt file created with data!");
       }
       catch (Exception e) 

       { 
           System.out.println ("error");
       } 
 
       return ("1");
}
   public String read() {
  
    String line;
      
       try
       {
           BufferedReader reader; 
           reader = new BufferedReader (new FileReader ("data.txt"));
           line = reader.readLine ();  // read line           
        
           while (line != null)                    
           {
               for(int count = 0; count < 5; count++) {
              
               contacts[numEntries][count] = line;
               line = reader.readLine();
               }
           System.out.print("\n");
           numEntries++;}
           reader.close (); // close the file
       }
       catch (Exception e)// for try catch
       { 
           System.out.println ("error");
       } 
   return "1";
 }
 public boolean check(String firstName, String lastName) //check for the method
  
{
for (int cnt = 0; cnt <= numEntries; cnt++) { // different entries 
 
            if (firstName.equals(contacts[cnt][0]) && lastName.equals(contacts[cnt][1])){
            return true;
            } 
}
return false;
}
 
public boolean check2(String newName, int val)  
  
{
for (int cnt = 0; cnt <= numEntries; cnt++) { //different entries 
 
       if (newName.equals(contacts[cnt][val])){//the name is found

 
            return true; 
}
}
return false;
}
public static int EntryCount() {
 
       return numEntries;
   }
}
 
