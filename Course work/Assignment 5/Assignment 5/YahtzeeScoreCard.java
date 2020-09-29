/*******************************************************************************
 *                            Assignment 5 - Yahtzee Hand                       *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS102                                                      *
 * ASSIGNMENT:       Assignment assign-5                                        *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  3/08/2019                                                  *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This defines the class which is used a blueprint when creating a             *
 * Yahtzee Score Card object.                                                   *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen and Dean Zeller. This is       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/
import java.util.ArrayList;

public class YahtzeeScoreCard
{
    ArrayList<Integer> scores = new ArrayList<>();
    YahtzeeHand myHand = new YahtzeeHand();
    Boolean d1=false,d2=false,d3=false,d4=false,d5=false;
    int rerollcount = 0;
    int turnsCounter = 1;


    //attributes
    int onesScore,
            twosScore,
            threesScore,
            foursScore,
            fivesScore,
            sixesScore,
            bonusScore,
            threeKindScore,
            fourKindScore,
            fullHouseScore,
            smallStraightScore,
            largeStraightScore,
            yahtzeeScore,
            chanceScore,
            totalScore;


    //constructors
    public YahtzeeScoreCard()
    {

        this.onesScore = -1;

        this.twosScore = -1;

        this.threesScore = -1;

        this.foursScore = -1;

        this.fivesScore = -1;

        this.sixesScore = -1;

        this.bonusScore = -1;

        this.threeKindScore = -1;

        this.fourKindScore = -1;

        this.fullHouseScore = -1;

        this.smallStraightScore = -1;

        this.largeStraightScore = -1;

        this.yahtzeeScore = -1;

        this.chanceScore = -1;

        this.totalScore = -1;
        System.out.println("Score card initialized.");

    }

    //Set Methods
    //populates Scores array
    public void setScoresArray()
    {
        //myHand.rollDice();
        /*
        setOnesScore();
        setTwosScore();
        setThreesScore();
        setFoursScore();
        setFivesScore();
        setSixesScore();
        setBonusScore();
        setThreeKindScore();
        setFourKindScore();
        setFullHouseScore();
        setSmallStraightScore();
        setLargeStraightScore();
        setYahtzeeScore();
        setChanceScore();
        */

        scores.add(onesScore);

        scores.add(twosScore);

        scores.add(threesScore);

        scores.add(foursScore);

        scores.add(fivesScore);

        scores.add(sixesScore);

        scores.add(bonusScore);

        scores.add(threeKindScore);

        scores.add(fourKindScore);

        scores.add(fullHouseScore);

        scores.add(smallStraightScore);

        scores.add(largeStraightScore);

        scores.add(yahtzeeScore);

        scores.add(chanceScore);

    }

    void setOnesScore()
    {
        this.onesScore = myHand.faceValue(1);
    }

    void setTwosScore()
    {
        this.twosScore = myHand.faceValue(2);
    }

    void setThreesScore()
    {
        this.threesScore = myHand.faceValue(3);
    }

    void setFoursScore()
    {
        this.foursScore = myHand.faceValue(4);
    }

    void setFivesScore()
    {
        this.fivesScore = myHand.faceValue(5);
    }

    void setSixesScore()
    {
        this.sixesScore = myHand.faceValue(6);
    }

    void setBonusScore()
    {
        this.bonusScore = 0;

        if ((onesScore + twosScore + threesScore + foursScore + fivesScore + sixesScore) >= 63)
        {
            this.bonusScore = 35;
        }
    }

    void setThreeKindScore()
    {
        this.threeKindScore = myHand.threeKindValue();
    }

    void setFourKindScore()
    {
        this.fourKindScore = myHand.fourKindValue();
    }

    void setFullHouseScore()
    {
        this.fullHouseScore = myHand.fullHouseValue();
    }

    void setSmallStraightScore()
    {
        this.smallStraightScore = myHand.smallStraightValue();
    }

    void setLargeStraightScore()
    {
        this.largeStraightScore = myHand.largeStraightValue();
    }

    void setYahtzeeScore()
    {
        this.yahtzeeScore = myHand.yahtzeeValue();
    }

    void setChanceScore()
    {
        this.chanceScore = myHand.chanceValue();
    }

    void setTotalScore()
    {
        setScoresArray();
        totalScore = 0;
        for(Integer score :scores)
        {
            if(score >= 0)
            {
                totalScore += score;
            }
        }
    }

    //Get Methods
    public int getOnesScore()
    {
        return onesScore;
    }

    public int getTwosScore()
    {
        return twosScore;
    }

    public int getThreesScore()
    {
        return threesScore;
    }

    public int getFoursScore()
    {
        return foursScore;
    }

    public int getFivesScore()
    {
        return fivesScore;
    }

    public int getSixesScore()
    {
        return sixesScore;
    }

    public int getBonusScore()
    {
        return bonusScore;
    }

    public int getThreeKindScore()
    {
        return threeKindScore;
    }

    public int getFourKindScore()
    {
        return fourKindScore;
    }

    public int getFullHouseScore()
    {
        return fullHouseScore;
    }

    public int getSmallStraightScore()
    {
        return smallStraightScore;
    }

    public int getLargeStraightScore()
    {
        return largeStraightScore;
    }

    public int getYahtzeeScore()
    {
        return yahtzeeScore;
    }

    public int getChanceScore()
    {
        return chanceScore;
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    //obligatory methods
    // Roll the dice corresponding to the true Boolean parameters.

    //TODO: esplain reroll
    public void rerollDice(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5)
    {
        int counter =0;
        ArrayList<Boolean> bools = new ArrayList<>();
        bools.add(d1);
        bools.add(d2);
        bools.add(d3);
        bools.add(d4);
        bools.add(d5);
        ArrayList<DieObject> sublist1 = new ArrayList<>();
        ArrayList<DieObject> sublist2 = new ArrayList<>();

        for (Boolean b: bools)
        {
            if(b == true)
            {
                DieObject die = new DieObject();
                sublist1.add(die);
            }
        }

        for (Boolean b: bools)
        {

            //System.out.println("counter:" + counter);

            if(b == false)
            {
                DieObject die = new DieObject();
                die.setValue(myHand.dice.get(counter).getValue());
                sublist2.add(die);
            }
            counter++;
            //System.out.println("counter:" + counter);

        }
        myHand.dice.clear();

        System.out.println("New values from roll: ");
        for(DieObject d: sublist1)
        {
            d.roll(myHand.numberOfSides);
            myHand.dice.add(d);
            System.out.print(d.getValue()+ " ");
        }
        System.out.println();

        System.out.println("Die kept: ");
        for(DieObject d: sublist2)
        {
            myHand.dice.add(d);
            System.out.print(d.getValue()+ " ");
        }
        System.out.println();
        System.out.println("New Hand: " + myHand.toString());
        sublist1.clear();
        sublist2.clear();
        rerollcount++;
    }

    // Calculate the score, and store the result in the appropriate location in the score sheet.
    // Also recalculate the bonus and totalScore attributes.
    void scoreOnes()
    {
        onesScore = myHand.faceValue(1);
    }

    void scoreTwos()
    {
        twosScore = myHand.faceValue(2);
    }

    void scoreThrees()
    {
        threesScore = myHand.faceValue(3);
    }

    void scoreFours()
    {
        foursScore = myHand.faceValue(4);
    }

    void scoreFives()
    {
        fivesScore = myHand.faceValue(5);
    }

    void scoreSixes()
    {
        sixesScore = myHand.faceValue(6);
    }

    void scoresBonus()
    {
        setBonusScore();
        bonusScore = getBonusScore();
    }

    //Calculate the score, and store the result in the appropriate location in the score sheet.  Also recalculate the totalScore attribute.
    void scoreThreeKind()
    {
        threeKindScore = myHand.threeKindValue();
    }

    void scoreFourKind()
    {
        fourKindScore = myHand.fourKindValue();
    }

    void scoreFullHouse()
    {
        fullHouseScore = myHand.fullHouseValue();
    }

    void scoreSmallStraight()
    {
        smallStraightScore = myHand.smallStraightValue();
    }

    void scoreLargeStraight()
    {
        largeStraightScore = myHand.largeStraightValue();
    }

    void scoreYahtzee()
    {
        yahtzeeScore = myHand.yahtzeeValue();
    }

    void scoreChance()
    {
        chanceScore = myHand.chanceValue();
    }

    void scoresTotal()
    {
        totalScore = 0;
        setTotalScore();
        //totalScore = getTotalScore();
    }

    //Display all scores with labels in a neatly formatted table.
    void displayScoresheet()
    {

        System.out.println();
        System.out.println("Turn #" + turnsCounter + " of 13");
        System.out.println();
        System.out.println("Current Scoresheet:");
        if(onesScore > 0)
        {
            System.out.println(" 1. Ones:              " + onesScore);
        }
        if(onesScore <=0)
        {
            System.out.println(" 1. Ones:              ");
        }

        if(twosScore > 0)
        {
            System.out.println(" 2. Twos:              " + twosScore);
        }
        if(twosScore <=0)
        {
            System.out.println(" 2. Twos:              ");
        }

        if(threesScore >0)
        {
            System.out.println(" 3. Threes:            " + threesScore);
        }
        if(threesScore <=0)
        {
            System.out.println(" 3. Threes:            ");
        }

        if(foursScore >0)
        {
            System.out.println(" 4. Fours:             " + foursScore);
        }
        if(foursScore <=0)
        {
            System.out.println(" 4. Fours:             ");
        }

        if(fivesScore >0)
        {
            System.out.println(" 5. Fives:             " + fivesScore);
        }
        if(fivesScore <=0)
        {
            System.out.println(" 5. Fives:             ");
        }

        if(sixesScore >0)
        {
            System.out.println(" 6. Sixes:             " + sixesScore);
        }
        if(sixesScore <=0)
        {
            System.out.println(" 6. Sixes:             ");
        }


        if(bonusScore >0)
        {
            System.out.println("BONUS:	               " + bonusScore);
        }
        if(bonusScore <=0)
        {
            System.out.println("BONUS:	               " + "0");
        }

        if(threeKindScore >0)
        {
            System.out.println(" 7. 3-Kind:            " + threeKindScore);
        }
        if(threeKindScore <=0)
        {
            System.out.println(" 7. 3-Kind:            ");
        }

        if(fourKindScore >0)
        {
            System.out.println(" 8. 4-Kind:            " + fourKindScore);
        }
        if(fourKindScore <=0)
        {
            System.out.println(" 8. 4-Kind:            ");
        }

        if(fullHouseScore >0)
        {
            System.out.println(" 9. Full House:        " + fullHouseScore);
        }
        if(fullHouseScore <=0)
        {
            System.out.println(" 9. Full House:        ");
        }

        if(smallStraightScore >0)
        {
            System.out.println("10. Small Straight:    " + smallStraightScore);
        }
        if(smallStraightScore <=0)
        {
            System.out.println("10. Small Straight:    ");
        }

        if(largeStraightScore >0)
        {
            System.out.println("11. Large Straight:    " + largeStraightScore);
        }
        if(largeStraightScore <=0)
        {
            System.out.println("11. Large Straight:    ");
        }

        if(yahtzeeScore >0)
        {
            System.out.println("12. Yahtzee:           " + yahtzeeScore);
        }
        if(yahtzeeScore <=0)
        {
            System.out.println("12. Yahtzee:           ");
        }

        if(chanceScore >0)
        {
            System.out.println("13. Chance:            " + chanceScore);
        }
        if(chanceScore <=0)
        {
            System.out.println("13. Chance:            ");
        }

        if(totalScore >0)
        {
            System.out.println("TOTAL:	               " + totalScore);
        }
        if(totalScore <=0)
        {
            System.out.println("TOTAL:	               " + "0");
        }
        System.out.println();
        System.out.println("Current hand: "+ myHand.toString());



    }
}

