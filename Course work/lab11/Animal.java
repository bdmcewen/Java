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
import java.util.Random;
import static java.lang.String.format;

public class Animal {

    //region Attributes

    private String name, species;
    private static double runningSpeed, variationOfSpeed, currentPosition;
    public double speed;
    private boolean comment = true;
    public int currentTime, columnWidth;
    String columnLabel;

    //endregion

    //region Constructors

    public Animal(String name_, String species_, double runningSpeed_, double variationOfSpeed_, double currentPosition_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = variationOfSpeed_;
        this.currentPosition = currentPosition_;
        this.currentTime = 0;
        columnWidth = 16;
    }

    public Animal(String name_, String species_, double runningSpeed_, double variationOfSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = variationOfSpeed_;
        this.currentPosition = 0;
        this.currentTime = 0;
        columnWidth = 16;
    }

    public Animal(String name_, String species_, double runningSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = this.runningSpeed*.1;
        this.currentTime = 0;
    }

    Animal()
    {

    }

    //endregion

    //region Getters and Setters


    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public static double getVariationOfSpeed() {
        return variationOfSpeed;
    }

    public void setVariationOfSpeed(double variationOfSpeed) {
        this.variationOfSpeed = variationOfSpeed;
    }

    public double getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(double currentPosition) {
        this.currentPosition = currentPosition;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    //endregion



    //region Behavioral Methods
    public double updatePosition()
    {
        Random r1 = new Random();

        double randomDouble = r1.nextDouble()*(-(getVariationOfSpeed()*2)) + getVariationOfSpeed();

        this.setSpeed(getRunningSpeed() + randomDouble);
        setCurrentPosition(getCurrentPosition() + speed);

        currentTime++;

        return getCurrentPosition();
    }

    public String center(String text, int len){
        String out = format("%"+(len)+"s%s%"+(len)+"s", "",text,"");
        float mid = out.length()/2;
        float start = mid - len/2;
        float end = start + len;
        String s =  (out.substring((int)start, (int)end));
        return s;
    }

    public String GetComments(){
        String s = "";
        if(this.comment){
            s = "";
        }
        return s;
    }

    //endregion

    //print methods
    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.println();
    }

    public String toString()
    {
        return format(" %8.1f %6.1f", getCurrentPosition(), getRunningSpeed());
    }
    public void getIntro()
    {
        System.out.printf("\tRunning speed: %10.1f%n", this.getRunningSpeed() );
        System.out.printf("\tVariation of speed: %5.1f", this.getVariationOfSpeed());
    }

    public String getColumnLabel(){
         return "Position Speed";
    }

    public String getRaceLine(){
        String s = "";
        if(this.getColumnWidth() == 25){
            s =  format("%9.1f" + "%6.1f" + "%9s" + "%s", this.getCurrentPosition(), this.getSpeed(), this.GetComments(), " |");
        }
        if(this.getColumnWidth() == 16){
            s= format("%9.1f" + "%6.1f" + "%s", this.getCurrentPosition(), this.getSpeed(), " |");
        }

        return s;
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
        a1.setName("Bob");
        a1.setSpecies("meat popsicle");
        a1.setRunningSpeed(6);
        a1.setVariationOfSpeed(3);
        a1.setCurrentPosition(1);
        System.out.println(a1.TestPrint());

        //test for random speed change
        for (int i = 0; i < 100; i++) {

            a1.updatePosition();
            System.out.printf("\n%.1f ",(a1.getSpeed()) - a1.getRunningSpeed());
            //System.out.println(a1.TestPrint());

        }

    }

}
