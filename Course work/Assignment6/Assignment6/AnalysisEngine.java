/*******************************************************************************
 *                            Assignment 6 - File IO                            *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Assignment assign-6                                        *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  3/29/2019                                                  *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This file is a tester for assignment 6                                       *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/

// library imports necessary for file input
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class AnalysisEngine
{
    //Attributes
    public String	studyLeader,
            studyTitle,
            studyDate,
            inputFileName,
            outputFileName;

    public ArrayList<Double> rawData = new ArrayList<>();
    public ArrayList<Double> sortedData = new ArrayList<>();

    public int rawDataCardinality = 0;

    public Double n = 0.0,
            sum = 0.0,
            average = 0.0,
            variance = 0.0,
            standardDeviation = 0.0,
            min = 1000.0,
            max = -1000.0,
            median = 0.0;

    public boolean inputProvided = false,
            outputExists = false;
    //Constructors

    /*******************************************************************************
     * AnalysisEngine                                                               *
     *                                                                              *
     * Purpose:       instantiates attributes without default values                *
     * Parameters:                                                                  *
     *     Leader, title, date, input_file, output_file                             *
     * Return Value:  none                                                          *
     *******************************************************************************/
    public AnalysisEngine(String leader,String title,String date,String input_file,String output_file)
    {
        this.studyLeader = leader;
        this.studyTitle = title;
        this.studyDate = date;
        this.inputFileName = input_file;
        this.outputFileName = output_file;
    }

    /*******************************************************************************
     * AnalysisEngine                                                               *
     *                                                                              *
     * Purpose:       constructor initializes some attributes to default values     *
     * Parameters:                                                                  *
     *     nput_file, output_file                                                   *
     * Return Value:  none                                                          *
     *******************************************************************************/
    public AnalysisEngine(String input_file,String output_file)
    {
        this("Allan Touring","Enigma", "1936", input_file, output_file);
    }

    /*******************************************************************************
     * AnalysisEngine                                                               *
     *                                                                              *
     * Purpose:       initializes all attributes to default values                  *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  none                                                          *
     *******************************************************************************/
    public AnalysisEngine()
    {
        this("George Boole","Or Not", "1854", "lsdjfds.txt", "test_output3.txt");
    }

    //SetMethods

    /*******************************************************************************
     * SetLeader                                                                    *
     *                                                                              *
     * Purpose:       sets study leader name from user entered string               *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void SetLeader()
    {
        Scanner leaderScanner = new Scanner(System.in);
        System.out.print("Enter the head of research for this study => ");
        this.studyLeader = leaderScanner.nextLine();
        System.out.println("Hello, "  + studyLeader);
        System.out.println();


    }

    /*******************************************************************************
     * SetTitle                                                                     *
     *                                                                              *
     * Purpose:       sets title from user entered string                           *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void SetTitle()
    {
        Scanner titleScanner = new Scanner(System.in);
        System.out.print("Enter the Title of the study => ");
        this.studyTitle = titleScanner.nextLine();
        System.out.println("Name of study set to "  + studyTitle);
        System.out.println();


    }

    /*******************************************************************************
     * SetDate                                                                      *
     *                                                                              *
     * Purpose:       sets date from user entered string                            *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void SetDate()
    {
        Scanner dateScanner = new Scanner(System.in);
        System.out.print("Enter the date of this study => ");
        this.studyDate = dateScanner.nextLine();
        System.out.println();


    }

    /*******************************************************************************
     * SetIntputName                                                                *
     *                                                                              *
     * Purpose:       sets input file name from user entered string                 *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void SetInputName()
    {
        Scanner inputFileNameScanner = new Scanner(System.in);
        System.out.print("Enter the input data file for the study (leave blank for user-entry) => ");
        this.inputFileName = inputFileNameScanner.nextLine();
        if (inputFileName.equals(""))
        {
            System.out.println("No input data file entered, supplying input from user");
        }
        //inputFileNameScanner.close();

    }

    /*******************************************************************************
     * SetOutputName                                                                *
     *                                                                              *
     * Purpose:       sets output file name from user entered string                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void SetOutputName()
    {
        Scanner outputFileNameScanner = new Scanner(System.in);
        System.out.print("Enter the output data file for the study (blank for no file output) =>  ");
        this.outputFileName = outputFileNameScanner.nextLine();
        System.out.println("Output file of output1.txt created.\n" +
                "Warning: any existing file will be overwritten!\n");
        //outputFileNameScanner.close();

    }

    //Phase Methods

    /*******************************************************************************
     * Phase1                                                                       *
     *                                                                              *
     * Purpose:       calls methods used to collect data                            *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void Phase1()
    {
        System.out.println("Phase 1: Gather input");
        System.out.println("---------------------");

        this.InputFileExists();

        if(inputProvided)
        {
            ReadFileToArray();
        }
        else
        {
            RequestData();
        }

        System.out.println("Phase 1 Complete.");
    }

    /*******************************************************************************
     * Phase3                                                                       *
     *                                                                              *
     * Purpose:       calls methods used to calculate results                       *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void Phase2()
    {
        System.out.println("\nPhase 2: Perform calculations");
        System.out.println("-----------------------------");
        PrintRawData();
        PrintSortedData();
        CalculateSum();
        CalculateAverage();
        CalculateVariance();
        CalculateStDev();
        CalculateMin();
        CalculateMax();
        CalculateMedian();

        System.out.println("Phase 2 Complete.");
    }

    /*******************************************************************************
     * Phase2                                                                       *
     *                                                                              *
     * Purpose:       calls methods used to display results                         *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void Phase3()
    {
        System.out.println("\nPhase 3: Output Tables");
        System.out.println("------------------------");
        PrintReport();
        CompareResultsReport();
        DisplayReport();
        OutputReport();

        System.out.println("Phase 3 Complete.");
    }

    // Calculation Methods

    /*******************************************************************************
     * CreateSortedData                                                             *
     *                                                                              *
     * Purpose:       populates array with sorted data from raw data                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CreateSortedData()
    {
        sortedData.addAll(rawData);
        Collections.sort(sortedData);
    }

    /*******************************************************************************
     * CalculateSum                                                                 *
     *                                                                              *
     * Purpose:       calculates sum                                                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateSum()
    {
        for(double d: rawData)
        {
            sum += d;
        }

        System.out.println("\nCalculated sum (" + sum + ")" );
    }

    /*******************************************************************************
     * CalculateAverage                                                             *
     *                                                                              *
     * Purpose:       calculates average                                            *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateAverage()
    {
        average = sum/rawDataCardinality;

        System.out.println("Calculated average (" + average + ")" );
    }

    /*******************************************************************************
     * CalculateVariance                                                            *
     *                                                                              *
     * Purpose:       calculates variance                                           *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateVariance()
    {
        double vartop = 0.0;

        for (double x : sortedData)
            vartop +=(x-average) * (x-average);
        variance = vartop/(rawDataCardinality-1);

        System.out.println("Calculated variance (" + variance + ")" );
    }

    /*******************************************************************************
     * CalculateStDev                                                               *
     *                                                                              *
     * Purpose:       calculates standard deviation                                 *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateStDev()
    {
        standardDeviation = Math.sqrt(variance);

        System.out.println("Calculated standard deviation (" + standardDeviation + ")" );
    }

    /*******************************************************************************
     * CalculateMin                                                                 *
     *                                                                              *
     * Purpose:       calculates smallest value                                     *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateMin()
    {
        for(double d: rawData)
        {
            if (min > d)
                min = d;
        }

        System.out.println("Calculated min (" + min + ")" );
    }

    /*******************************************************************************
     * CalculateMax                                                                 *
     *                                                                              *
     * Purpose:       calculates largest value                                      *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateMax()
    {
        for(double d: rawData)
        {
            if (max < d)
                max = d;
        }

        System.out.println("Calculated max (" + max + ")" );
    }

    /*******************************************************************************
     * CalculateMedian                                                              *
     *                                                                              *
     * Purpose:       calculates median                                             *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CalculateMedian()
    {
        median = (double)sortedData.size()/2;
        if (sortedData.size()%2 == 1) {
            median = (sortedData.get(sortedData.size() / 2) + sortedData.get(sortedData.size() / 2 - 1))/2;
        } else {
            median = sortedData.get(sortedData.size() / 2);
        }
    }

    //Supporting Methods

    /*******************************************************************************
     * RequestData                                                                  *
     *                                                                              *
     * Purpose:       requests user to input data manually                          *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void RequestData()
    {
        Scanner dataReader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter data, ending with a negative number.");
        int lineCount = 1;

        //requests user defined series of positive numbers
        while (n >= 0)
        {
            System.out.printf("  num#%d => ", lineCount);
            n = dataReader.nextDouble();

            //stops loop if negative is entered
            if (n < 0)
                break;

            // iterates for responses greater than 0
            if (n >= 0)
            {
                rawData.add(n);
                lineCount += 1;
            }
        }
        rawDataCardinality = rawData.size();
        CreateSortedData();
    }

    /*******************************************************************************
     * ReadFileToArray                                                              *
     *                                                                              *
     * Purpose:       reads data from an external file into an array                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void ReadFileToArray()
    {
        double num;

        try
        {
            File inputFile = new File(inputFileName);      // create access to file
            Scanner inputScanner = new Scanner(inputFile); // create scanner for file
            while (inputScanner.hasNextLine())
            {
                String line = inputScanner.nextLine();
                num = Double.parseDouble(line);
                System.out.println("input: "+ num);
                rawData.add(num);
            }
            inputScanner.close();
            System.out.println("Data: "+ rawData);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Input file was either not found or not provided");
            System.out.println("\nRunning Request for New Data");
            RequestData();
        }

        rawDataCardinality = rawData.size();
        CreateSortedData();
    }

    /*******************************************************************************
     * InputFileExists                                                              *
     *                                                                              *
     * Purpose:       checks that an input file name was provided                   *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void InputFileExists()
    {
        inputProvided = !inputFileName.equals("");
    }

    /*******************************************************************************
     * OutputFileExists                                                             *
     *                                                                              *
     * Purpose:       checks that an ouput file name was provided                   *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    boolean OutputFileExists()
    {
        if(outputFileName == null)
        {
            outputExists = false;
        }

        if(inputFileName != null)
        {
            outputExists = true;
        }

        return outputExists;
    }

    // Print Methods

    /*******************************************************************************
     * PrintRawData                                                                 *
     *                                                                              *
     * Purpose:       displays data in original format (w/o sorting)                *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void PrintRawData()
    {
        System.out.print("\nRawData: ");
        for(double d: rawData)
            System.out.print(d + " ");
    }

    /*******************************************************************************
     * PrintSortedData                                                              *
     *                                                                              *
     * Purpose:       displays sorted data                                          *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void PrintSortedData()
    {
        System.out.print("\nSortedData: ");
        for(double d: sortedData)
            System.out.print(d + " ");
    }

    /*******************************************************************************
     * PrintReport                                                                  *
     *                                                                              *
     * Purpose:       displays table of calculated results                          *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void PrintReport()
    {
        System.out.print("\n+-----------------------------------+");
        System.out.format("\n|  %-31s  |" , studyTitle);
        System.out.format("\n|  by %-28s  |" , studyLeader);
        System.out.format("\n|  Date: %-25s  |" , studyDate);
        System.out.print("\n+-----------------------------------+");
        System.out.format("\n|  Input File:  %18s  | "   , inputFileName);
        System.out.format("\n|  Output File: %18s  | "   , outputFileName);
        System.out.format("\n|  N:       %18d      |"   , rawDataCardinality);
        System.out.format("\n|  Sum:         %18.3f  |"   , sum);
        System.out.format("\n|  Mean:        %18.3f  |"   , average);
        System.out.format("\n|  Variance:    %18.3f  |"   , variance);
        System.out.format("\n|  StdDev:      %18.3f  |"   , standardDeviation);
        System.out.format("\n|  Smallest:    %18.3f  |"   , min);
        System.out.format("\n|  Largest:     %18.3f  |"   , max);
        System.out.format("\n|  Median:      %18.3f  |"   , median);
        System.out.print("\n+-----------------------------------+");
    }

    /*******************************************************************************
     * CompareResultsReport                                                         *
     *                                                                              *
     * Purpose:       displays table which compares calculated and lib results      *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void CompareResultsReport()
    {
        System.out.print("\n+-----------------------------------+");
        System.out.format("\n| %-32s  |" , studyTitle);
        System.out.format("\n| by %-29s  |" , studyLeader);
        System.out.format("\n| Date: %-26s  |" , studyDate);
        System.out.print("\n+-----------------------------------+");
        System.out.format("\n| N = %-28s  |" , rawDataCardinality);
        System.out.format("\n| %35s" , "Calculated   Actual  |");
        System.out.format("\n| Sum:          %8.2f  "   , this.sum ); System.out.format("%8.2f  |"   , sum );
        System.out.format("\n| Mean:         %8.2f  "   , this.average); System.out.format("%8.2f  |"   , average  );
        System.out.format("\n| Variance:     %8.2f  "   , this.variance); System.out.format("%8.2f  |"   , variance );
        System.out.format("\n| StdDev:       %8.2f  "   , this.standardDeviation); System.out.format("%8.2f  |"   , standardDeviation );
        System.out.format("\n| Smallest:     %8.2f  "   , this.min); System.out.format("%8.2f  |"   , min );
        System.out.format("\n| Largest:      %8.2f  "   , this.max); System.out.format("%8.2f  |"   , max );
        System.out.format("\n| Median:       %8.2f  "   , this.median); System.out.format("%8.2f  |"   , median );
        System.out.print("\n+-----------------------------------+");
    }

    /*******************************************************************************
     * DisplayReport                                                                *
     *                                                                              *
     * Purpose:       displays output in a printable UI window                      *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void DisplayReport()
    {
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Print UI Report");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JTextArea text = new JTextArea(50, 50);
        text.setFont(new Font("Monospaced", Font.PLAIN, 16));

        text.append("+--------------------------------------+");
        text.append(String.format("\n|  %-34s  |" , studyTitle));
        text.append(String.format("\n|  by %-31s  |" , studyLeader));
        text.append(String.format("\n|  Date: %-28s  |" , studyDate));
        text.append("\n+--------------------------------------+");
        text.append(String.format("\n|  Input File:     %18s  | "   , inputFileName));
        text.append(String.format("\n|  Output File:    %18s  | "   , outputFileName));
        text.append(String.format("\n|  N:          %18d      |"   , rawDataCardinality));
        text.append(String.format("\n|  Sum:            %18.3f  |"   , sum));
        text.append(String.format("\n|  Mean:           %18.3f  |"   , average));
        text.append(String.format("\n|  Variance:       %18.3f  |"   , variance));
        text.append(String.format("\n|  StdDev:         %18.3f  |"   , standardDeviation));
        text.append(String.format("\n|  Smallest:       %18.3f  |"   , min));
        text.append(String.format("\n|  Largest:        %18.3f  |"   , max));
        text.append(String.format("\n|  Median:         %18.3f  |"   , median));
        text.append("\n+--------------------------------------+");

        text.append("\n\n+--------------------------------------+");
        text.append(String.format("\n| %-35s  |" , studyTitle));
        text.append(String.format("\n| by %-32s  |" , studyLeader));
        text.append(String.format("\n| Date: %-29s  |" , studyDate));
        text.append("\n+--------------------------------------+");
        text.append(String.format("\n| N = %-31s  |" , rawDataCardinality));
        text.append(String.format("\n| %38s" , "Calculated   Actual  |"));
        text.append(String.format("\n| Sum:             %8.2f  "   , sum )); text.append(String.format("%8.2f  |"   , sum ));
        text.append(String.format("\n| Mean:            %8.2f  "   , average)); text.append(String.format("%8.2f  |"   , average ));
        text.append(String.format("\n| Variance:        %8.2f  "   , variance)); text.append(String.format("%8.2f  |"   , variance ));
        text.append(String.format("\n| StdDev:          %8.2f  "   , standardDeviation)); text.append(String.format("%8.2f  |"   , standardDeviation ));
        text.append(String.format("\n| Smallest:        %8.2f  "   , min)); text.append(String.format("%8.2f  |"   , min ));
        text.append(String.format("\n| Largest:         %8.2f  "   , max)); text.append(String.format("%8.2f  |"   , max ));
        text.append(String.format("\n| Median:          %8.2f  "   , median)); text.append(String.format("%8.2f  |"   , median ));
        text.append("\n+--------------------------------------+");


        JScrollPane pane = new JScrollPane(text);
        pane.setPreferredSize(new Dimension(525,725));
        f.add("Center", pane);


        JButton printButton = new JButton("Print This Window");
        printButton.addActionListener(new PrintUIWindow(f));
        f.add("South", printButton);


        f.pack();
        f.setVisible(true);


    }

    /*******************************************************************************
     * OutputReport                                                                 *
     *                                                                              *
     * Purpose:       writes output to file                                         *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void OutputReport()
    {
        try
        {
            FileWriter outputFile = new FileWriter(outputFileName);  // create access to file

            outputFile.write("+-----------------------------------+");
            outputFile.write(String.format("\n|  %-31s  |" , studyTitle));
            outputFile.write(String.format("\n|  by %-28s  |" , studyLeader));
            outputFile.write(String.format("\n|  Date: %-25s  |" , studyDate));
            outputFile.write("\n+-----------------------------------+");
            outputFile.write(String.format("\n|  Input File:  %18s  | "   , inputFileName));
            outputFile.write(String.format("\n|  Output File: %18s  | "   , outputFileName));
            outputFile.write(String.format("\n|  N:       %18d      |"   , rawDataCardinality));
            outputFile.write(String.format("\n|  Sum:         %18.3f  |"   , sum));
            outputFile.write(String.format("\n|  Mean:        %18.3f  |"   , average));
            outputFile.write(String.format("\n|  Variance:    %18.3f  |"   , variance));
            outputFile.write(String.format("\n|  StdDev:      %18.3f  |"   , standardDeviation));
            outputFile.write(String.format("\n|  Smallest:    %18.3f  |"   , min));
            outputFile.write(String.format("\n|  Largest:     %18.3f  |"   , max));
            outputFile.write(String.format("\n|  Median:      %18.3f  |"   , median));
            outputFile.write("\n+-----------------------------------+");

            outputFile.write("\n\n+-----------------------------------+");
            outputFile.write(String.format("\n| %-32s  |" , studyTitle));
            outputFile.write(String.format("\n| by %-29s  |" , studyLeader));
            outputFile.write(String.format("\n| Date: %-26s  |" , studyDate));
            outputFile.write("\n+-----------------------------------+");
            outputFile.write(String.format("\n| N = %-28s  |" , rawDataCardinality));
            outputFile.write(String.format("\n| %35s" , "Calculated   Actual  |"));
            outputFile.write(String.format("\n| Sum:          %8.2f  "   , sum )); outputFile.write(String.format("%8.2f  |"   , sum ));
            outputFile.write(String.format("\n| Mean:         %8.2f  "   , average)); outputFile.write(String.format("%8.2f  |"   , average ));
            outputFile.write(String.format("\n| Variance:     %8.2f  "   , variance)); outputFile.write(String.format("%8.2f  |"   , variance ));
            outputFile.write(String.format("\n| StdDev:       %8.2f  "   , standardDeviation)); outputFile.write(String.format("%8.2f  |"   , standardDeviation ));
            outputFile.write(String.format("\n| Smallest:     %8.2f  "   , min)); outputFile.write(String.format("%8.2f  |"   , min ));
            outputFile.write(String.format("\n| Largest:      %8.2f  "   , max)); outputFile.write(String.format("%8.2f  |"   , max ));
            outputFile.write(String.format("\n| Median:       %8.2f  "   , median)); outputFile.write(String.format("%8.2f  |"   , median ));
            outputFile.write("\n+-----------------------------------+");

            outputFile.close();
            System.out.println("\n\nSuccessfully wrote to file "+ outputFileName);
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred: "+e);
        }
    }

    /*******************************************************************************
     * PrintGreeting                                                                *
     *                                                                              *
     * Purpose:       displays greeting message                                     *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void PrintGreeting()
    {
        System.out.println("\nWelcome to Assignment 6, Data Processing");
        System.out.println();
    }

    /*******************************************************************************
     * PrintIntro                                                                   *
     *                                                                              *
     * Purpose:       displays introduction message                                 *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/
    public void PrintIntro()
    {
        System.out.println("Introduction:\n " +
                "This program will calculate various statistics for a list\n" +
                "of numbers.  It will run in three phases:\n" +
                "    Phase 1 – Gather user input\n" +
                "    Phase 2 – Calculate sum, average, variance, stdev, min, max, median\n" +
                "    Phase 3 – Output results to shell, graphic display, and file\n");
    }

     /*******************************************************************************
     * PrintFarewell                                                                *
     *                                                                              *
     * Purpose:       displays farwell message                                      *
     * Parameters:                                                                  *
     *     none                                                                     *
     * Return Value:  void                                                          *
     *******************************************************************************/

    public void PrintFarewell()
    {
        System.out.println("\nSo long and thanks for all the fish!!!\n" +
                "Existing Program.");


    }

}