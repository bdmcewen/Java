/*******************************************************************************
 *                            Assignment 3 - Die Object Tester                  *
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
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.Scanner;

public class DieObjectTester {
    public static void main(String[] args) {
        DieObject cube = new DieObject("cube", 6, 1);
        DieObject hectohedron = new DieObject("hectohedron", 100, 1);
        DieObject dodecahedron = new DieObject("dodecahedron", 12, 1);
        DieObject dealersChoice = new DieObject("dealersChoice", 0, 1);

        int tempValue1, tempValue2, tempValue3, tempValue4, tempValue5;

        //print lines for testing
        /*
        System.out.println(cube.getName());
        System.out.println(cube.getSides());
        System.out.println(cube.getValue());

        System.out.println(hectohedron.getName());
        System.out.println(hectohedron.getSides());
        System.out.println(hectohedron.getValue());

        System.out.println(dodecahedron.getName());
        System.out.println(dodecahedron.getSides());
        System.out.println(dodecahedron.getValue());
        */

        System.out.println("\nTest 1: Six-sided die (D6)");
        System.out.println("\t Range 1 to " + cube.getSides());
        cube.roll(cube.getSides());
        System.out.println("\t Single number Test: " + cube.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                cube.roll(cube.getSides());
                System.out.print(" " + cube.getValue());
            }
        }
        System.out.println();

        System.out.println("\nTest 2: Percentile Die (D100");
        System.out.println("\t Range 1 to " + hectohedron.getSides());
        hectohedron.roll(hectohedron.getSides());
        System.out.println("\t Single number Test: " + hectohedron.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                hectohedron.roll(hectohedron.getSides());
                System.out.print(" " + hectohedron.getValue());
            }
        }
        System.out.println();

        System.out.println("\nTest 3: Random month (D12)");
        System.out.println("\t Range 1 to " + dodecahedron.getSides());
        dodecahedron.roll(dodecahedron.getSides());
        System.out.println("\t Single number Test: " + dodecahedron.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                cube.roll(cube.getSides());
                System.out.print(" " + cube.getValue());
            }
        }
        System.out.println();

        System.out.println("\nTest 4: Monopoly Turn (2D6 added together)");
        System.out.println("\t Range 2 to " + (cube.getSides() * 2));
        tempValue1 = cube.roll(cube.getSides());
        tempValue2 = cube.roll(cube.getSides());
        //System.out.println(" Temp value1 " + tempValue1 + " Temp value2 " + tempValue2);// print ln for testing
        cube.setValue(tempValue1 + tempValue2);
        System.out.println("\t Single number Test: " + cube.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                tempValue1 = cube.roll(cube.getSides());
                tempValue2 = cube.roll(cube.getSides());
                //System.out.print(" Temp value1 " + tempValue1  + " Temp value2 " + tempValue2);// print ln for testing
                cube.setValue(tempValue1 + tempValue2);
                System.out.print(" " + cube.getValue());
            }
        }
        System.out.println();

        System.out.println("\nTest 5: Yahtzee (5D6 added together)");
        System.out.println("\t Range 5 to " + (cube.getSides() * 5));
        tempValue1 = cube.roll(cube.getSides());
        tempValue2 = cube.roll(cube.getSides());
        tempValue3 = cube.roll(cube.getSides());
        tempValue4 = cube.roll(cube.getSides());
        tempValue5 = cube.roll(cube.getSides());
        //System.out.println(tempValue1 +" " + tempValue2 +" " + tempValue3 +" " + tempValue4 +" " + tempValue5);// print ln for testing
        cube.setValue(tempValue1 + tempValue2 + tempValue3 + tempValue4 + tempValue5);
        System.out.println("\t Single number Test: " + cube.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                tempValue1 = cube.roll(cube.getSides());
                tempValue2 = cube.roll(cube.getSides());
                tempValue3 = cube.roll(cube.getSides());
                tempValue4 = cube.roll(cube.getSides());
                tempValue5 = cube.roll(cube.getSides());
                //System.out.print(tempValue1 + tempValue2 + tempValue3 + tempValue4 + tempValue5);// print ln for testing
                cube.setValue(tempValue1 + tempValue2 + tempValue3 + tempValue4 + tempValue5);
                System.out.print(" " + cube.getValue());
            }
        }
        System.out.println();


        /// custom tester as extra
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of desired sides for a custom die(integers only).");
        int newSides = input.nextInt();
        dealersChoice.setSides(newSides);
        System.out.println("\nTest 6: Dealers Choice (user defined)");
        System.out.println("\t Range 1 to " + dealersChoice.getSides());
        dealersChoice.roll(dealersChoice.getSides());
        System.out.println("\t Single number Test: " + dealersChoice.getValue());
        System.out.print("\t Multiple number test: ");
        for (int i = 0; i < 10; i++) {
            {
                cube.roll(cube.getSides());
                System.out.print(" " + cube.getValue());
            }
        }


        System.out.println();
    }
}






