package studetndatabaseapp;

import java.util.Scanner;

public class Student {

    // region Attributes

    private String firstName;
    private String lastName;
    private int academicStanding;
    private String studentID;
    private String course;
    private int tuitionBalance;
    private static int courseCost = 600;
    private static int id = 1000;

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
        this.academicStanding = infoIn.nextInt();
//        if (infoIn.nextInt() == 1){this.academicStanding = "Freshman";}
//        else if (infoIn.nextInt() == 2){this.academicStanding = "Sophmore";}
//        else if (infoIn.nextInt() == 3){this.academicStanding = "Junior";}
//        else if (infoIn.nextInt() == 4){this.academicStanding = "Senior";}
//        else {System.out.println("Invalid Response" );}


        // Call method to generate and set studentID
        setStudentID();

        System.out.println(this);
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
