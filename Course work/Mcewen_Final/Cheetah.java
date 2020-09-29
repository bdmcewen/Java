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
 * This class is designed to simulate a cheetah which is a sub class of Animal  *
 * which uses the Predator interface                                            *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.Random;

public class Cheetah extends Animal implements Predator
{
    //region Attributes
    private int napStartTime, napDuration,  napEndTime, cl, napCounter;
    private boolean napping;
    private boolean fight;
    private boolean flight;


    //endregion

    //region Constructors
    public Cheetah(String name_, double runningSpeed_, double variationOfSpeed_, int napStartTime_, int napDuration_){

        //inherited;
        super(name_, "Cheetah", runningSpeed_, variationOfSpeed_);
//        this.name = name_;
//        this.species = "Cheetah";
//        this.runningSpeed = runningSpeed_;
//        this.variationOfSpeed = variationOfSpeed_;

        //unique
        this.napStartTime = napStartTime_;
        this.napDuration = napDuration_;
        this.cl = 0;
        this.napCounter = 0;
        columnWidth = 25;
        this.flight = true;
        this.fight = false;
        this.setFerocity(80);
        this.setStrength(.7);

    }


    public Cheetah(){

    }

    //endregion

    //region Getters & Setters

    public int getNapStartTime() {
        return napStartTime;
    }

    public void setNapStartTime(int napStartTime) {
        this.napStartTime = napStartTime;
    }

    public int getNapDuration() {
        return napDuration;
    }

    public void setNapDuration(int napDuration) {
        this.napDuration = napDuration;
    }

    public int getNapEndTime() {
        return napEndTime;
    }

    public void setNapEndTime(int napEndTime) {
        this.napEndTime = napEndTime;
    }

    public int getcL() {
        return cl;
    }

    public void setcL(int cL) {
        this.cl = cL;
    }

    public int getNapCounter() {
        return napCounter;
    }

    public void setNapCounter(int napCounter) {
        this.napCounter = napCounter;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean isNapping() {
        return napping;
    }

    public void setNapping(boolean napping) {
        this.napping = napping;
    }

    //endregion

    //region Behaviors
    public void napCheck(){
        int ct = getCurrentTime();
        if (this.getNapStartTime() <= ct && ct <= getNapEndTime()){
            this.setNapping(true);
        }
        if(this.getNapStartTime() >= ct || ct >= getNapEndTime()){
            this.setNapping(false);
        }
    }


    public double updatePosition()   //<-- polymorphism overriding method
    {
        napCheck();
        Random r1 = new Random();
        napEndTime = (this.napStartTime + this.napDuration);



        if(!napping)
        {
            double randomDouble = r1.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            setCurrentPosition(getCurrentPosition() + speed);
            napCounter = 0;
        }
        else
        {
            speed = 0;
            napCounter++;
        }

        setCurrentTime(getCurrentTime() + 1);
        return getCurrentPosition();

    }

    //endregion

    //region Display Methods

    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Start nap:" , this.getNapStartTime() , " seconds");
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Nap Duration:" , this.getNapDuration() , " seconds");
        System.out.println();

    }

    public String GetComments(){


        if (!isLifeStatus()){
            status = "out";
        }
        if(!isNapping()) {
            status = "";
        }
        if(!isCurrentlyFighting()) {
            status = "";
        }

        if(isLifeStatus()){
            status = "";
        }

        if(isNapping()) {
            status = "napping";
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
        System.out.printf("26%s", "         Chester         |" );
        System.out.printf("26%s", "          (Cheetah)         |" );
        System.out.printf("26%s", " Position Speed Comments |" );
    }

    @Override
    public void attacks() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                this.setNapping(false);
                this.setRunningSpeed(this.getRunningSpeed()*0);
            }
        }
    }

    //endregion


    //for testing this class by itself
    public static void main(String[] args) {
        Cheetah t1 = new Cheetah("Bob", 120,16, 500, 90);

        t1.setNapStartTime(3);
        t1.setNapDuration(5);

        //test for random speed change
        for (int i = 0; i < 20; i++) {

            t1.updatePosition();
            System.out.printf("\n%.1f ",(t1.speed) - t1.getRunningSpeed());
            System.out.println(t1.TestPrint());

        }

    }



}
