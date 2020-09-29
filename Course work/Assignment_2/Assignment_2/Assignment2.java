/*******************************************************************************
*                           Assignment 2 – Python to Java II                   *
*                                                                              *
* PROGRAMMER:       Ben-McEwen                                                 *
* CLASS:            CG102                                                      *
* ASSIGNMENT:       Assignment 2                                               *
* INSTRUCTOR:       Dean Zeller                                                *
* SUBMISSION DATE:  Feb 4                                                      *
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

public class Assignment2
{
    public static void main(String[] args) 
    {
        // Declares variables
        int len;
        double  horizline, num, sum, max, min, stDev, vartop, var, xvar, avg;
        String response, title;
        ArrayList<Double> data = new ArrayList<Double>(); // Create an ArrayList object
       
        // requests report title
        Scanner reader1 = new Scanner(System.in);
        System.out.println();       
        System.out.print("Please enter the name of the report.\n    => ");
        title = reader1.nextLine();
        
        // requests report data
        Scanner reader2 = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter data, ending with a negative number.");
        num = 1;
        sum = 0;
        max = -1000;
        min = 1000;
        int count = 1;
        
        //requests user defined series of positive numbers
        while (num >= 0)
        {
            System.out.printf("  num#%d => ", count);
            num = reader2.nextDouble();
            
            
            //stops loop if 0 is entered (notice there are no braces)
            if (num < 0)
                break;
            
            // iterates for responses greater than 0
            if (num >= 0)
            {
               data.add(num);
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
        //System.out.println(Math.round(len) + " numbers were entered: " + datastring);
        //System.out.println();
        
        //declares variable, typecasts int to double for sum and len, calculates average of data
        avg = (sum/len);
        
        //Calculate variance
        vartop = 0.00;
        
        for (double x : data)
            vartop +=(x-avg) * (x-avg);
        var = vartop/(len-1);
            
        //Calculate standard deviation
        //stDev = (var^(1/2));
        stDev = Math.sqrt(var);
        
        //prints report
        System.out.println(title);
        //for (int i = 0; i < horizline; i++)
            //System.out.print("-");
      
        System.out.format("\n  Data:    "   + datastring);
        System.out.format("\n  Count:       %8d"   , len);
        System.out.format("\n  Sum:         %8.2f"   , sum);
        System.out.format("\n  Average:     %8.2f"   , avg);
        System.out.format("\n  Smallest:    %8.2f"   , min);
        System.out.format("\n  Largest:     %8.2f"   , max);
        System.out.format("\n  Range:       %8.2f"   , (max - min));
        System.out.format("\n  Variance:    %8.2f"   , var);
        System.out.format("\n  StdDev:      %8.2f"   , stDev);
        System.out.println();
        
        //testdata1 ( 5 12 8 32 6 ) 
        //testdata2 ( 10.5 1.5 2.8 9.4 4.2 16.5 47.8 45.1 11.8 )
        //testdata3 ( 100 105 104 106 99 102 105 104 97 110 108 109 100 101 100 98 )
        

          }
}