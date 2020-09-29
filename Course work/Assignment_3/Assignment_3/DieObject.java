/*******************************************************************************
 *                            Assignment 3 - Die Object                         *
 *                                                                              *
 * PROGRAMMER:       Ben-McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Assignment assign-3                                        *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  Feb 15                                                     *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * description-of-program                                                       *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 your-name and Dean Zeller. This is        *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.Random;

public class DieObject
{
    //Attributes
    private String name;
    private int sides;
    private int value;

    //Constructor
    DieObject(String name_, int sides_, int value_)
    {
        this.name = name_;
        this.sides = sides_;
        this.value = value_;

    }

    //Get Methods
    /*
    String getName()
    {
        return this.name;
    }
    */
    int getSides()
    {
        return this.sides;
    }
    int getValue()
    {
        return this.value;
    }

    //Set Methods
    /*
    public void setName(String name_)

    {
         this.name = name_;
    }
    */
    void setSides(int sides_)
    {
        //error checking
        if (sides_<4.0)
        {
            System.out.println("Warning: cannot set Sides to less than 4.0.");
            System.out.println("Attribute not changed");
            return;
        }
        this.sides = sides_;
    }
    void setValue(int value_)
    {
        //error checking
        if (value_<1.0)
        {
            System.out.println("Warning: cannot set value to less than 1.0.");
            System.out.println("Attribute not changed");
            return;
        }
        this.value = value_;
    }

    //printReport method
    /*
    public String printReport()//String report_
    {
        //this.report = report_;
        this.report = "";
        this.report += "+-----------------------+\n";
        this.report += this.name;
        this.report += this.sides;
        this.report += this.value;
        this.report += "+-----------------------+";
        return this.report;
    }
    */

    //other methods
    /*
    public void addToValue(int addto_)
    {
        this.value += addto_;
    }
    */

    int roll(int sides)
    {
        Random roll = new Random();
        value = roll.nextInt(sides) +1;
        return value;
    }
    /*
    private void cheat(int cheatValue_)
    {
        int cheatValue = cheatValue_;

        if (cheatValue <= this.sides)
        {
            this.value = cheatValue;
        }
        else {
            System.out.println("Value entered is outside permitted range.");
        }

    }

    private void cheaterCheater(int cheaterValue_)
    {
        int cheaterValue = cheaterValue_;
        this.value = cheaterValue;
    }
    */










}
