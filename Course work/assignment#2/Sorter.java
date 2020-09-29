/*******************************************************************************
 *                  Assignment 2 - Sorting Algorithms                           *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Assignment assign-#2                                       *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  10-04-2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This file runs the menus and calls the methods from the                      *
 * individual sorting classes                                                   *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is                       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.*;

public class Sorter
{
    public static String header = "*************************************************************************";

    private static ArrayList<Integer> myArray = new ArrayList<>();

    private static void testInput()
    {
        myArray.add(45);
        myArray.add(37);
        myArray.add(92);
        myArray.add(62);
        myArray.add(17);
        myArray.add(51);
        myArray.add(81);
        myArray.add(6);
        myArray.add(29);
        myArray.add(74);
    }

    private static void userInput()
    {
        int length = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        length = s.nextInt();
        System.out.println("Enter the elements of the array(separated by a space):");

        for (int i = 0; i < length; i++)
        {
            System.out.printf("Enter the value of element for index %1d => ", i);
            myArray.add(s.nextInt());
        }
    }

    private static void randomInput()
    {
        Random rand = new Random();

        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
        myArray.add(rand.nextInt(100));
    }

    private static void inputMenu() {
        System.out.println();
        System.out.println("Choose Your Input");
        System.out.println("------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("1: Use Test Data");
        System.out.println("2: Use User Data");
        System.out.println("3: Use Random Data");
        System.out.println("4: Exit program");

        System.out.println();
        System.out.println("Please enter a menu number: ");
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                testInput();
                break;

            case "2":
                userInput();
                break;

            case "3":
                randomInput();
                break;

            case "4":
                System.exit(0);
                break;


            default:
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                inputMenu();
        }
    }

    private static void sortingMenu() {
        System.out.println();
        System.out.println("Sorting Algorithms");
        System.out.println("------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("1: Bubble Sort");
        System.out.println("2: Insertion Sort");
        System.out.println("3: Selection Sort");
        System.out.println("4: Quick Sort");
        System.out.println("5: Exit program");
        System.out.println();
        System.out.println("Please enter a menu number: ");
        String choice = input.nextLine();

        switch (choice) {
            case "1":
                bubbleSorter(myArray);
                break;

            case "2":
                insertionSorter(myArray);
                break;

            case "3":

                selectionSorter(myArray);
                break;

            case "4":

                quickSorter(myArray);
                break;

            case "5":
                System.exit(0);
                break;


            default:
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                sortingMenu();
        }
    }

    //sort using bubble sort
    private static void bubbleSorter(ArrayList<Integer> arr) {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();
        System.out.println(header);
        System.out.println("Bubble Sort");
        System.out.println(header);

        //System.out.println(arr);
        tempArr = BubbleSort.bubbleSort(arr);
        System.out.println("\n\nThe bubblesort array is:");
        for(int tempi: tempArr){System.out.printf("%3d",tempi);}

        returnToMenu();
    }

    //sorts using Insertion sort
    private static void insertionSorter(ArrayList<Integer> arr) {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();

        System.out.println(header);
        System.out.println("Insertion Sort");
        System.out.println(header);

        //System.out.println(arr);
        tempArr = InsertionSort.insertionSort(arr);
        System.out.println("\n\nThe insertionsort array is:");
        for(int tempi: tempArr){System.out.printf("%3d",tempi);}

        returnToMenu();
    }


    //sorts using Selection sort
    private static void selectionSorter(ArrayList<Integer> arr) {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();

        System.out.println(header);
        System.out.println("Selection Sort");
        System.out.println(header);

        //System.out.println(arr);
        tempArr = SelectionSort.selectionSort(arr);
        System.out.println("\n\nThe selectionsort array is:");
        for(int tempi: tempArr){System.out.printf("%3d",tempi);}

        returnToMenu();
    }


    //sorts using Quick sort
    private static void quickSorter(ArrayList<Integer> arr) {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();

        System.out.println(header);
        System.out.println("Quick Sort");
        System.out.println(header);

        //System.out.println(arr);
        tempArr = QuickSort.quickSort(arr);
        System.out.println("\n\nThe quicksort array is:");
        for(int tempi: tempArr){System.out.printf("%3d",tempi);}

        returnToMenu();
    }

    //returns to menu
    private static void returnToMenu() {
        System.out.println("\n\nPress Enter key to continue...");
        try {
            System.in.read();
            sortingMenu();
        } catch (Exception e) {
        }
        sortingMenu();
    }

    //Main Method to kick it all off
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Sorted Sorter.");
        Sorter.inputMenu();
        Sorter.sortingMenu();
    }

}