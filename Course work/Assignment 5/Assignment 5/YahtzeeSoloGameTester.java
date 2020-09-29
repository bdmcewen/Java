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
 * Tester                                                                       *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
public class YahtzeeSoloGameTester
{
    public static void main(String[] args)
    {
        YahtzeeSoloGame myGame = new YahtzeeSoloGame();

        for(int i=0; i< myGame.myScores.myHand.numberOfDice; i++)
        {
            DieObject die = new DieObject("cube", myGame.myScores.myHand.numberOfSides, 1);
            myGame.myScores.myHand.dice.add(die);
        }

        myGame.myScores.myHand.rollDice();

        while(myGame.myScores.turnsCounter < 14)
        {
            myGame.DisplayMenu();
        }

        System.out.println("Game Over!");
    }
}
