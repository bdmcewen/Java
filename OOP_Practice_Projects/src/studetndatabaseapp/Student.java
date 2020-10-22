package studetndatabaseapp;

import java.util.Scanner;

public class Student {

    // region Attributes

    private String firstName;
    private String lastName;
    private String academicStanding;
    private int studentID;
    private String course;
    private int tuitionBalance;
    private final int courseCost = 600;

    // endregion

    // region Constructor(s)
    public Student(){

        //The user should be prompted to enter the name and year for each student
        Scanner infoIn = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = infoIn.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = infoIn.nextLine();

        System.out.print("Academic Standings: \n1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student's standing:");
        if (infoIn.nextInt() == 1){this.academicStanding = "Freshman";}
        else if (infoIn.nextInt() == 2){this.academicStanding = "Sophmore";}
        else if (infoIn.nextInt() == 3){this.academicStanding = "Junior";}
        else if (infoIn.nextInt() == 4){this.academicStanding = "Senior";}
        else {System.out.println("Invalid Response" );}

        System.out.println(this);
    }


    // endregion

    // region Getters & Setters
    // generate id
    // endregion

    // region Behaviors


    //Enroll in course

    //view balance

    //Pay Tuition


    // endregion

    // region Display Data

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", academicStanding='" + academicStanding + '\'' +
                ", studentID=" + studentID +
                ", course='" + course + '\'' +
                ", tuitionBalance=" + tuitionBalance +
                ", courseCost=" + courseCost +
                '}';
    }


    // Show Status


    // endregion



}
