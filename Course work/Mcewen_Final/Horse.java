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
 * This class is designed to simulate a Hare which is a sub class               *
 * of Animal which uses the Prey interface                                      *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.Random;

public class Horse extends Animal implements Prey
{

    // region Attributes

    private int spookedLocation, spookedDuration, columnWidth;
    private boolean spooked = false;
    public String comment;
    double posiDiff;

    //endregion

    //region Constructor

    public Horse(String name_, double runningSpeed_, double variationOfSpeed_, int spookedLocation_, int spookedDuration_){

        //inherited
        super(name_, "Horse", runningSpeed_, variationOfSpeed_, 0);

        //unique
        this.spookedLocation = spookedLocation_;
        this.spookedDuration = spookedDuration_;
        columnWidth = 25;
        this.setFerocity(9);
        this.setStrength(.9);
    }

    public Horse(){

    }

    //endregion

    //region Getters and Setters


    public int getSpookedDuration() {
        return spookedDuration;
    }

    public void setSpookedDuration(int spookedDuration) {
        this.spookedDuration = spookedDuration;
    }

    public int getSpookedLocation() {
        return spookedLocation;
    }

    public void setSpookedLocation(int spookedLocation) {
        this.spookedLocation = spookedLocation;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean isSpooked() {
        return spooked;
    }

    public void setSpooked(boolean spooked) {
        this.spooked = spooked;
    }

    //endregion

    //region Behaviors
    public void spookedCheck(){
        int spookedEndTime = (this.getSpookedLocation() + this.getSpookedDuration());
        int ct = getCurrentTime();
        if (this.getSpookedLocation() <= ct && ct <= spookedEndTime){
            this.setSpooked(true);
        }
        if(this.getSpookedLocation() >= ct || ct >= spookedEndTime){
            this.setSpooked(false);
        }
    }


    public double updatePosition()//<-- polymorphism overriding method from Animal
    {
        spookedCheck();
        Random r2 = new Random();

        if(spooked) {
            double randomDouble = r2.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = (getRunningSpeed() + randomDouble)*-1;
            setCurrentPosition(getCurrentPosition() + speed);
        }
        if(!spooked) {
            double randomDouble = r2.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            setCurrentPosition(getCurrentPosition() + speed);
        }

        setCurrentTime(getCurrentTime() + 1);
        return getCurrentPosition();
    }

    //endregion

    //region Display methods
    public void raceResultsHeader(){
        System.out.printf("\n%25s" + "%s", this.center(this.getName(), 25),"|" );
        System.out.printf("\n%25s" + "%s", this.center(this.getSpecies(), 25),"|" );
        System.out.printf("\n%25s" + "%s", this.center(" Position Speed Comments", 25), "|" );
    }

    public String getColumnLabel(){
        columnLabel = "Position Speed Comment";
        return columnLabel;
    }

    public String center(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        int mid = (out.length()/2);
        int start = mid - (len/2);
        int end = start + len;
        return out.substring(start, end);
    }

    public void eventBanner(int raceNum){
        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Gets Spooked at:" , this.getSpookedLocation(), " feet");
        System.out.println();

    }

    public String GetComments(){

        if (!isLifeStatus()){
            status = "out";
        }
        if(!spooked) {
            status = "";
        }
        if(!isCurrentlyFighting()) {
            status = "";
        }

        if(isLifeStatus()){
            status = "";
        }

        if(spooked) {
            status = "spooked";
        }
        if(isCurrentlyFighting()){
            status = "fighting";
        }

        return status;
    }

    public void raceResults(){
        System.out.printf("\n%9.1f" +  "%5.1f" + "%11s" + "%s", this.getCurrentPosition() , this.getSpeed() ,this.GetComments(), "|");
    }

    //endregion


    //for testing this class by itself
    public static void main(String[] args) {
        Horse h1 = new Horse();
        Horse h2= new Horse("Ed",40.0, 4.0, 40, 80 );


        System.out.println(h1.TestPrint());
        h1.setName("Doug");
        h1.setSpecies("Horse");
        h1.setRunningSpeed(6);
        h1.setVariationOfSpeed(3);
        h1.setCurrentPosition(0);
        //System.out.println(t1.TestPrint());


        //test for random speed change
        h2.raceResultsHeader();

        for (int i = 0; i < 100; i++) {
            h2.raceResults();
            h2.updatePosition();

        }

    }

    @Override
    public void defends() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                if (this.isFlight() && !this.isFight()){
                    this.setSpooked(false);
                    this.setRunningSpeed(this.getRunningSpeed()*-1.2);
                }
            }
        }
    }
}
