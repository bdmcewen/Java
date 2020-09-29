import java.util.Random;
/********************************************************************************
 *                            Assignment 3 TvH                                  *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  11/1/2019                                                  *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * Defines the general states and behaviors of the Hare which will              *
 * inherit from the Animal class                                                *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Pig extends Animal
{
    //attributes
    private String name, species;
    private int eatStartTime, eatDuration,  eatEndTime, ct, eatCounter;
    private static double runningSpeed, variationOfSpeed, currentPosition;
    private boolean eating;

    //region Constructor
    public Pig(String name_, double runningSpeed_, double variationOfSpeed_, int eatStartTime_, int eatDuration_){

        //inherited
       super(name_, "Pig", runningSpeed_, variationOfSpeed_, 0);

        //unique
        this.eatStartTime = eatStartTime_;
        this.eatDuration = eatDuration_;

        this.ct = 0;
        this.eatCounter = 0;
        columnWidth = 25;

    }

    public Pig(){

    }

    //endRegion

    //region Getters and Setters

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

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }

    public int getEatCounter() {
        return eatCounter;
    }

    public void setEatCounter(int eatCounter) {
        this.eatCounter = eatCounter;
    }

    //endregion

    //Behaviors
    public double updatePosition()              //<-- polymorphism overriding method
    {
        Random r1 = new Random();
        eatEndTime = (this.eatStartTime + this.eatDuration);
        ct = getCurrentTime();

        this.eating = (eatStartTime <= ct) && (ct <= this.eatEndTime);


        if(!eating)
        {
            double randomDouble = r1.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            setCurrentPosition(getCurrentPosition() + speed);
        }
        else
        {
            speed = 0;
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

    }  //<-- polymorphism overriding method
    public String GetComments(){
        String status = "";
        if(this.eating){
            status = " eating ";
        }
        return status;
    }           //<-- polymorphism overriding method
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
