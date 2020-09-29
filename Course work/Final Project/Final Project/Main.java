/********************************************************************************
 *                            Final Project - Course Manager                    *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  04/26/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * Program which allows user to add, remove, and edit students information      *
 * which is held in an exterior file.                                           *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Main {

    public static void main(String[] args) {

        Course BS101 = new Course();

        BS101.ReadFromFile();
        BS101.DisplayMenu();
    }
}
