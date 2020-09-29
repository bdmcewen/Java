import java.util.Random;

/********************************************************************************
 *                            Assignment 3 TvH                                  *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  10/25/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * Defines the general states and behaviors of the animals which will           *
 * inherit from this class                                                      *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Animal {

    //Attributes
    private String name, species;
    private double runningSpeed, variationOfSpeed, currentPosition;
    public double speed;
    private boolean comment = true;
    public int currentTime =0; //<- refactor to match your attributes

    //Constructors
    Animal()
    {

    }

    public Animal(String name_, String species_, double runningSpeed_, double variationOfSpeed_, double currentPosition_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = variationOfSpeed_;
        this.currentPosition = currentPosition_;
        this.currentTime = 0;
    }

    Animal(String name_, String species_, double runningSpeed_, double variationOfSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = variationOfSpeed_;
        this.currentPosition = 0;
        this.currentTime = 0;
    }

    Animal(String name_, String species_, double runningSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = this.runningSpeed*.1;
        this.currentTime = 0;
    }

    //Getters and Setters
    String getName() { return name; }
    String getSpecies() { return species; }
    public double getRunningSpeed() {return this.runningSpeed;}
    public double GetVariationOfSpeed() { return this.variationOfSpeed; }
    public double GetcurrentPosition() { return this.currentPosition; }
    public int GetcurrentTime() { return currentTime; }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void SetName(String name_)
    {
        this.name = name_;

        //for testing
        //System.out.println(name);
    }
    public void SetSpecies(String species_)
    {
        this.species = species_;

        //for testing
        //System.out.println(species);
    }
    public void SetRunningSpeed(double runningSpeed_)
    {
        this.runningSpeed = runningSpeed_;

        //for testing
        //System.out.println(variationOfSpeed);
    }
    public void SetVariationOfSpeed(double variationOfSpeed_)
    {
        this.variationOfSpeed = variationOfSpeed_;

        //for testing
        //System.out.println(variationOfSpeed);
    }
    public void SetCurrentPosition(double currentPosition__)
    {
        this.currentPosition = currentPosition__;

        //for testing
        //System.out.println(currentPosition);
    }
    public void SetCurrentTime(int currentTime_)
    {
        this.currentTime = currentTime_;

        //for testing
        //System.out.println(currentTime);
    }



    //Behavioral Methods
    public double updatePosition()
    {
        Random r1 = new Random();

        double randomDouble = r1.nextDouble()*(-(GetVariationOfSpeed()*2)) +GetVariationOfSpeed();

        this.setSpeed(getRunningSpeed() + randomDouble);
        SetCurrentPosition(GetcurrentPosition() + speed);

        currentTime++;

        return GetcurrentPosition();
    }
    public String center(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }
    public String GetComments(){
        String s = "";
        if(this.comment){
            s = " comment ";
        }
        return s;
    }

    //print methods
    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.GetVariationOfSpeed());
        System.out.println();
    }
    public String TestPrint()
    {
        String s = "";
        s += (this.name + " " + this.species + " " + this.currentTime + " "
                + this.runningSpeed + " " + this.variationOfSpeed + " " + this.currentPosition);
        return s;
    }

    //tester
    public static void main(String[] args) {
        Animal a1 = new Animal("Jim", "human", 5, 1, 0);

        System.out.println(a1.TestPrint());
        a1.SetName("Bob");
        a1.SetSpecies("meat popsicle");
        a1.SetRunningSpeed(6);
        a1.SetVariationOfSpeed(3);
        a1.SetCurrentPosition(1);
        System.out.println(a1.TestPrint());

        //test for random speed change
        for (int i = 0; i < 100; i++) {

            a1.updatePosition();
            System.out.printf("\n%.1f ",(a1.getSpeed()) - a1.getRunningSpeed());
            //System.out.println(a1.TestPrint());

        }

    }

}
