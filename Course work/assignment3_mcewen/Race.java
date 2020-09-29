import java.util.ArrayList;

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
 * Defines the methods to run the race and display results                      *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Race {

    //Attributes
    String event, winner ;
    private int length, raceNum;
    public static ArrayList <Animal>  contestants = new ArrayList<>();
    public boolean racing = true;

    //Constructors
    public Race(int length_, ArrayList contestants_ ){
        this.length = length_;
        contestants = contestants_;
    }

    public Race(ArrayList contestants_ ){

        contestants = contestants_;
    }

    // Getters and Setters
    public String getEvent() {
        return event;
    }

    public int getLength() {
        return length;
    }

    public ArrayList getContestants(){return contestants;}

    public void setEvent(String event) {
        this.event = event;
    }

    public void setContestants(ArrayList<Animal> contestants) {
        Race.contestants = contestants;
    }

    public void setLength(int length_){this.length = length_;}

    //Behaviors

    public void raceCheck(){

        for (Animal a: contestants)
        {
            if(a.GetcurrentPosition()> length+13)
            {
                this.racing = false;
                winner = a.getSpecies();
                break;
            }
        }
    }

    public void setup1(){


        Animal a1 = new Animal("Tommy","Tortoise", 2.0, .2  );
        contestants.add(a1);

        Hare h1 = new Hare("Harry", "Hare", 12.0, 2.0, 0.0, 5, 20);
        contestants.add(h1);

        System.out.println("\n\nEvent:  " + "The" + contestants.get(0).getSpecies()+ " v." + "The" + contestants.get(1).getSpecies());
        System.out.println("\nRace Distance   (feet): " + this.length);
        System.out.println();

        for (Animal a: contestants) {
            raceNum = contestants.indexOf(a);
            a.eventBanner(raceNum +1);
            System.out.println();
        }



        System.out.println("---------------------------------------------------");
        System.out.println(" Aaaaaaaand we're OFF!!!");
        System.out.print("+------+----------------+-------------------------+");

        //1st line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getName(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getName(), 25),
                "|" );

        //2nd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getSpecies(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getSpecies(), 25),
                "|" );

        //3rd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s",
                "| Time",
                " |",
                contestants.get(0).center("Position Speed", 16),
                "|",
                contestants.get(1).center("Position Speed Comments", 25),
                "|" );
        runR1();
    }

    public void runR1(){

        while(racing == true){

            System.out.printf("\n%-1s" + "%5d" + "%s" + "%9.1f" + "%6.1f" + "%s" + "%9.1f" + "%5.1f" + "%11s" + "%s",
                    "|",
                    contestants.get(0).currentTime ,
                    " |",
                    contestants.get(0).GetcurrentPosition() ,
                    contestants.get(0).getSpeed() ,
                    " |",
                    contestants.get(1).GetcurrentPosition() ,
                    contestants.get(1).getSpeed() ,
                    contestants.get(1).GetComments(),
                    "|"
            );

            for (Animal a: contestants) {
                a.updatePosition();
            }
            this.raceCheck();
        }

        System.out.println();
        System.out.println("Race over in " + this.contestants.get(0).currentTime + " seconds");
        System.out.println(winner + " Wins!!!");

    }

    public void setup2(){
         contestants.clear();
        Animal a2 = new Animal("Speedy","Tortoise", 2.0, .5  );
        contestants.add(a2);

        Hare h2 = new Hare("Thumper", "Hare", 10.0, 1.5, 0.0, 60, 80);
        contestants.add(h2);

        Dog d2 = new Dog("Doug", "Dog", 6.5, .75, 0, 200);
        contestants.add(d2);

        System.out.println("\n\nEvent:  " + "The " + contestants.get(0).getSpecies()+ " v." + "The " + contestants.get(1).getSpecies()+ " v." + "The " + contestants.get(2).getSpecies());
        System.out.println("\nRace Distance   feet: " + this.length);
        System.out.println();

        for (Animal a: contestants) {
            raceNum = contestants.indexOf(a);
            a.eventBanner(raceNum +1);
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(" Aaaaaaaand we're OFF!!!");
        System.out.print("+------+----------------+-------------------------+-------------------------+");

        //1st line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s" + "%25s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getName(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getName(), 25),
                "|",
                contestants.get(2).center(contestants.get(2).getName(), 25),
                "|");

        //2nd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s"+ "%25s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getSpecies(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getSpecies(), 25),
                "|" ,
                contestants.get(2).center(contestants.get(2).getSpecies(), 25),
                "|");

        //3rd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s"+ "%25s" + "%s",
                "| Time",
                " |",
                contestants.get(0).center("Position Speed", 16),
                "|",
                contestants.get(1).center("Position Speed Comments", 25),
                "|",
                contestants.get(2).center("Position Speed Comments", 25),
                "|");
        runR2();
    }

    public void runR2(){

        while(racing == true){

            System.out.printf("\n%-1s" + "%5d" + "%s" + "%9.1f" + "%6.1f" + "%s" + "%9.1f" + "%5.1f" + "%11s" + "%s"+ "%9.1f" + "%5.1f" + "%11s" + "%s",
                    "|",
                    contestants.get(0).currentTime ,
                    " |",
                    contestants.get(0).GetcurrentPosition() ,
                    contestants.get(0).getSpeed() ,
                    " |",
                    contestants.get(1).GetcurrentPosition() ,
                    contestants.get(1).getSpeed() ,
                    contestants.get(1).GetComments(),
                    "|",
                    contestants.get(2).GetcurrentPosition() ,
                    contestants.get(2).getSpeed() ,
                    contestants.get(2).GetComments(),
                    "|"
            );

            for (Animal a: contestants) {
                a.updatePosition();
            }
            this.raceCheck();
        }

        System.out.println();
        System.out.println("Race over in " + this.contestants.get(0).currentTime + " seconds");
        System.out.println(winner + " Wins!!!");

    }

    public void setup3(){
        contestants.clear();
        Animal a3 = new Animal("Creepy","Tortoise", 2.1, 1  );
        contestants.add(a3);

        Hare h3 = new Hare("Buggs", "Hare", 11.0, 2, 0.0, 80, 250);
        contestants.add(h3);

        Dog d3 = new Dog("Pluto", "Dog", 9, .5, 0, 600);
        contestants.add(d3);

        Animal a31 = new Animal("Gary","Snail", 1.0, .25 );
        contestants.add(a31);

        System.out.println("\n\nEvent:  " + "The " + contestants.get(0).getSpecies()+ " v. " +
                                        "The " + contestants.get(1).getSpecies()+ " v. " +
                                        "The " + contestants.get(2).getSpecies()+ " v. " +
                                        "The " + contestants.get(3).getSpecies());
        System.out.println();

        System.out.println("Race Distance   (feet): " + this.length);
        System.out.println();


        for (Animal a: contestants) {
            raceNum = contestants.indexOf(a);
            a.eventBanner(raceNum +1);
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println(" Aaaaaaaand we're OFF!!!");
        System.out.print("+------+----------------+-------------------------+-------------------------+----------------+");

        //1st line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s" + "%25s" + "%s" + "%16s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getName(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getName(), 25),
                "|",
                contestants.get(2).center(contestants.get(2).getName(), 25),
                "|",
                contestants.get(3).center(contestants.get(3).getName(), 16),
                "|");

        //2nd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s"+ "%25s" + "%s" + "%16s" + "%s",
                "|",
                " |",
                contestants.get(0).center(contestants.get(0).getSpecies(), 16),
                "|",
                contestants.get(1).center(contestants.get(1).getSpecies(), 25),
                "|" ,
                contestants.get(2).center(contestants.get(2).getSpecies(), 25),
                "|",
                contestants.get(3).center(contestants.get(3).getSpecies(), 16),
                "|");

        //3rd line of header
        System.out.printf("\n%-6s" + "%s" + "%16s" + "%s" + "%25s" + "%s"+ "%25s" + "%s" + "%16s" + "%s",
                "| Time",
                " |",
                contestants.get(0).center("Position Speed", 16),
                "|",
                contestants.get(1).center("Position Speed Comments", 25),
                "|",
                contestants.get(2).center("Position Speed Comments", 25),
                "|",
                contestants.get(3).center("Position Speed", 16),
                "|");
        runR3();
    }

    public void runR3(){

        while(racing == true){

            System.out.printf("\n%-1s" + "%5d" +                   //Timer column
                            "%s" + "%9.1f" + "%6.1f" +             //contestant 1 column
                            "%s" + "%9.1f" + "%5.1f" + "%11s" +    //contestant 2 column
                            "%s" + "%9.1f" + "%5.1f" + "%11s" +    //contestant 3 column
                            "%s" + "%9.1f" + "%6.1f" + "%s",       //contestant 4 column
                    "|",
                    contestants.get(0).currentTime ,
                    " |",
                    contestants.get(0).GetcurrentPosition() ,
                    contestants.get(0).getSpeed() ,
                    " |",
                    contestants.get(1).GetcurrentPosition() ,
                    contestants.get(1).getSpeed() ,
                    contestants.get(1).GetComments() ,
                    "|",
                    contestants.get(2).GetcurrentPosition() ,
                    contestants.get(2).getSpeed() ,
                    contestants.get(2).GetComments() ,
                    "|",
                    contestants.get(3).GetcurrentPosition() ,
                    contestants.get(3).getSpeed() ,
                    " |"
            );

            for (Animal a: contestants) {
                a.updatePosition();
            }
            this.raceCheck();
        }
        System.out.println();
        System.out.println("Race over in " + contestants.get(0).currentTime + " seconds");
        System.out.println(winner + " Wins!!!");

    }



    public static void main(String[] args) {
        Race r1 = new Race(100,  contestants);
        Race r2 = new Race(500,  contestants);
        Race r3 = new Race(1000,  contestants);

        r1.setup1();
        r2.setup2();
        r3.setup3();

     }
}
