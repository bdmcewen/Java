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

public class AnalysisEngineTester
{
    public static void main(String[] args)
    {
        AnalysisEngine study1 = new AnalysisEngine();

        study1.PrintGreeting();
        study1.SetTitle();
        study1.SetLeader();
        study1.SetDate();
        study1.SetInputName();
        study1.SetOutputName();
        study1.PrintIntro();
        study1.Phase1();
        study1.Phase2();
        study1.Phase3();
        study1.PrintFarewell();



    }
}











