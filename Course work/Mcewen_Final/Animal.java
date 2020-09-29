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
 * Defines the general states and behaviors of the animals which will           *
 * inherit from this class                                                      *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/
import java.util.Random;
import static java.lang.String.format;

public class Animal implements Predator, Prey{

    //region Attributes
    String status = "";
    private String name, species;
    private StringBuilder statBars;
    private double runningSpeed, variationOfSpeed, currentPosition, strength;
    public double speed;
    private int fightStartTime, fightDuration,  fightEndTime, cL, fightCounter, health, ferocity;
    private boolean currentlyFighting;
    private boolean fightingAllowed;
    public int currentTime, columnWidth;
    String columnLabel;
    private boolean fight, flight, lifeStatus, Predator, Prey;


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
        this.health =100;
        columnWidth = 16;
        this.setLifeStatus(true);
        this.setCurrentlyFighting(false);
    }

    public Animal(String name_, String species_, double runningSpeed_, double variationOfSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = variationOfSpeed_;
        this.currentPosition = 0;
        this.currentTime = 0;
        this.health =100;
        columnWidth = 16;
        this.setLifeStatus(true);
        this.setCurrentlyFighting(false);
    }

    public Animal(String name_, String species_, double runningSpeed_)
    {
        this.name = name_;
        this.species = species_;
        this.runningSpeed = runningSpeed_;
        this.variationOfSpeed = this.runningSpeed*.1;
        this.health =100;
        this.currentTime = 0;
        this.setLifeStatus(true);
    }

    Animal()
    {

    }

    //endregion

    //region Getters and Setters


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(Double strength) {
        this.strength = strength;
    }

    public boolean isPredator() {
        return Predator;
    }

    public void setPredator(boolean predator) {
        Predator = predator;
    }

    public boolean isPrey() {
        return Prey;
    }

    public void setPrey(boolean prey) {
        Prey = prey;
    }

    public int getFerocity() {
        return ferocity;
    }

    public void setFerocity(int ferocity) {
        this.ferocity = ferocity;
    }

    public boolean isLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(boolean lifeStatus) {
        this.lifeStatus = lifeStatus;
    }

    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight_) {
        this.fight = fight_;
    }

    public boolean isFlight() {
        return flight;
    }

    public void setFlight(boolean flight_) {
        this.flight = flight_;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isFightingAllowed() {
        return fightingAllowed;
    }

    public void setFightingAllowed(boolean fightingAllowed) {
        this.fightingAllowed = fightingAllowed;
    }

    public int getFightStartTime() {
        return fightStartTime;
    }

    public void setFightStartTime(int fightStartTime) {
        this.fightStartTime = fightStartTime;
    }

    public int getFightDuration() {
        return fightDuration;
    }

    public void setFightDuration(int fightDuration) {
        this.fightDuration = fightDuration;
    }

    public int getFightEndTime() {
        return fightEndTime;
    }

    public void setFightEndTime(int fightEndTime) {
        this.fightEndTime = fightEndTime;
    }

    public int getcL() {
        return cL;
    }

    public void setcL(int cL) {
        this.cL = cL;
    }

    public int getFightCounter() {
        return fightCounter;
    }

    public void setFightCounter(int fightCounter) {
        this.fightCounter = fightCounter;
    }

    public boolean isCurrentlyFighting() {
        return currentlyFighting;
    }

    public void setCurrentlyFighting(boolean currentlyFighting) {
        this.currentlyFighting = currentlyFighting;
    }

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

    public double getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(double runningSpeed_) {
        if(runningSpeed_ < 120){
            this.runningSpeed = runningSpeed_;
        }
        else{
            System.out.println("Running Speed must be less than 120");
        }
    }

    public double getVariationOfSpeed() {
        return variationOfSpeed;
    }

    public void setVariationOfSpeed(double variationOfSpeed_) {
        if(variationOfSpeed_ < 16){
            this.variationOfSpeed = variationOfSpeed_;
        }
        else{
            System.out.println("Running Speed must be less than 16");
        }

    }

    public double getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(double currentPosition) {
        this.currentPosition = currentPosition;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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

        double randomDouble = r1.nextDouble() * (-(getVariationOfSpeed() * 2)) + getVariationOfSpeed();
        speed = getRunningSpeed() + randomDouble;
        setCurrentPosition(getCurrentPosition() + speed);
        fightCounter = 0;

        currentTime++;

        return getCurrentPosition();
    }

    public String center(String text, int len){
        String out = format("%"+(len)+"s%s%"+(len)+"s", "",text,"");
        int mid = out.length()/2;
        int start = mid - len/2;
        int end = start + len;
        return (out.substring(start, end));
    }

    public String GetComments(){

        if(this.isCurrentlyFighting() && this.health > 0){
            this.setColumnWidth(24);
            status = "Fighting";
        }
        if(this.isCurrentlyFighting() && this.health <= 0){
            status = "\u2639" ;
        }
        return status;
    }

    public void attack(Animal enemy) {
        Random rnd = new Random();
        double damage = rnd.nextInt(21) + 1 * enemy.getStrength();
        enemy.dealDamage(damage);
        System.out.println(getUserName() + " dealt " + damage + " to " + enemy.getUserName());
        System.out.println(enemy.getUserName() + " has " + enemy.getHp() + " hit points left!");
    }

    public void dealDamage(Double damage) {
        health -= damage;
        health = Math.max(health, 0);
    }

    public boolean isDead() {
        return health <= 0;
    }

    public String getUserName() {
        return this.getName();
    }

    public int getHp() {
        return this.getHealth();
    }

    public void attacks() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                this.setRunningSpeed(this.getRunningSpeed()*0);
            }
        }
    }

    public void defends() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                if (this.isFlight() && !this.isFight()){
                    this.setRunningSpeed(this.getRunningSpeed()*-1.2);
                }
            }
        }
    }

    //endregion

    //region Print methods
    public void eventBanner(int raceNum){

        System.out.print("Contestant " + raceNum + ":    " + this.getName() + " the " + this.getSpecies());
        System.out.printf("\n%-24s" + "%5.1f", "    Running Speed:" , this.getRunningSpeed());
        System.out.printf("\n%-24s" + "%5.1f",  "    Variation of Speed:" , this.getVariationOfSpeed());
        System.out.println();
    }

    public String toString()
    {
        return format(" %10s %10s %6.1f %6.1f", getName(), getSpecies(), getRunningSpeed(), getVariationOfSpeed());
    }

    public String statBarMaker(double variableIN){

        this.statBars = new StringBuilder("|");
        this.statBars.append("|".repeat((int) Math.max(0, variableIN)));

        return statBars.toString();
    }

    public void getIntro()
    {
        System.out.printf("\tRunning speed:          %-15s\n", statBarMaker(getRunningSpeed()));
        System.out.printf("\tVariation of speed:     %-15s\n", statBarMaker(getVariationOfSpeed()));
        System.out.printf("\tFerocity:               %-15s\n", statBarMaker(getFerocity()));
        System.out.printf("\tStrength:               %-15s\n\n", statBarMaker(getStrength()));
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

    //endregion

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
