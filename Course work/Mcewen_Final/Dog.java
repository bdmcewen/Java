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
 * This class is designed to simulate a generic dog which is a sub class        *
 * of Animal which uses the Predator and Prey interface                         *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.Random;
import static java.lang.StrictMath.abs;

public class Dog extends Animal implements Predator,Prey
{

    // region Attributes

    private int squirrelLocation, squirrelDuration, columnWidth;
    private boolean squirrel = false;
    public String comment;
    double posiDiff;


    //endregion

    //region Constructor

    public Dog(String name_,String species, double runningSpeed_, double variationOfSpeed_, int squirrelLocation_, int squirrelDuration_){

        //inherited
        super(name_, "Dog", runningSpeed_, variationOfSpeed_, 0);

        //unique
        this.squirrelLocation = squirrelLocation_;
        this.squirrelDuration = squirrelDuration_;
        columnWidth = 25;
        this.setFerocity(50);
        this.setStrength(.5);

    }

    public Dog(){

    }

    //endregion

    //region Getters and Setters

    public int getSquirrelDuration() {
        return squirrelDuration;
    }

    public void setSquirrelDuration(int squirrelDuration) {
        this.squirrelDuration = squirrelDuration;
    }

    public int getSquirrelLocation() {
        return squirrelLocation;
    }

    public void setSquirrelLocation(int squirrelLocation) {
        this.squirrelLocation = squirrelLocation;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean isSquirrel() {
        return squirrel;
    }

    public void setSquirrel(boolean squirrel) {
        this.squirrel = squirrel;
    }

    //endregion

    //region Behaviors
    public void SquirrelCheck(){

        int squirrelEndTime = (this.getSquirrelLocation() + this.getSquirrelDuration());
        int ct = getCurrentTime();
        if (this.squirrelLocation <= ct && ct <= squirrelEndTime){
            this.setSquirrel(true);
        }
        if (this.squirrelLocation >= ct || ct >= squirrelEndTime){
            this.setSquirrel(false);
        }
    }

    public double updatePosition() {
        SquirrelCheck();
        Random r2 = new Random();

        if(squirrel) {
            double randomDouble = r2.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = (getRunningSpeed() + randomDouble)*-1;
            setCurrentPosition(getCurrentPosition() + speed);
        }
        if(!squirrel) {
            double randomDouble = r2.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            setCurrentPosition(getCurrentPosition() + speed);
        }

        setCurrentTime(getCurrentTime() + 1);
        return getCurrentPosition();
    }


    @Override
    public void attacks() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                this.setSquirrel(false);
                this.setRunningSpeed(this.getRunningSpeed()*0);
            }
        }
    }

    @Override
    public void defends() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                if (this.isFlight() && !this.isFight()){
                    this.setSquirrel(false);
                    this.setRunningSpeed(this.getRunningSpeed()*-1.2);
                }
            }
        }
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
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Squirrel location:" , this.getSquirrelLocation(), " feet");
        System.out.println();

    }

    @Override
    public String GetComments(){

        if (!isLifeStatus()){
            status = "out";
        }
        if(!squirrel) {
            status = "";
        }
        if(!isCurrentlyFighting()) {
            status = "";
        }

        if(isLifeStatus()){
            status = "";
        }

        if(squirrel) {
            status = "squirrel";
        }
        if(isCurrentlyFighting()){
            status = "fighting";
        }

        return status;
    }




//    public void raceResults(){
//        System.out.printf("\n%9.1f" +  "%5.1f" + "%11s" + "%s", this.getCurrentPosition() , this.getSpeed() ,this.GetComments(), "|");
//    }

    //endregion


    //for testing this class by itself
//    public static void main(String[] args) {
////        Dog t1= new Dog();
//        Dog t2= new Dog("Doug", 8, 1,200 );
////
////
////        System.out.println(t1.TestPrint());
////        t1.SetName("Doug");
////        t1.SetSpecies("(dog)");
////        t1.SetrunningSpeed(6);
////        t1.SetVariationOfSpeed(3);
////        t1.SetCurrentPosition(0);
////        //System.out.println(t1.TestPrint());
//
////        t2.SetName("Jim");
////        t2.SetSpecies("(dog)");
////        t2.SetrunningSpeed(7);
////        t2.SetVariationOfSpeed(2);
////        t2.SetCurrentPosition(0);
////        t2.SetSquirrelLocation(200);
//
//        //test for random speed change
//        t2.raceResultsHeader();
//
//        for (int i = 0; i < 100; i++) {
//            t2.raceResults();
//            t2.updatePosition();
//
//
//
////            t1.updatePosition();
////            System.out.printf("\n%.1f ",t1.GetcurrentPosition());
//
////            System.out.printf("\n%.1f ",(t1.speed) - t1.GetRunningSpeed());
////            System.out.println(t1.TestPrint());
//
//
//
//        }
//
//    }

}
