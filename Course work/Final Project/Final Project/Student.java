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
 * Defines the Student class                                                    *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Student
{
    //Attributes
    private int StudentID;
    private String LastName;
    private String FirstName;
    private double Grade;

    /*******************************************************************************
     * Student                                                                      *
     *                                                                              *
     * Purpose: Default constructor                                                 *
     * Parameters:                                                                  *
     *     none (how does it work? Magic!)                                          *
     * Return Value:  none its a constructor                                        *
     *******************************************************************************/
    Student()
    {

    }


    int GetStudentID() { return StudentID; }
    /*******************************************************************************
     * GetStudentLastName                                                           *
     *                                                                              *
     * Purpose: Allows read access to the student last name                         *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  students last name                                            *
     *******************************************************************************/
    String GetLastName() { return LastName; }
    /*******************************************************************************
     * GetStudentFirstName                                                          *
     *                                                                              *
     * Purpose: Allows read access to the student first name                        *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  students first name                                           *
     *******************************************************************************/
    String GetFirstName() { return FirstName; }
    /*******************************************************************************
     * GetGrade                                                                     *
     *                                                                              *
     * Purpose: Allows read access to the student grade                             *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  students grade                                                *
     *******************************************************************************/
    double GetGrade() { return Grade; }

    /*******************************************************************************
     * SetStudentID                                                                 *
     *                                                                              *
     * Purpose: Allows write access to the student ID                               *
     * Parameters:                                                                  *
     *     students id number                                                       *
     * Return Value:  none                                                          *
     *******************************************************************************/
    void SetStudentID(int studentid)
    {
        StudentID = studentid;

        //for testing
        //System.out.println(StudentID);
    }
    /*******************************************************************************
     * SetLastName                                                                  *
     *                                                                              *
     * Purpose: Allows write access to the student last name                        *
     * Parameters:                                                                  *
     *     students last name                                                       *
     * Return Value:  none                                                          *
     *******************************************************************************/
    void SetLastName(String lastname)
    {
        LastName = lastname;

        //for testing
        //System.out.println(LastName);
    }
    /*******************************************************************************
     * SetFirstName                                                                 *
     *                                                                              *
     * Purpose: Allows write access to the student first name                       *
     * Parameters:                                                                  *
     *     students first name                                                      *
     * Return Value:  none                                                          *
     *******************************************************************************/
    void SetFirstName(String firstname)
    {
        FirstName = firstname;

        //for testing
        //System.out.println(FirstName);
    }
    /*******************************************************************************
     * SetGrade                                                                     *
     *                                                                              *
     * Purpose: Allows write access to the student grade                            *
     * Parameters:                                                                  *
     *     students grade                                                           *
     * Return Value:  none                                                          *
     *******************************************************************************/
    void SetGrade(double grade)
    {
        Grade = grade;

        //for testing
        //System.out.println(Grade);
    }
    /*******************************************************************************
     * toString                                                                     *
     *                                                                              *
     * Purpose: Displays student info                                               *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  string of student info                                        *
     *******************************************************************************/
    public String toString()
     {
         String s = "";
         s += this.StudentID + this.FirstName + this.LastName +  this.Grade;
         return s;
     }

}
