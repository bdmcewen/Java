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

        // Call a method asking for the dept + return the dept
        this.department = setDepartment();

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
    }

    // generate random password

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
