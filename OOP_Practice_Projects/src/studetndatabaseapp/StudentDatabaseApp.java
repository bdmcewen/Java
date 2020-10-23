package studetndatabaseapp;

import java.util.Arrays;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        // Ask the user how many new students will be added to the database
        System.out.print("Enter number of new student: ");
        Scanner in = new Scanner(System.in);
        int numberOfStudents = in.nextInt();
        Student[] students = new Student[numberOfStudents];


        // Create n number of students
        for (int i = 0; i < numberOfStudents ; i++) {
            students[i] = new Student();
            students[i].enroll();
//            students[i].payTuition();
            System.out.println();
        }

        for (int i = 0; i < numberOfStudents ; i++) {
            System.out.println(students[i].showStatus());
            System.out.println();

        }

//        //For Testing single case
//        Student s1 = new Student();
//        s1.enroll();
//        s1.payTuition();
//
//        System.out.println();
//        System.out.println(s1.toString());
//        System.out.println(s1.showStatus());


    }
}
