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
    //attributes
    private int napStartTime =0, napDuration =0,  napEndTime =0, ct =0;
    private boolean napping = false;

    //constructor
    public Hare(String name_, String species_, double runningSpeed_, double variationOfSpeed_,
                double currentPosition_, int napStartTime_, int napDuration_){

        //inherited
        super(name_, species_, runningSpeed_, variationOfSpeed_, currentPosition_);

        //unique
        this.napStartTime = napStartTime_;
        this.napDuration = napDuration_;

    }

    public Hare(){

    }

    //Getters and Setters
    public int GetNapStartTime(){return this.napStartTime; }
    public int GetNapDuration(){return this.napDuration; }
    public void SetNapStartTime(int napStartTime_){
        this.napStartTime = napStartTime_;
    }
    public void SetNapDuration(int napDuration_){
        this.napDuration = napDuration_;
    }

    //Behaviors
    public double updatePosition()              //<-- polymorphism overriding method
    {
        Random r1 = new Random();
        napEndTime = (this.napStartTime + this.napDuration);
        ct = GetcurrentTime();

        if ((napStartTime<= ct) && (ct <= this.napEndTime)) {
            this.napping = true;
        }
        else
            this.napping = false;


        if(napping == false)
        {
            double randomDouble = r1.nextDouble() * (-(GetVariationOfSpeed() * 2)) + GetVariationOfSpeed();
            speed = getRunningSpeed() + randomDouble;
            SetCurrentPosition(GetcurrentPosition() + speed);
        }

        SetCurrentTime(GetcurrentTime() + 1);
        return GetcurrentPosition();

    }

    //printing methods
    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.GetVariationOfSpeed());
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Start nap:" , this.GetNapStartTime() , " seconds");
        System.out.printf("\n%-24s" + "%5d" + "%-8s",  "    Nap Duration:" , this.GetNapDuration() , " seconds");
        System.out.println();

    }  //<-- polymorphism overriding method
    public String GetComments(){
        String s = "";
        if(this.napping==true){
            s = "  napping  ";
        }
        return s;
    }           //<-- polymorphism overriding method
    public void raceResultsHeader(){
        System.out.printf("26%s", "         Thumper         |" );
        System.out.printf("26%s", "          (Hare)         |" );
        System.out.printf("26%s", " Position Speed Comments |" );
    }



    //for testing this class by itself
    public static void main(String[] args) {
        Hare t1= new Hare();

        System.out.println(t1.TestPrint());
        t1.SetName("Bob");
        t1.SetSpecies("meat popsicle");
        t1.SetRunningSpeed(6);
        t1.SetVariationOfSpeed(3);
        t1.SetCurrentPosition(0);
        System.out.println(t1.TestPrint());

        t1.SetNapStartTime(3);
        t1.SetNapDuration(5);

        //test for random speed change
        for (int i = 0; i < 20; i++) {

            t1.updatePosition();
            System.out.printf("\n%.1f ",(t1.speed) - t1.getRunningSpeed());
            System.out.println(t1.TestPrint());

        }

    }


}
