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
 * This defines the class which is used a blueprint when creating a             *
 * Yahtzee Solo game.                                                           *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class YahtzeeSoloGame
{
    char response;


    ArrayList<Integer> toReRoll = new ArrayList<>();
    ArrayList<Integer> rowsUsed = new ArrayList<>();
    YahtzeeScoreCard myScores = new YahtzeeScoreCard();

    //methods
    public void DisplayMenu()
    {
        System.out.println();
        System.out.println("Yahtzee Solo Game");
        System.out.println("----------------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("1: Display Score Card");
        System.out.println("2: Roll Dice");
        System.out.println("3: Choose die to reroll");
        System.out.println("4: Reroll Dice");
        System.out.println("5: Accept Score and record to Score Card");
        System.out.println("7: Exit program");
        System.out.println();
        System.out.println("Please enter a menu number: ");
        String choice = input.nextLine();

        switch (choice)
        {
            case "1":
                myScores.displayScoresheet();
                break;

            case "2":
                //myScores.totalScore = 0;
                myScores.myHand.rollDice();
                break;

            case "3":
                requestYN();
                break;

            case "4":
                myScores.rerollDice(myScores.d1,myScores.d2,myScores.d3,myScores.d4,myScores.d5);

                break;

            case "5":
                SetScores();
                break;

            case "6":

                break;

            case "7":
                System.exit(0);
                break;

            default:
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                DisplayMenu();
        }
    }

    public void requestYN()
    {
        if(myScores.rerollcount < 2)
        {
            char affirmative = 'y', negatory = 'n';
            char response;
            Scanner reader2 = new Scanner(System.in);
            System.out.println();
            System.out.println("Are you sure you would like to reroll some die? (enter y or n)");
            response = reader2.next().charAt(0);

            if(response == affirmative)
            {
                popReRoll();
            }
            if(response == negatory)
            {
                DisplayMenu();
            }
        }
        if(myScores.rerollcount == 2 )
        {
            System.out.println("You are out of re-rolls Please choose option 5");
            DisplayMenu();
        }

    }

    public void popReRoll()
    {
        ResetBools();
        toReRoll.clear();
        Scanner reader3 = new Scanner(System.in);
        System.out.println();
        System.out.println("Which die would you like to reroll?(Enter #s (1-5) ");
        String sr = reader3.nextLine();
        if(sr.length() < 5)
        for (int i = 0;i < sr.length();i++)
        {
            int ir = (sr.charAt(i)-48);
            toReRoll.add(ir);
        }
        if(sr.length() >= 5)
        {
            System.out.println("There are only five die, what are you trying pull?");
        }
        System.out.println("you have chosen to re throw: " + toReRoll.toString());
        SetBools();
        //toReRoll.add(Integer.parseInt(r));
        /*
        if(toReRoll.size() < 5)
        {
            SetBools();
            requestYN();
        }
        if(toReRoll.size() == 5)
        {
            System.out.println("You have chosen to reroll all 5 die");
            System.out.println("Returning to main menu");
            SetBools();
            DisplayMenu();
        }
        */
    }

    public void ResetBools()
    {
        myScores.d1 = false;
        myScores.d2 = false;
        myScores.d3 = false;
        myScores.d4 = false;
        myScores.d5 = false;
    }

    public void SetBools ()
    {
        for (int i : toReRoll)
        {
            if (i == 1)
            {
                myScores.d1 = true;
            }

            if (i == 2)
            {
                myScores.d2 = true;
            }

            if (i == 3)
            {
                myScores.d3 = true;
            }

            if (i == 4)
            {
                myScores.d4 = true;
            }

            if (i == 5)
            {
                myScores.d5 = true;
            }
        }
    }


    public void SetScores()
    {
        String s = "";

        Scanner reader4 = new Scanner(System.in);
        myScores.displayScoresheet();
        System.out.println("Please enter the number of the row in which to log your score.");
        s = reader4.nextLine();
        int rowChoice = Integer.parseInt(s);
        System.out.println("You have chosen row: " + s);

        for(Integer row:rowsUsed)
        {
            if(row == rowChoice)
            {
                System.out.println("That score has already been set.\n Press enter to choose another row.");
                SetScores();
            }
        }

        rowsUsed.add(rowChoice);
        System.out.println("Row choice array:"  + rowsUsed);

        if(rowChoice ==1 )
        {
            myScores.scoreOnes();
        }

        if(rowChoice == 2)
        {
            myScores.scoreTwos();
        }

        if(rowChoice == 3)
        {
            myScores.scoreThrees();
        }

        if(rowChoice == 4)
        {
            myScores.scoreFours();
        }

        if(rowChoice == 5)
        {
            myScores.scoreFives();
        }

        if(rowChoice == 6)
        {
            myScores.scoreSixes();
        }

        if(rowChoice == 7)
        {
            myScores.scoreThreeKind();
        }

        if(rowChoice == 8)
        {
            myScores.scoreFourKind();
        }

        if(rowChoice == 9)
        {
            myScores.scoreFullHouse();
        }

        if(rowChoice == 10)
        {
            myScores.scoreSmallStraight();
        }

        if(rowChoice == 11)
        {
            myScores.scoreLargeStraight();
        }

        if(rowChoice == 12)
        {
            myScores.scoreYahtzee();
        }

        if(rowChoice == 13)
        {
            myScores.scoreChance();
        }

        myScores.scoresBonus();
        myScores.scoresTotal();
        myScores.turnsCounter++;
        myScores.rerollcount = 0;
        toReRoll.clear();
        myScores.scores.clear();
        System.out.println("Your score has been recorded to row: " + s);
        System.out.println("Please choose option 2 to reroll all die.");

    }


}
