package emailApp;

import java.util.Scanner;

public class Email {
    // Attributes
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;


    // Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Created user: " + this.firstName + " " + this.lastName);
        System.out.println();

        // Call a method asking for the dept + return the dept
        this.department = setDepartment();
        System.out.println("Dept set: "  + this.department);
        System.out.println();

        // Call a method that returns a random password
        this.password = setPassword();
        System.out.println("Password set: " );
        System.out.println();

        System.out.print(this);
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

        //TODO: implement wait for key press before returning
    }

    // generate random password
    private String setPassword() {
        Scanner ps1 = new Scanner(System.in);
        System.out.print("Enter new user password: ");
        String newPassword1 = ps1.nextLine();
        Scanner ps2 = new Scanner(System.in);
        System.out.print("Enter new user password again: ");
        String newPassword2 = ps2.nextLine();
        if (newPassword1.equals(newPassword2)) {
            return newPassword1;
        } else {
            return "Error.";
        }
        //TODO: Learn how to hash password w/salt & password masking
    }

    // set mailbox capacity

    // change email password

    @Override
    public String toString() {
        return "Email{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +
                ", alternateEmail='" + alternateEmail + '\'' +
                '}';
    }


}
