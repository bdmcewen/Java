package emailapp;

import java.util.Scanner;

public class Email {

    final private String companySuffix = "company.com";
    // Attributes
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String emailAddress;
    private int mailboxCapacity = 500;
    private final int defaultPasswordLength = 12;
    private String alternateEmail;


    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Created user: " + this.firstName + " " + this.lastName);
        System.out.println();

        // Call a method asking for the dept + return the dept
        this.department = setDepartment();
//        System.out.println("Dept set: " + this.department);
//        System.out.println();

        // Call a method that returns a random password
        this.password = setPassword(this.defaultPasswordLength);
//        System.out.println("Password set: " + this.password);
//        System.out.println();

        // call Method that returns an auto-generated email address
        this.emailAddress = setEmailAddress();
//        System.out.println("Email set: " + this.emailAddress);
//        System.out.println();


//        System.out.print(this);
    }

    // Ask for Department
    private String setDepartment() {
        System.out.print("Dept Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) {
            return "Sales";
        } else if (deptChoice == 2) {
            return "Development";
        } else if (deptChoice == 3) {
            return "Accounting";
        } else if (deptChoice == 0) {
            return "None";
        } else {
            return "Invalid selection, returning";
        }
        //TODO: implement switch statement rather than if else
        //TODO: implement wait for key press before returning
    }

    // generate random password
    private String setPassword(int length) {
        // code block for randomly generated password
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

        // code block for user defined password
//        Scanner ps1 = new Scanner(System.in);
//        System.out.print("Enter new user password: ");
//        String newPassword1 = ps1.nextLine();
//        Scanner ps2 = new Scanner(System.in);
//        System.out.print("Enter new user password again: ");
//        String newPassword2 = ps2.nextLine();
//        if (newPassword1.equals(newPassword2)) {
//            return newPassword1;
//        } else {
//            return "Error.";
//        }

        //TODO: add security constraints on password
        //TODO: Learn how to hash password w/salt & password masking
    }

    //generate email Address
    private String setEmailAddress() {
        this.emailAddress = this.firstName.toLowerCase()
                + "."
                + this.lastName.toLowerCase()
                + "@"
                + this.department.toLowerCase()
                + "."
                + this.companySuffix;

        return emailAddress;
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change user password
    public void setPassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "companySuffix='" + companySuffix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", defaultPasswordLength=" + defaultPasswordLength +
                ", alternateEmail='" + alternateEmail + '\'' +
                '}';
    }

    public String showInfo(){
        System.out.println();
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName + "\n" +
                "COMPANY EMAIL: " + this.emailAddress + "\n" +
                "MAILBOX CAPACITY: " + this.mailboxCapacity + "mb";
    }


}
