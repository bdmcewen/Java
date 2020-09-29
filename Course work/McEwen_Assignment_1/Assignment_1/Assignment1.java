/*******************************************************************************
*                           Assignment 1 – Python to Java I                    *
*                                                                              *
* PROGRAMMER:       Ben-McEwen                                                 *
* CLASS:            CG120                                                      *
* ASSIGNMENT:       Assignment 1                                               *
* INSTRUCTOR:       Dean Zeller                                                *
* SUBMISSION DATE:  Friday, January 18th 2019                                  *
*                                                                              *
* DESCRIPTION:                                                                 *
*  This program applies basic satistical calulations                           *  
* to a series of positive integers.                                            *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is (c) 2019 your-name and Dean Zeller. This is original work,   *
* without use of outside sources.                                              *
*******************************************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class Assignment1
{
    public static void main(String[] args) 
    {
        // Declares variables
        int count;
        int len, horizline, num, sum, max, min;
        String response, title;
        ArrayList<String> data = new ArrayList<String>(); // Create an ArrayList object
       
        // requests report title
        Scanner reader1 = new Scanner(System.in);
        System.out.println();       
        System.out.print("Enter a title for this report \n => ");
        title = reader1.nextLine();
        
        // requests report data
        Scanner reader2 = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter numbers, end with a 0.");
        num = 1;
        sum = 0;
        max = -1000;
        min = 1000;
        count = 1;
        
        //requests user defined series of positive integers
        while (num > 0)
        {
            System.out.printf("  num#%d => ", count);
            response = reader2.nextLine();
            num = Integer.parseInt(response);
            
            //stops loop if 0 is entered (notice there are no braces)
            if (num == 0)
                break;
            
            // iterates for responses greater than 0
            if (num > 0)
            {
               data.add(response);
               sum += num;
               count += 1;
               
               ////determines integer with largest value
               if (max < num)
                   max = num;
               
               
               //determines integer with smallest value
               if (min > num)
                   min = num;
            }
        }
        len = data.size();
        horizline = title.length();
        System.out.println();
        
        //converts arraylist to string and allows character replacement
        String datastring = data.toString()
            .replace(",", "")  // replaces commas with nothing
            .replace("[", "")  // replaces open bracket with nothing
            .replace("]", "")  // replaces close bracket with nothing
            .trim();           //eliminates leading and trailing spaces
        
        
        //displays user defined series of positive integers    
        System.out.println(len + " numbers were entered: " + datastring);
        System.out.println();
        
        //declares variable, typecasts int to double for sum and len, calculates average of data
        Double avg = ((double)sum/(double)len);
        
        //prints report
        System.out.println(title);
        for (int i = 0; i < horizline; i++)
            System.out.print("-");
        
        System.out.printf("\n  N:         %-4d"   , len);
        System.out.printf("\n  Sum:       %-4d"   , sum);
        System.out.printf("\n  Average:   %-4s"   , avg);
        System.out.printf("\n  Smallest:  %-4d"   , min);
        System.out.printf("\n  Largest:   %-4d"   , max);
        System.out.printf("\n  Range:     %-4d"   , (max - min));
        System.out.println();
    }
}