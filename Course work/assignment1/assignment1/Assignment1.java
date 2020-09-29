/*******************************************************************************
 *                  Assignment 1 – Cuckoo Clock Simulation                      *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Assignment assign-#1                                       *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  09-13-2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This file is a class used to describe the behaviors and attributes           *
 * of a simple clock.                                                           *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is                       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.Scanner;

public class Assignment1
{
    public static void main(String[] args)
    {
        int hour;
        int minute = 0;
        int startHour;
        int endHour;
        int durationMin;
        int durationHour;
        String start;
        String end;


        Scanner reader1 = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter start hour:  =>  ");
        start = reader1.nextLine();
        startHour = Integer.parseInt(start);

        Scanner reader2 = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter end hour:  =>  ");
        end = reader2.nextLine();
        endHour = Integer.parseInt(end);

        hour = startHour;
        durationHour = (endHour - startHour);

        // loop fixes -hour due to end time being smaller than start time
        if (durationHour <0)
        {
            durationHour+=12;
        }

        durationMin = durationHour*60;

        for (int i =0; i< (durationMin + 1); i++) {

            while (minute + 1 >= 61)
            {
                minute = 0;
                hour++;
                if (hour == 13)
                {
                    hour = 1;
                }
            }

            //print "sound Effect"
            if (minute == 0)
            {
                //System.out.print ("\n[" + hour + ":" + "0" + minute + "]");
                System.out.println("\n");
                System.out.print("It's " + hour + " O'Clock ");
                for (int j = 1; j <= hour; j++) {
                    System.out.print ("Cuckoo! ");
                }
                System.out.print("\n");
            }

            else if (minute == (15) || minute == (30) || minute == (45)) {

                System.out.print ("\n[" + hour + ":" + minute + "]");
                System.out.println ("cuckoo");
            }

            if ((((minute % 2 == 0)) && ((minute != (0)))))
            {
                if (minute <= 9)
                {
                    System.out.print ("[" + hour + ":" + "0" + minute + "]");
                }
                else
                    System.out.print ("[" + hour + ":" + minute + "]");

                System.out.print(" tock ");
            }

            else  //((minute != (15)) || (minute != (45))&& ((minute != (0))))
            {
                if (minute <= 9)
                {
                    System.out.print ("[" + hour + ":" + "0" + minute + "]");
                }
                else
                    System.out.print ("[" + hour + ":" + minute + "]");

                System.out.print(" tick ");
            }

            minute++;

        }
        System.out.println ("\n\nEnding Simulation");
    }
}

