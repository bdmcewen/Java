/********************************************************************************
 *                            Final Project TvH++                               *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  12/07/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This class is designed to simulate a pig which is a sub class                *
 * of Animal which uses the Prey interface                                      *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.Random;

public class Pig extends Animal implements Prey
{
    //attributes
    private int eatStartTime, eatDuration,  eatEndTime, ct, eatCounter;
    private boolean eating;

    //region Constructor
    public Pig(String name_, double runningSpeed_, double variationOfSpeed_, int eatStartTime_, int eatDuration_){

        //inherited
       super(name_, "Pig", runningSpeed_, variationOfSpeed_, 0);

        //unique
        this.eatStartTime = eatStartTime_;
        this.eatDuration = eatDuration_;
        this.eatCounter = 0;
        columnWidth = 25;
        this.setFerocity(25);
        this.setStrength(.6);

    }

    public Pig(){

    }

    //endRegion

    //region Getters and Setters

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public int getEatStartTime() {
        return eatStartTime;
    }

    public void setEatStartTime(int eatStartTime) {
        this.eatStartTime = eatStartTime;
    }

    public int getEatDuration() {
        return eatDuration;
    }

    public void setEatDuration(int eatDuration) {
        this.eatDuration = eatDuration;
    }

    public int getEatEndTime() {
        return eatEndTime;
    }

    public void setEatEndTime(int eatEndTime) {
        this.eatEndTime = eatEndTime;
    }

    public int getcL() {
        return ct;
    }

    public void setcL(int cL) {
        this.ct = cL;
    }

    public int getEatCounter() {
        return eatCounter;
    }

    public void setEatCounter(int eatCounter) {
        this.eatCounter = eatCounter;
    }

    //endregion

    //Behaviors

    public void mealCheck(){

        int squirrelEndTime = (this.getEatStartTime() + this.getEatDuration());

        int ct = getCurrentTime();
        if (this.getEatStartTime() <= ct && ct <= getEatEndTime()){
            this.setEating(true);
        }

        if (this.getEatStartTime() >= ct || ct >= getEatEndTime()){
            this.setEating(false);
        }
    }
    public double updatePosition()
    {
        mealCheck();
        Random r1 = new Random();
        eatEndTime = (this.eatStartTime + this.eatDuration);

        if(!eating)
        {
            double randomDouble = r1.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            setCurrentPosition(getCurrentPosition() + speed);
        }
        if(eating)
        {
            speed = getRunningSpeed()*0;
        }

        setCurrentTime(getCurrentTime() + 1);
        return getCurrentPosition();

    }

    //printing methods
    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Start eating:" , this.getEatStartTime() , " seconds");
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Meal Duration:" , this.getEatDuration() , " seconds");
        System.out.println();

    }
    public String GetComments(){

        if (!isLifeStatus()){
            status = "out";
        }
        if(!isEating()) {
            status = "";
        }
        if(!isCurrentlyFighting()) {
            status = "";
        }

        if(isLifeStatus()){
            status = "";
        }

        if(isEating()) {
            status = "eating";
        }
        if(isCurrentlyFighting()){
            status = "fighting";
        }

        return status;
    }
    public String getColumnLabel(){
        columnLabel = "Position Speed Comment";
        return columnLabel;
    }
    public void raceResultsHeader(){
        System.out.printf("26%s", "         Porky         |" );
        System.out.printf("26%s", "          (Pig)         |" );
        System.out.printf("26%s", " Position Speed Comments |" );
    }



    //for testing this class by itself
    public static void main(String[] args) {
        Pig t1= new Pig();

        System.out.println(t1.TestPrint());
        t1.setName("Bob");
        t1.setSpecies("meat popsicle");
        t1.setRunningSpeed(6);
        t1.setVariationOfSpeed(3);
        t1.setCurrentPosition(0);
        System.out.println(t1.TestPrint());

        t1.setEatStartTime(3);
        t1.setEatDuration(5);

        //test for random speed change
        for (int i = 0; i < 20; i++) {

            t1.updatePosition();
            System.out.printf("\n%.1f ",(t1.speed) - t1.getRunningSpeed());
            System.out.println(t1.TestPrint());

        }

    }


}
