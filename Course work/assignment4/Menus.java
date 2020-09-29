/*******************************************************************************
 *                  Assignment 4 - String Manipulation                          *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Assignment assign-#4                                       *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  11-15-2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This file runs the menus and calls the methods from the                      *
 * individual sorting classes                                                   *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is                       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/

import java.io.IOException;
import java.util.Scanner;

public class Menus {

    private static Toolkit tk = new Toolkit();

    //Main Method to kick it all off
    public static void main(final String[] args) throws IOException, InterruptedException {

        System.out.println("\nWelcome to the Bioinformatics Toolkit.");
        inputMenu();
        tk.preProcessing(tk.getRaw_data());
        processingMenu();
    }

    private static void inputMenu() throws IOException, InterruptedException {
        System.out.println();
        System.out.println("Choose Your Input");
        System.out.println("------------------");

        final Scanner input = new Scanner(System.in);
        System.out.println("1: Enter data manually");
        System.out.println("2: Read data from file");
        System.out.println("3: Generate random Data");
        System.out.println("4: Exit program");

        System.out.println();
        System.out.print("Please enter your selection => ");
        final String choice = input.nextLine();

        switch (choice) {
            case "1" -> tk.userDNAentry();
            case "2" -> tk.readDNAfromFile();
            case "3" -> tk.generateRandomDNA();
            case "4" -> System.exit(0);
            default -> {
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                inputMenu();
            }
        }
    }

    static void processingMenu() throws IOException, InterruptedException {
        System.out.println();
        System.out.println("String Manipulation");
        System.out.println("------------------");

        final Scanner input = new Scanner(System.in);
        System.out.println(" 1: Generate RNA");
        System.out.println(" 2: Search for Sequence");
        System.out.println(" 3: Multi-search sequence");
        System.out.println(" 4: Simple sequence analysis");
        System.out.println(" 5: Search for Subsequence");
        System.out.println(" 6: Replace Sequence");
        System.out.println(" 7: Longest common subsequence");
        System.out.println(" 8: Search repeating sequences");
        System.out.println(" 9: Generate report");
        System.out.println("10: Save DNA to File");
        System.out.println("11: Back to input menu");
        System.out.println();
        System.out.println("12: Exit Program");
        System.out.println();
        System.out.print("Please enter your selection => ");
        final String choice = input.nextLine();

        switch (choice) {
            case "1" -> tk.generateRna(tk.getData());
            case "2" ->tk.searchSequence(tk.getData());
            case "3" -> tk.multiSearchSequence(tk.getData());
            case "4" -> tk.simpleSequenceAnalysis(tk.getData());
            case "5" -> tk.searchSubsequence(tk.getData());
            case "6" -> tk.replaceSequence();
            case "7" -> tk.LCSD();
            case "8" -> tk.findRepeatedDnaSequences(tk.getData());
            case "9" -> tk.generateReport();
            case "10" -> tk.saveDNAtoFile();
            case "11" -> inputMenu();
            case "12" -> System.exit(0);
            default -> {
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                processingMenu();
            }
        }
    }


}
