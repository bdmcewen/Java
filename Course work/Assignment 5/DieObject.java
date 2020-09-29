/*******************************************************************************
*                            Assignment 5 - Yahtzee Solo                       *
*                                                                              *
* PROGRAMMER:       Ben McEwen                                                 *
* CLASS:            CS102                                                      *
* ASSIGNMENT:       Assignment assign-5                                        *
* INSTRUCTOR:       Dean Zeller                                                *
* SUBMISSION DATE:  3/08/2019                                                  *
*                                                                              *
* DESCRIPTION:                                                                 *
* This defines the class which is used a blueprint when creating a die object. *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
* original work, without use of outside sources.                               *
*******************************************************************************/
import java.util.Random;

public class DieObject
{

  //Attributes
    private String name;
    private int sides;
    private int value;

  //Constructors
    public DieObject(String name_, int sides_, int value_)
    {
        this.name = name_;
        this.sides = sides_;
        this.value = value_;
    }
    public DieObject(String name_, int sides_)
    {
        this.name = name_;
        this.sides = sides_;
        this.value = 1;
    }
    public DieObject(String name_)
    {
        this.name = name_;
        this.sides = 6;
        this.value = 1;
    }
    public DieObject()
    {
        this.name = "cube";
        this.sides = 6;
        this.value = 1;
    }

    //Get Methods   
    String getName()
    {
        return this.name;
    }
    int getSides()
    {
        return this.sides;
    }
    int getValue()
    {
        return this.value;
    }

    //Set Methods 
    public void setName(String name_)
    {
         this.name = name_;
    }    
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

    //Miscellaneous Methods
    public void addToValue(int addto_)
    {
        this.value += addto_;
    }

    int roll(int sides)
    {
        Random roll = new Random();
        this.value = roll.nextInt(sides) +1;
        return value;
    }

    void cheat(int cheatValue_)
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

    private void reallyCheat(int cheatValue_)
    {
        int cheatValue = cheatValue_;
        this.value = cheatValue;
    }
    
}
