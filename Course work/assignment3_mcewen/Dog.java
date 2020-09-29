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
    //attributes
    private int squirrelLocation;
    private boolean squirrel = false;
    public String comment = "";
    double posiDiff;

    //constructor
    public Dog(String name_, String species_, double runningSpeed_, double variationOfSpeed_,
                double currentPosition_, int squirrelLocation_){
        super(name_, species_, runningSpeed_, variationOfSpeed_, currentPosition_);
        this.squirrelLocation = squirrelLocation_;
    }

    public Dog(){

    }

    //Getters and Setters
    public int GetSquirrelLocation(){return this.squirrelLocation; }
    public void SetSquirrelLocation(int SquirrelLocation_){
        this.squirrelLocation = SquirrelLocation_;
    }
    public void SetSquirrel (boolean squirrel_){this.squirrel = squirrel_;}

    //behaviors
    public void setPosiDiff() {
        this.posiDiff = abs(GetSquirrelLocation() - this.GetcurrentPosition());
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
            double randomDouble = r2.nextDouble() * (-(GetVariationOfSpeed() * 2)) + GetVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble/2;
            SetCurrentPosition(GetcurrentPosition() + speed);

            double position = GetcurrentPosition() * randomDouble/2;
            SetCurrentPosition(GetcurrentPosition() + position);
        }
        else
            {
            double randomDouble = r2.nextDouble() * (-(GetVariationOfSpeed() * 2)) + GetVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            SetCurrentPosition(GetcurrentPosition() + speed);
        }


        SetCurrentTime(GetcurrentTime() + 1);
        return GetcurrentPosition();
    }

    public void raceResultsHeader(){
        System.out.printf("\n%25s" + "%s", this.center(this.getName(), 25),"|" );
        System.out.printf("\n%25s" + "%s", this.center(this.getSpecies(), 25),"|" );
        System.out.printf("\n%25s" + "%s", this.center(" Position Speed Comments", 25), "|" );
    }

    public String center(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }


    // printing methods
    public void eventBanner(int raceNum){
        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.GetVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Squirrel location:" , this.GetSquirrelLocation(), " feet");
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
    public void raceResults(){
        System.out.printf("\n%9.1f" +  "%5.1f" + "%11s" + "%s", this.GetcurrentPosition() , this.getSpeed() ,this.GetComments(), "|");
    }


    //for testing this class by itself
    public static void main(String[] args) {
//        Dog t1= new Dog();
        Dog t2= new Dog("Doug", "Dog", 8, 1,0,200 );
//
//
//        System.out.println(t1.TestPrint());
//        t1.SetName("Doug");
//        t1.SetSpecies("(dog)");
//        t1.SetrunningSpeed(6);
//        t1.SetVariationOfSpeed(3);
//        t1.SetCurrentPosition(0);
//        //System.out.println(t1.TestPrint());

//        t2.SetName("Jim");
//        t2.SetSpecies("(dog)");
//        t2.SetrunningSpeed(7);
//        t2.SetVariationOfSpeed(2);
//        t2.SetCurrentPosition(0);
//        t2.SetSquirrelLocation(200);

        //test for random speed change
        t2.raceResultsHeader();

        for (int i = 0; i < 100; i++) {
            t2.raceResults();
            t2.updatePosition();



//            t1.updatePosition();
//            System.out.printf("\n%.1f ",t1.GetcurrentPosition());

//            System.out.printf("\n%.1f ",(t1.speed) - t1.GetRunningSpeed());
//            System.out.println(t1.TestPrint());



        }

    }

}
