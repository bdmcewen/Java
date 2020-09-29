/*******************************************************************************
*                            Assignment 4 - Yahtzee Hand                       *
*                                                                              *
* PROGRAMMER:       Ben McEwen                                                 *
* CLASS:            CS102                                                      *
* ASSIGNMENT:       Assignment assign-5                                        *
* INSTRUCTOR:       Dean Zeller                                                *
* SUBMISSION DATE:  3/08/2019                                                  *
*                                                                              *
* DESCRIPTION:                                                                 *
* This defines the class which is used a blueprint when creating a             * 
* YahtzeeHand object.                                                          *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
* original work, without use of outside sources.                               *
*******************************************************************************/
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class YahtzeeHand 
{
	//Attributes
	ArrayList<DieObject> dice = new ArrayList<DieObject>();
	int numberOfDice;
	int numberOfSides;
	
	
	//Constructors	
	
	public YahtzeeHand(int numberOfDice_, int numberOfSides_) 
	{
		this.numberOfDice = numberOfDice_;
		this.numberOfSides = numberOfSides_;
	}
	public YahtzeeHand(int numberOfDice_) 
	{
		this(numberOfDice_, 6);
		
	}	
	public YahtzeeHand() 
	{
		this(5,6);
	}	
	public YahtzeeHand(ArrayList<DieObject> dice_) 
	{
		dice = dice_;			
	}

	
	// Basic Methods
	public void rollDice() 
	{
		System.out.println();
		//System.out.println("Random/roll test");
		for(DieObject d: this.dice)
		{
			d.roll(numberOfSides);
			//System.out.print(d.getValue()+ " ");
		}

	}	
	public String toString() 
	{
		String s = "";
		for(DieObject d: this.dice) 
		{
			s += d.getValue() + " ";			
		}
		return s;
	}	
	public int countDice(int n) 
	{
		int count =0;
		for(DieObject d: this.dice) 
		{
			if(d.getValue() == n) 
			{
				count++;				
			}
		}
		return count;	
	}	
	public void setDice(int d1,int d2,int d3,int d4,int d5) 
	{
		this.dice.get(0).cheat(d1);
		this.dice.get(1).cheat(d2);
		this.dice.get(2).cheat(d3);
		this.dice.get(3).cheat(d4);
		this.dice.get(4).cheat(d5);
	}

	// Additional Methods
	
	//Returns the number of n’s in the Yahtzee Hand, multiplied by n.  This could alternately be 
	//done with six individual methods, named onesValue, twosValue, threesValue, foursValue, fivesValue, and sixesValue.  
	int faceValue(int n) 
	{
		/*
		int onesValue, twosValue, threesValue, foursValue, fivesValue, sixesValue;
		for (DieObject d: myHand)
		{		
			onesValue   = this.countDice(1)*1;
			twosValue   = this.countDice(2)*2;
			threesValue = this.countDice(3)*3;
			foursValue  = this.countDice(4)*4;
			fivesValue  = this.countDice(5)*5;
			sixesValue  = this.countDice(6)*6;
		}
		*/
		
		return (countDice(n)*n);
		
	}

	//If at least three of the myHand have the same value, return the sum of all myHand.  Otherwise, return 0.
	int threeKindValue() 
	{
		int sum =0;
		if(this.triplesCheck()==true || this.quadruplesCheck()==true || this.quintuplesCheck()) 
		{
			sum = this.chanceValue();
		}
		return sum;	
	}
	
	//If at least four of the myHand have the same value, return the sum of all myHand.  Otherwise, return 0.
	int fourKindValue()
	{ 
		int sum =0;
		if(this.quadruplesCheck()==true || this.quintuplesCheck()==true) 
		{
			sum = this.chanceValue();
		}
		return sum;	
	}
	
	//	If three of the myHand are equal, and the other two myHand are also equal, return 25.  Otherwise, return 0.
	//(Note – all five myHand equal qualifies for a full house, but it is typically put into the higher-scoring Yahtzee.)
	int fullHouseValue() 
	{
		int sum =0;
		if(this.doublesCheck()==true && this.triplesCheck()==true) 
		{
			sum = 25;
		}
		return sum;	
	}
	
	//Dice sorter
	  void sortDice()
	  {
		  
		  Collections.sort(dice, (d1, d2) -> Integer.valueOf(d1.getValue()).compareTo(d2.getValue())); 

	  }
	static String removeDupsSorted(String inputString)
	{
		int res_ind = 1, ip_ind = 1;

		// temp array to store Chars
		char arr[] = inputString.toCharArray();

		/* In place removal of duplicate characters*/
		while (ip_ind != arr.length)
		{
			if(arr[ip_ind] != arr[ip_ind-1])
			{
				arr[res_ind] = arr[ip_ind];
				res_ind++;
			}
			ip_ind++;

		}

		inputString = new String(arr);
		return inputString.substring(0,res_ind);
	}

	//If four of the five myHand are in a consecutive order, return 30.  Otherwise, return 0.  (1-2-3-4, 2-3-4-5, or 3-4-5-6)
	int smallStraightValue()
	{
		int sum = 0;

		/*
		if (this.triplesCheck()==true ||this.quadruplesCheck()==true || this.quintuplesCheck()==true)
		{
			return sum;
		}	
		else
		{
			sum=30;
		}
		return sum;
		*/


		sortDice();

		String sorted = "";

		for(DieObject d: dice )
		{
			sorted += d.getValue();
		}

		sorted = removeDupsSorted(sorted);

		if(sorted.contains("1234")||sorted.contains("2345")||sorted.contains("3456"))
		{
			return 30;
			//sum =  30;
		}
		else
		{
			return 0;
			//sum =  0;
		}    
		//return sum;
	}
	
	//If all five myHand are in a consecutive order, return 40.  Otherwise, return 0.  (1-2-3-4-5 or 2-3-4-5-6)
	int largeStraightValue() 
	{
		int sum;
		/*
		if (this.boolesCheck()==true)
		{
			sum = 0;
		}	
		else
		{
			sum=40;
		}
		return sum;
		*/
		
		sortDice();
		String sorted = "";
		for(DieObject d: this.dice) 
		{
			sorted += d.getValue();
		}
		if(sorted.contains("12345")||sorted.contains("23456"))
		{
			sum= 40;
		}
		else
		{
			sum= 0;
		}
		return sum;
	}
	
	//If all five myHand are the same, return 50.  Otherwise, return 0.
	int yahtzeeValue()
	{
		int sum =0;
		if(this.quintuplesCheck()==true) 
		{
			sum = 50;
		}
		return sum;
	}
	
	//Sum the myHand, and return the result.  There are no myHand requirements on Chance.
	int chanceValue() 
	{ 
		int sum = 0;
		for(DieObject d: dice) 
		{
			sum += d.getValue();
		}
		return sum;
	}
	
	// boolean checks for duplicate values
	boolean boolesCheck() 
	{
		boolean mainCheck = false;
		if (this.doublesCheck() == false && this.triplesCheck() == false &&this.quadruplesCheck() == false &&this.quintuplesCheck() == false) 
		{
			mainCheck = true;
		}
		return mainCheck;
		
	}
	boolean doublesCheck() 
	{		
		boolean check= false;
		
		for(int i = 1; i<=this.numberOfSides; i++) 
			{
				if (this.countDice(i) >=  2) 
				{
					check = true;
				}
			}
		return check;		
	}
	boolean triplesCheck() 
	{		
		boolean check= false;
		for(int i = 1;i<=this.numberOfSides; i++) 
		{
			if (this.countDice(i) == 3) 
			{
				check = true;
			}
		}
		return check;		
	}
	boolean quadruplesCheck() 
	{		
		boolean check= false;
		for(int i = 1;i<=this.numberOfSides; i++) 
		{
			if (this.countDice(i) ==  4) 
			{
				check = true;
			}
		}
		return check;		
	}
	boolean quintuplesCheck() 
	{		
		boolean check= false;
		for(int i = 1;i<=this.numberOfSides; i++) 
		{
			if (this.countDice(i) ==  5) 
			{
				check = true;
			}
		}
		return check;		
	}

	// Print report of all scoring methods
	void printManReportHeader(int n)
	{
		  System.out.println("Yahtzee Hand Report");
		  System.out.println("Creating "+n+" manual YahtzeeHand examples");
		  System.out.println("   Dice             1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch");
	}
	
	void printRandoReportHeader(int n)
	{
		  System.out.println("Yahtzee Hand Report");
		  System.out.println("Creating "+n+" random YahtzeeHand examples");
		  System.out.println("   Dice             1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch");
	}
	public void manualTestertests()
	  {
		  setDice(2,1,3,6,1);	
		  System.out.println(reportLine(1));
		  setDice(6,2,5,3,4);		
		  System.out.println(reportLine(2));
		  setDice(5,5,2,1,5);
		  System.out.println(reportLine(3));
		  setDice(2,2,4,2,4);
		  System.out.println(reportLine(4));
		  setDice(4,4,4,4,4);
		  System.out.println(reportLine(5));
		  setDice(2,3,4,5,4);
		  System.out.println(reportLine(6));
		  setDice(6,2,6,6,6);
		  System.out.println(reportLine(7));
		  setDice(1,1,1,1,4);
		  System.out.println(reportLine(8));
		  setDice(4,1,3,1,6);
		  System.out.println(reportLine(9));
		  setDice(3,5,2,6,1);
		  System.out.println(reportLine(10));
		  System.out.println();
		  
	  }
	  
	  public String reportLine(int line)
	  {
		  String header=(String.format("%4d",line)+"."+" "+ toString());
		  String output = String.format("%5s %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d", header, 
				  faceValue(1), 
				  faceValue(2), 
				  faceValue(3), 
				  faceValue(4), 
				  faceValue(5), 
				  faceValue(6), 
				  threeKindValue(),
				  fourKindValue(),
				  fullHouseValue(),
				  smallStraightValue(),
				  largeStraightValue(),
				  yahtzeeValue(),
				  chanceValue()
				  );  
		  
		  return output;
	  }
	  
	  void rando1000(int statsTests)
	  {
		  int sumOfOnes = 0;
		  int instanceOfOnes = 0;
		  
		  int sumOfTwos = 0;
		  int instanceOfTwos = 0;
		  
		  int sumOfThrees = 0;
		  int instanceOfThree = 0;
		  
		  int sumOfFours = 0;
		  int instanceOfFours = 0;
		  
		  int sumOfFives = 0;
		  int instanceOfFives = 0;
		  
		  int sumOfSixes = 0;
		  int instanceOfSixes = 0;
		  
		  int sumOf3OKs = 0;
		  int instanceOf3OKs= 0;
		  
		  int sumOf4OKs = 0;
		  int instanceOf4OKs = 0;
		  
		  int sumOfFullHouses = 0;
		  int instanceOfFullHouses = 0;
		  
		  int sumOfSmallStraits = 0;
		  int instanceOfSmallStraits = 0;
		  
		  int sumOfLargeStraits = 0;
		  int instanceOfLargeStraits = 0;
		  
		  int sumOfYahtzees = 0;
		  int instanceOfYahtzees = 0;
		  
		  int sumOfChances = 0;
		  int instanceOfChances = 0;
		  
		  int counter = 0;
		  
		  
		  
		  printRandoReportHeader(statsTests);
		  for(int i = 0; i < statsTests; i++)
		  {
			 rollDice();
			 
			 sumOfOnes += faceValue(1);
			 instanceOfOnes += instance(faceValue(1));
			 
			 sumOfTwos += faceValue(2);
			 instanceOfTwos += instance(faceValue(2));
			 
			 sumOfThrees += faceValue(3);
			 instanceOfThree += instance(faceValue(3));
			 
			 sumOfFours += faceValue(4);
			 instanceOfFours += instance(faceValue(4));
			 
			 sumOfFives += faceValue(5);
			 instanceOfFives += instance(faceValue(5));
			 
			 sumOfSixes += faceValue(6);
			 instanceOfSixes += instance(faceValue(6));
			 
			 sumOf3OKs += threeKindValue();
			 instanceOf3OKs += instance(threeKindValue());
			 
			 sumOf4OKs += fourKindValue();
			 instanceOf4OKs += instance(fourKindValue());
			 
			 sumOfFullHouses += fullHouseValue();
			 instanceOfFullHouses += instance(fullHouseValue());
			 
			 sumOfSmallStraits += smallStraightValue();
			 instanceOfSmallStraits += instance(smallStraightValue());
			 
			 sumOfLargeStraits += largeStraightValue();
			 instanceOfLargeStraits += instance(largeStraightValue());
			 
			 sumOfYahtzees += yahtzeeValue();
			 instanceOfYahtzees += instance(yahtzeeValue());
			 
			 sumOfChances += chanceValue(); 
			 instanceOfChances += instance(chanceValue());
			 counter ++;
			 
			 System.out.println(reportLine(i));		 
		 }
		  System.out.println();
		  System.out.println("                    1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch");
		  String header = "% non-zero      ";
		  String output = String.format("%5s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s ",
				  header, 
				  (((double)instanceOfOnes/statsTests)*100),"%", 
				  (((double)instanceOfTwos/statsTests)*100),"%", 
				  (((double)instanceOfThree/statsTests)*100),"%", 
				  (((double)instanceOfFours/statsTests)*100),"%", 
				  (((double)instanceOfFives/statsTests)*100),"%", 
				  (((double)instanceOfSixes/statsTests)*100),"%", 
				  (((double)instanceOf3OKs/statsTests)*100),"%",
				  (((double)instanceOf4OKs/statsTests)*100),"%",
				  (((double)instanceOfFullHouses/statsTests)*100),"%",
				  (((double)instanceOfSmallStraits/statsTests)*100),"%",
				  (((double)instanceOfLargeStraits/statsTests)*100),"%",
				  (((double)instanceOfYahtzees/statsTests)*100),"%",
				  (((double)instanceOfChances/statsTests)*100),"%"
				  ); 
		  System.out.println(output);
		  header = "Average Score   ";
		  String averages = String.format("%5s %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f",
				  header, 
				  (double)sumOfOnes/statsTests, 
				  (double)sumOfTwos/statsTests, 
				  (double)sumOfThrees/statsTests, 
				  (double)sumOfFours/statsTests, 
				  (double)sumOfFives/statsTests, 
				  (double)sumOfSixes/statsTests, 
				  (double)sumOf3OKs/statsTests,
				  (double)sumOf4OKs/statsTests,
				  (double)sumOfFullHouses/statsTests,
				  (double)sumOfSmallStraits/statsTests,
				  (double)sumOfLargeStraits/statsTests,
				  (double)sumOfYahtzees/statsTests,
				  (double)sumOfChances/statsTests
				  ); 
		  System.out.println(averages);
	  }
	  
	  public int instance(int num)
	  {
		  int count = 0;
		  if (num != 0)
		  {
			  count = 1;
		  }
		  else
		  {
			  count= 0;
		  }
		  return count;
	  }
}
