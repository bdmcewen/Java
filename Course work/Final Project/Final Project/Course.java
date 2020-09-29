/********************************************************************************
 *                            Final Project - Course Manager                    *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  04/26/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * Defines the course class                                                     *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Course
{
    private ArrayList<Student> Roster;
    private Scanner userInput = new Scanner(System.in);

    /*******************************************************************************
     * Student                                                                      *
     *                                                                              *
     * Purpose: Default constructor                                                 *
     * Parameters:                                                                  *
     *     none (how does it work? Magic!)                                          *
     * Return Value:  none its a constructor                                        *
     *******************************************************************************/
    Course()
    {
        Roster = new ArrayList<>();
    }

    /*******************************************************************************
     * AddToRoster                                                                  *
     *                                                                              *
     * Purpose: Adds student to the roster ( I know, shocking right)                *
     * Parameters:                                                                  *
     *     int studentid, String lastname, String firstname, double grade           *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void AddToRoster(int studentid, String lastname, String firstname, double grade)
    {
        Student s = new Student();
        s.SetStudentID(studentid);
        s.SetLastName(lastname);
        s.SetFirstName(firstname);
        s.SetGrade(grade);
        Roster.add(s);

        this.WriteToFile();
    }
    /*******************************************************************************
     * DisplayMenu                                                                  *
     *                                                                              *
     * Purpose: yep you guessed it, it displays the menu                            *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    void DisplayMenu()
    {
        System.out.println();
        System.out.println("Student Grades Manager");
        System.out.println("----------------------");
        System.out.println();

        System.out.println("1. Add New Student");
        System.out.println("2. Edit Student's Grade");
        System.out.println("3. Remove a Student");
        System.out.println("4. View Course Analytics");
        System.out.println("5. View Class Roster");
        System.out.println("6. Exit ");
        System.out.println();
        System.out.println("Please, enter a selection");
        String choice = userInput.nextLine();

        switch (choice)
        {
            case "1": AddStudent(); break;
            case "2": EditStudent(); break;
            case "3": RemoveStudent(); break;
            case "4": DisplayAnalytics(); break;
            case "5": DisplayStudents(); ReturnToMain(); break;
            case "6": ExitApplication(); break;
        }
    }
    /*******************************************************************************
     * AddStudent                                                                   *
     *                                                                              *
     * Purpose: Collects info for new studnet then calls AddToRoster method         *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void AddStudent()
    {
        System.out.println("Creating a new Student Profile");
        System.out.println("------------------------------");
        DisplayStudents();

        System.out.println();
        System.out.println("Enter new students ID:");
        String id = userInput.nextLine();
        int newId = Integer.parseInt(id);
        for(Student s: Roster)
            if (s.GetStudentID() == newId)
            {
                System.out.println();
                System.out.println(" Id already in use. Press any key to try again");

                userInput.nextLine();
                AddStudent();
                //System.in.read();

                // Console.Clear();
            }

        System.out.println();
        System.out.println("Enter new students first name:");
        String fName = userInput.nextLine();

        System.out.println();
        System.out.println("Enter students last name:");
        String lName = userInput.nextLine();

        System.out.println();
        System.out.println("Enter students grade:");
        String grade = userInput.nextLine();
        double newGrade = Double.parseDouble(grade);

        AddToRoster(newId, lName, fName, newGrade);

        System.out.println();
        System.out.print(fName + " " + lName + " has been added to the roster under ID # " + newId);
        System.out.println();

        ReturnToMain();

    }
    /*******************************************************************************
     * EditStudent                                                                  *
     *                                                                              *
     * Purpose: Allows user to edit the students grade                              *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void EditStudent()
    {
        System.out.println("Grade Editing Menu");
        System.out.println("------------------");
        System.out.println();
        System.out.println("There are currently " + Roster.size() + " Students in your roster");
        if (Roster.size() == 0)
        {
            System.out.println("Returning to main menu press enter to continue");
            userInput.nextLine();

            DisplayMenu();
        }
        DisplayStudents();

        System.out.println("Choose and ID# to edit: ");
        String id = userInput.nextLine();
        int requestedId = Integer.parseInt(id);

        for (Student s: Roster)
        {
            if (requestedId == s.GetStudentID())
            {
                System.out.println("Editing: " + s.GetStudentID() + " " + s.GetFirstName() + " " + s.GetLastName());
                System.out.println("Enter the students current grade: ");
                String grade = userInput.nextLine();
                double newGrade = Double.parseDouble(grade);

                s.SetGrade(newGrade);

                System.out.println();
                System.out.print("The grade for student ID# " + id + " has been updated to " + newGrade);
                System.out.println();

                WriteToFile();
                ReturnToMain(); break;
            }
        }
    }
    /*******************************************************************************
     * EditStudent                                                                  *
     *                                                                              *
     * Purpose: Allows user to remove a student                                     *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void RemoveStudent()
    {

        System.out.println("Student Removal Menu");
        System.out.println("------------------");
        System.out.println();
        System.out.println("There are currently " + Roster.size() + " Students in your roster");

        if (Roster.size() == 0)
        {
            System.out.println("Returning to main menu press enter to continue");
            userInput.nextLine();

            DisplayMenu();
        }

        DisplayStudents();
        System.out.println();
        System.out.println("Enter the id of the student you wish to remove");
        String id = userInput.nextLine();
        int requestedId = Integer.parseInt(id);

        for (Student s: Roster)
        {
            if (requestedId == s.GetStudentID())
            {
                System.out.println("Editing: " + s.GetStudentID() + " " + s.GetFirstName() + " " + s.GetLastName());

                System.out.println("Are you sure you want to remove this student from the roster [Y/N]: ");
                String response = (userInput.nextLine().toUpperCase());
                String affirmative = "Y";
                String negatory = "N";

                if (response.equals(affirmative))
                {
                    this.Roster.remove(s);
                    System.out.println();
                    System.out.print("The student profile associated with ID# " + id + " has been removed from the roster.");
                    System.out.println();
                    WriteToFile();

                    ReturnToMain();
                }

                if (response.equals(negatory))
                {
                    System.out.println();
                    System.out.println("Operation has been Cancelled");
                    System.out.println("Press enter to return to Student Roster");
                    userInput.nextLine();
                    RemoveStudent();

                }
            }

        }
    }
    /*******************************************************************************
     * DisplayAnalytics                                                             *
     *                                                                              *
     * Purpose: Allows user to view class statistics                                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void DisplayAnalytics()
    {
        String minStudent = "";
        String maxStudent = "";

        double avg ;
        double sum = 0.0;
        double min = 100.1;
        double max = -100.1;
        double aCount = 0.0;
        double bCount = 0.0;
        double cCount = 0.0;
        double dCount = 0.0;
        double fCount = 0.0;
        double decagrades = (double)Roster.size();

        for (Student s: Roster)
        {
            sum += s.GetGrade();

            //determines grade with largest value
            if (max < s.GetGrade())
            {
                max = s.GetGrade();
                maxStudent = s.GetFirstName() + " " + s.GetLastName();
            }

            //determines grade with smallest value
            if (min > s.GetGrade())
            {
                min = s.GetGrade();
                minStudent = s.GetFirstName() + " " + s.GetLastName();
            }
        }

        // sorts list
        ArrayList<Double> grades = new ArrayList<>();
        for(Student s: Roster)
        {
            grades.add(s.GetGrade());
        }
        Collections.sort(grades);

        //calculate average grade
        avg = sum / Roster.size();


        //sorts by Letter grade
        for (Student s: Roster)
        {
            //System.out.println(s.GetGrade());
            if (s.GetGrade() >= .90)
            {
                aCount += 1;
            }
            if (s.GetGrade() < .90 && s.GetGrade() >= .80)
            {
                bCount += 1;
            }
            if (s.GetGrade() < .80 && s.GetGrade() >= .70)
            {
                cCount += 1;
            }
            if (s.GetGrade() < .70 && s.GetGrade() >= .60)
            {
                dCount += 1;
            }
            if (s.GetGrade() < .60)
            {
                fCount += 1;
            }
        }

        System.out.println("The Class Average is: " + avg);
        System.out.println("The Class Min is: " + min + " the students name is " + minStudent);
        System.out.println("The Class Max is: " + max + " the students name is " + maxStudent);
        //System.out.println("The Class Median is: " + median);

        //below print lines for testing purposes
                /*
                System.out.println("The # of As is: " + aCount);
                System.out.println("The # of Bs is: " + bCount);
                System.out.println("The # of Cs is: " + cCount);
                System.out.println("The # of Ds is: " + dCount);
                System.out.println("The # of Fs is: " + fCount);

                System.out.println("There are " + Roster.size() + " grades");
                */

        System.out.println("The percentage of As is: " + (aCount / decagrades) * 100 + "%");
        System.out.println("The percentage of Bs is: " + (bCount / decagrades) * 100 + "%");
        System.out.println("The percentage of Cs is: " + (cCount / decagrades) * 100 + "%");
        System.out.println("The percentage of Ds is: " + (dCount / decagrades) * 100 + "%");
        System.out.println("The percentage of Fs is: " + (fCount / decagrades) * 100 + "%");

        ReturnToMain();
    }
    /*******************************************************************************
     * ExitApplication                                                              *
     *                                                                              *
     * Purpose: two guesses...                                                      *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void ExitApplication()
    {
        System.exit(0);
    }
    /*******************************************************************************
     * DisplayStudents                                                              *
     *                                                                              *
     * Purpose: Allows user to view info for all of roster                          *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    void DisplayStudents()
    {
        System.out.println();
        System.out.println("Class Roster");
        System.out.println("------------");

        System.out.println("There are currently " + Roster.size() + " Students in your roster\n");
        System.out.println("Student ID | First Name | Last Name | Grade(%)\n");

        for (Student s: Roster)
        {

            String studentString = "";
            studentString += String.format("%-12s %-12s %-12s %-12s",
                    s.GetStudentID(),
                    s.GetFirstName(),
                    s.GetLastName(),
                    (s.GetGrade() *100)
            );
            System.out.println(studentString);
        }
    }
    /*******************************************************************************
     * WriteToFile                                                                  *
     *                                                                              *
     * Purpose: writes array to text file                                           *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void WriteToFile()
    {
        String outputFileName = "Roster.txt";
        // try to write to a file
        try
        {
            FileWriter outputFile = new FileWriter(outputFileName);  // create access to file
            for(Student s : Roster)
            {
                outputFile.write(s.GetStudentID()+"\r\n");
                outputFile.write(s.GetFirstName()+"\r\n");
                outputFile.write(s.GetLastName()+"\r\n");
                outputFile.write(s.GetGrade()+"\r\n");
            }

            outputFile.close();
            System.out.println("Successfully wrote to file "+outputFileName);
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred: "+e);
        }
    }
    /*******************************************************************************
     * ReadFromFile                                                                 *
     *                                                                              *
     * Purpose: reads array from text file                                          *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    void ReadFromFile()
    {
        Roster.clear();

        // try to read from a file
        try
        {
            File inputFile = new File("Roster.txt");      // create access to file
            Scanner inputScanner = new Scanner(inputFile); // create scanner for file

            while (inputScanner.hasNextLine())
            {
                Student s = new Student();

                String line1 = inputScanner.nextLine();
                s.SetStudentID(Integer.parseInt(line1));

                String line2 = inputScanner.nextLine();
                s.SetFirstName(line2);

                String line3 = inputScanner.nextLine();
                s.SetLastName(line3);

                String line4 = inputScanner.nextLine();
                s.SetGrade(Double.parseDouble(line4));

                Roster.add(s);
            }

            inputScanner.close();
            //System.out.println(Roster);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error has occurred: "+e);
        }

    }
    /*******************************************************************************
     * ReturnToMain                                                                 *
     *                                                                              *
     * Purpose: redirects to main menu                                              *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    private void ReturnToMain() {
        System.out.println();
        System.out.println("Press any key to return to main menu");
        userInput.nextLine();
        DisplayMenu();


    }
}