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

public class Hare extends Animal
{
    //region Attributes
    private String name, species;
    private int napStartTime, napDuration,  napEndTime, ct, napCounter;
    private static double runningSpeed, variationOfSpeed, currentPosition;
    private boolean napping;

    //endregion

    //region Constructors
    public Hare(String name_, double runningSpeed_, double variationOfSpeed_, int napStartTime_, int napDuration_){

        //inherited;
        super(name_, "Hare", runningSpeed_, variationOfSpeed_);
//        this.name = name_;
//        this.species = "Hare";
//        this.runningSpeed = runningSpeed_;
//        this.variationOfSpeed = variationOfSpeed_;

        //unique
        this.napStartTime = napStartTime_;
        this.napDuration = napDuration_;
        this.ct = 0;
        this.napCounter = 0;
        columnWidth = 25;

    }

    public Hare(){

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

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
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


    public double updatePosition()   //<-- polymorphism overriding method
    {
        Random r1 = new Random();
        napEndTime = (this.napStartTime + this.napDuration);
        ct = getCurrentTime();

        this.napping = (napStartTime <= ct) && (ct <= this.napEndTime);


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
        String status = "";
        if(this.napping==true){
            status = String.format("nap-%-3s", getNapCounter() - 1);
        }
        return status;
    }

    public String getColumnLabel(){
        columnLabel = "Position Speed Comment";
        return columnLabel;
    }

    public void raceResultsHeader(){
        System.out.printf("26%s", "         Thumper         |" );
        System.out.printf("26%s", "          (Hare)         |" );
        System.out.printf("26%s", " Position Speed Comments |" );
    }

    //endregion


//    //for testing this class by itself
//    public static void main(String[] args) {
//        Hare t1 = new Hare("Bob", 6,3, 20, 40);
//
//        t1.setNapStartTime(3);
//        t1.setNapDuration(5);
//
//        //test for random speed change
//        for (int i = 0; i < 20; i++) {
//
//            t1.updatePosition();
//            System.out.printf("\n%.1f ",(t1.speed) - t1.getRunningSpeed());
//            System.out.println(t1.TestPrint());
//
//        }
//
//    }


}
