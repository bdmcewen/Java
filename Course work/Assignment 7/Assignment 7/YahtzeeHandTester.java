 /*******************************************************************************
*                            Assignment 4 - Yahtzee Hand                       *
*                                                                              *
* PROGRAMMER:       Ben McEwen                                                 *
* CLASS:            CS102                                                      *
* ASSIGNMENT:       Assignment assign-4                                        *
* INSTRUCTOR:       Dean Zeller                                                *
* SUBMISSION DATE:  2/22/2019                                                  *
*                                                                              *
* DESCRIPTION:                                                                 *
* This is a test program used to test methods defined in the                   *
* DieObject and YahtzeeHand class definition files                             *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
* original work, without use of outside sources.                               *
*******************************************************************************/
public class YahtzeeHandTester {

	public static void main(String[] args)
	{
		//declaring array object
		YahtzeeHand myHand = new YahtzeeHand(5,6);
		
		//alternative declaration
		/*
		YahtzeeHand myHand = new YahtzeeHand();
		myHand.numberOfSides = 6;
		myHand.numberOfDice = 5;
		*/
		
		//populating array
		for(int i=0; i<myHand.numberOfDice; i++) 
		{			
			DieObject die = new DieObject("cube", myHand.numberOfSides, 1);
			myHand.dice.add(die);
		}
		//tester for set die
		/*
		myHand.setDice(1,2,3,4,5);
		System.out.println("cheater/set test");
		System.out.println(myHand.toString());
		*/
		
		//tester for countDice()
		//System.out.println(myHand.countDice(4));
		/*
		myHand.rollDice();
		System.out.println("Roll 5 die test");
		System.out.println(myHand.toString());
		System.out.println(myHand.chanceValue());
		*/
		
		//complete testing for assignment-4
		myHand.rollDice();
		myHand.printManReportHeader(10);
		
		myHand.manualTestertests();
		myHand.rando1000(1000);

		
		
		
	}

}
