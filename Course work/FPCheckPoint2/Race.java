import java.util.ArrayList;

public class Race {
    // Class attributes
    private String event, winnerName, winningSpecies, timeColumn = "| %4s |";
    private StringBuilder dashes;
    private int length, winningTime, animalCount;
    public static ArrayList <Animal>  contestants;

    // Race constructors
    Race(int length_, ArrayList<Animal> contestants_ )
    {
        this.length = length_;
        contestants = contestants_;
        this.animalCount = 1;
    }
    public Race(ArrayList<Animal> contestants_ )
    {
        contestants = contestants_;
    }
    // set methods
    private void setEvent(String eventIn){this.event = eventIn;}

    // get methods
    private String getEvent(){return this.event;}
    private int getLength(){return this.length;}


    private void raceCard()
    {

        this.dashes = new StringBuilder("+------+");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        StringBuilder eventLabel = new StringBuilder(String.format("Event:  The %s ", contestants.get(0).getSpecies()));
        for(int i = 1; i < contestants.size(); i++)
        {
            eventLabel.append(String.format("v. the %s ", contestants.get(i).getSpecies()));
        }
        setEvent(eventLabel.toString());
        System.out.println(getEvent());
        System.out.println();
        System.out.println("Race distance (feet): " + getLength());
        System.out.println();
        for(Animal a: contestants)
        {
            System.out.println("Contestant " + animalCount + ": " + a.getName() + " the " + a.getSpecies());
            a.getIntro();
            System.out.println();
            this.animalCount++;
            this.dashes.append("-".repeat(Math.max(0, a.getColumnWidth()))).append("+");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Aaaaaaaand... we're OFF!!!");
        System.out.println(this.dashes);

        System.out.printf(this.timeColumn, " ");
        for(Animal a: contestants)
        {
            System.out.printf(a.center(a.getName(), a.getColumnWidth()) + "|");
        }
        System.out.println();

        System.out.printf(this.timeColumn, " ");
        for(Animal a: contestants)
        {
            System.out.printf(a.center(a.getSpecies(), a.getColumnWidth()) +  "|");
        }
        System.out.println();

        System.out.printf(this.timeColumn, "Time");
        for(Animal a: contestants)
        {
            System.out.printf(a.center(a.getColumnLabel(),a.getColumnWidth()) + "|");
        }
        System.out.println();
    }

    void runRace()
    {
        raceCard();

        double max = 0;
        do {
            System.out.printf(this.timeColumn, (contestants.get(0).getCurrentTime()));
            for(Animal a: contestants){
                if(a.getCurrentPosition()>=max){
                    max = a.getCurrentPosition();
                    this.winnerName = a.getName();
                    this.winningTime = a.getCurrentTime();
                    this.winningSpecies = a.getSpecies();
                }

                System.out.print(a.getRaceLine());
                a.updatePosition();
            }
            if(max>this.length)
            {
                break;
            }
            System.out.println();
        }
        while(max<this.length);
        System.out.println();
        System.out.println(this.dashes);
        // print race winner
        System.out.println("\nRace over in " + this.winningTime + " secs\n"
                + this.winnerName + " the " + this.winningSpecies+ " wins!!!");
    }
}