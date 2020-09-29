import java.util.Random;
import static java.lang.StrictMath.abs;
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
 * Defines the general states and behaviors of the Doggo which will             *
 * inherit from the Animal class                                                *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Dog extends Animal
{
    private String name, species;
    // region Attributes

    private int squirrelLocation, columnWidth;
    private static double runningSpeed, variationOfSpeed, currentPosition;
    private boolean squirrel = false;
    public String comment;
    double posiDiff;

    //endregion

    //region Constructor

    public Dog(String name_, double runningSpeed_, double variationOfSpeed_, int squirrelLocation_){

        //inherited
        super(name_, "Dog", runningSpeed_, variationOfSpeed_, 0);
//        this.name = name_;
//        this.species = "Dog";
//        this.runningSpeed = runningSpeed_;
//        this.variationOfSpeed = variationOfSpeed_;


        //unique
        this.squirrelLocation = squirrelLocation_;
        columnWidth = 25;
    }

    public Dog(){

    }

    //endregion

    //region Getters and Setters

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
    public void setPosiDiff() {
        this.posiDiff = abs(getSquirrelLocation() - this.getCurrentPosition());
    }

    public void SquirrelCheck(){
        setPosiDiff();
        if(posiDiff <= 20 && posiDiff > 1){
            squirrel = true;}
        else{
            squirrel = false;
        }
    }


    public double updatePosition()//<-- polymorphism overriding method from Animal
    {
        SquirrelCheck();
        Random r2 = new Random();


        if(squirrel == true)
        {
            double randomDouble = r2.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
            speed = getRunningSpeed() * randomDouble/2;
            setCurrentPosition(getCurrentPosition() + speed);

            double position = getCurrentPosition() + randomDouble/2;
            setCurrentPosition(getCurrentPosition() + position);
        }
        else
            {
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
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }

    public void eventBanner(int raceNum){
        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Squirrel location:" , this.getSquirrelLocation(), " feet");
        System.out.println();

    }

    public String GetComments(){

        if(squirrel == true) {
            comment = "squirrel";
        }
        else {
            comment = "";
        }

        return comment;
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
