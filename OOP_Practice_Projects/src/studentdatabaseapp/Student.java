package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    // region Attributes

    private static final int courseCost = 600;
    private static int id = 1000;
    private final String firstName;
    private final String lastName;
    private final int academicStanding;
    private final ArrayList<String> courses;
    private String studentID;
    private int tuitionBalance;

    // endregion

    // region Constructor(s)
    public Student() {
        this.courses = new ArrayList<>();
        //The user should be prompted to enter the name and year for each student
        Scanner infoIn = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = infoIn.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = infoIn.nextLine();

        System.out.print("Academic Standings: \n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student's standing:");
        this.academicStanding = infoIn.nextInt();
//        if (infoIn.nextInt() == 1){this.academicStanding = "Freshman";}
//        else if (infoIn.nextInt() == 2){this.academicStanding = "Sophmore";}
//        else if (infoIn.nextInt() == 3){this.academicStanding = "Junior";}
//        else if (infoIn.nextInt() == 4){this.academicStanding = "Senior";}
//        else {System.out.println("Invalid Response" );}


        // Call method to generate and set studentID
        setStudentID();

//        System.out.println(this);
    }


    // endregion

    // region Getters & Setters


    private void setStudentID() {
        //generate 5 digit student ID starting with academic standing code Autoincrements: 1
        id++;
        this.studentID = this.academicStanding + "" + id;
    }


    // endregion

    // region Behaviors


    //Enroll in course
    public void enroll() {
        //start loop until user enters
        System.out.println("Enter course to enroll (Q to quit)");
        do {
            System.out.print("Enter Course ID: ");

            Scanner courseIn = new Scanner(System.in);
            String course = courseIn.nextLine();
            course = course.toUpperCase();
//        System.out.println("TEST COURSE: " + course);
            if (!course.equals("Q")) {
                this.courses.add(course);
                this.tuitionBalance += courseCost;
            } else {
                break;
            }
        } while (true);
//TODO: show tuition balance after enroll and ask if user wishes to proceed.
        System.out.println("Enrolled in:" + this.courses);
//        System.out.println("Tuition Balance: " + this.tuitionBalance);

    }

    // View Balance
    public void viewBalance() {
        System.out.println("Your balance is " + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        // request payment amount here
        Scanner in = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        int payment = in.nextInt();

        //adjust tuition balance
        this.tuitionBalance -= payment;
        System.out.println("Thank you for your payment of: " + payment);
        viewBalance();

    }


    // endregion

    // region Display Data

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", academicStanding='" + academicStanding + '\'' +
                ", studentID=" + studentID +
                ", courses='" + courses + '\'' +
                ", tuitionBalance=" + tuitionBalance +
                ", courseCost=" + courseCost +
                '}';
    }


    // Show Status
    public String showStatus(){
        return "Name:" + this.firstName + " " + this.lastName +
                "\nRegistered course: " + courses +
                "\nBalance: " + tuitionBalance;
    }

    // endregion


}
