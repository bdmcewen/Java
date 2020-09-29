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
 * This class defines the menus used to allow customers to customize the races  *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus {

    public static void setupMenu(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println();
        System.out.println("Character Menu");
        System.out.println("Pick the characters you would like to see race");
        System.out.println("----------------------------------------------");

        final Scanner input = new Scanner(System.in);
        System.out.println("1: Load Pre-built race");
        System.out.println("2: Choose Length of Race");
        System.out.println("3: Create a Custom Character");
        System.out.println("4: Choose a Pre-built Character");
        System.out.println("5: Generate a Random Character");
        System.out.println("6: I'm finished filling race card");
        System.out.println("7: Exit program");

        System.out.println();
        System.out.print("Please enter your selection => ");
        final String choice = input.nextLine();

        switch (choice) {
            case "1" -> buildRace(race1, contestants1);
            case "2" -> setRaceLength(race1, contestants1);
            case "3" -> CharacterCreater.userDefinedCharacter(race1, contestants1);
            case "4" -> preBuiltMenu(race1, contestants1);
            case "5" -> CharacterCreater.generateRandomCharacter(race1, contestants1);
            case "6" -> {
                if (contestants1.size() < 1){
                    System.out.println("You must have at least 1 contestant, DUH!!");
                    returnToSetupMenu(race1, contestants1);
                }
                else{
                    raceCardMenu(race1, contestants1);
                }
            }
            case "7" -> System.exit(0);
            default -> {
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                setupMenu(race1,contestants1);
            }
        }
    }

    private static void buildRace(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        Animal animal1 = new Animal("Mark","Tortoise", .28, .03  );
        contestants1.add(animal1);

        Hare hare1 = new Hare("Mathew", 21.48,2.2,60,210 );
        contestants1.add(hare1);

        Cheetah cheetah1 = new Cheetah("John", 120,16,100,350 );
        contestants1.add(cheetah1);

        Dog dog1 = new Dog("Luke","Dog", 20, 2.1, 55, 200);
        contestants1.add(dog1);

//        Pug pug1 = new Pug("Peter","Pug",4.4,.44);
//        contestants1.add(pug1);
//
//        Caucasian caucasian1 = new Caucasian("James", "Caucasian", 14, 1.6);
//        contestants1.add(caucasian1);

        Horse horse1 = new Horse("Zebedee", 19.65, 2.0,60, 200);
        contestants1.add(horse1);

        Pig pig1 = new Pig("Lily", 13.5, 1.4, 55, 130 );
        contestants1.add(pig1);

        returnToSetupMenu(race1, contestants1);

//        race1.setLength(1000);
//        Race.fightMe(contestants1,1);
//        race1.runRace();
    }

    public static void preBuiltMenu (Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println();
        System.out.println("Choose Your Character");
        System.out.println("------------------");

        final Scanner input = new Scanner(System.in);
        System.out.println("1: Tortoise");
        System.out.println("2: Hare");
        System.out.println("3: Cheetah");
        System.out.println("4: Dog");
        System.out.println("5: Horse");
        System.out.println("6: Pig");
        System.out.println("7: Exit program");

        System.out.println();
        System.out.print("Please enter your selection => ");
        final String choice = input.nextLine();

        switch (choice) {

            case "1" -> {Animal animal1 = new Animal("john&&||Jane Doe","Tortoise", .28, .03  );
                CharacterCreater.preBuiltCharacter(race1, animal1, contestants1);}

            case "2" -> {Hare hare1 = new Hare("john&&||Jane Doe", 21.48,2.2,80,25 );
                contestants1.add(hare1);
                CharacterCreater.preBuiltCharacter(race1, hare1, contestants1);}

            case "3" -> {Cheetah cheetah1 = new Cheetah("john&&||Jane Doe", 120,16,60,45 );
                contestants1.add(cheetah1);
                CharacterCreater.preBuiltCharacter(race1, cheetah1, contestants1);}

            case "4" -> {Dog dog1 = new Dog("john&&||Jane Doe","Dog", 20, 2.1, 75, 20);
                contestants1.add(dog1);
                CharacterCreater.preBuiltCharacter(race1, dog1, contestants1);}

            case "5" -> {Horse horse1 = new Horse("john&&||Jane Doe", 19.65, 2.0, 80, 60);
                contestants1.add(horse1);
                CharacterCreater.preBuiltCharacter(race1, horse1, contestants1);}

            case "6" -> {Pig pig1 = new Pig("john&&||Jane Doe", 13.5, 1.4, 55, 100 );
                contestants1.add(pig1);
                CharacterCreater.preBuiltCharacter(race1, pig1, contestants1);}

            case "7" -> System.exit(0);
            default -> {
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                setupMenu(race1, contestants1);
            }
        }

    }

    public static void raceCardMenu(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println();
        System.out.println("Race Card Menu");
        System.out.println("Customize your race card");
        System.out.println("----------------------------------------------");

        final Scanner input = new Scanner(System.in);
        System.out.println("1: Sort by name");
        System.out.println("2: Sort by Species");
        System.out.println("3: Sort by Speed");
        System.out.println("4: Allow Fighting");
        System.out.println("5: Return to Character Setup");
        System.out.println("6: Run race");
        System.out.println("7: Exit program");

        System.out.println();
        System.out.print("Please enter your selection => ");
        final String choice = input.nextLine();

        switch (choice) {
            case "1" -> SortCharacters.sortByName(race1, contestants1);
            case "2" -> SortCharacters.sortBySpecies(race1, contestants1);
            case "3" -> SortCharacters.sortBySpeed(race1, contestants1);
            case "4" -> SortCharacters.fightQuery(race1, contestants1);
            case "5" -> setupMenu(race1, contestants1);
            case "6" -> runRace(race1.getLength(), contestants1);
            case "7" -> System.exit(0);
            default -> {
                System.out.println("Command not recognized");
                System.out.println("Please Try Again");
                setupMenu(race1, contestants1);
            }
        }

    }

    private static void setRaceLength(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of race => ");
        String tempLength = sc.nextLine();
        int raceLength = Integer.parseInt(tempLength);
        race1.setLength(raceLength);

        returnToSetupMenu(race1, contestants1);
    }

    private static void runRace(int length_, ArrayList<Animal> contestants1_) {
        Race r1 = new Race(length_, contestants1_);
        r1.runRace();
    }

    public static void returnToSetupMenu(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println("\n\nPress any key to continue...");
        try {
            System.in.read();
            Menus.setupMenu(race1, contestants1);
        }
        catch (Exception e) { }
    }

    public static void returnToPrebuiltMenu(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println("\n\nPress any key to continue...");
        try {
            System.in.read();
            Menus.preBuiltMenu(race1, contestants1);
        }
        catch (Exception e) { }
    }

    public static void returnToRaceCardMenu(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        System.out.println("\n\nPress any key to continue...");
        try {
            System.in.read();
            Menus.raceCardMenu(race1, contestants1);
        }
        catch (Exception e) { }
    }

}
