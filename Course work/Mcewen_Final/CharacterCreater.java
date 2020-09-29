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
 * This class is used for creating new objects per user input and adds them     *
 * to the arraylist within the race objecty                                     *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.io.IOException;
import java.util.*;

public class CharacterCreater {

    public static void userDefinedCharacter(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Characters name => ");
        String name= sc.nextLine();

        System.out.print("Enter Characters species => ");
        String species= sc.nextLine();

        System.out.print("Enter Characters speed => ");
        String tempSpeed = sc.nextLine();
        Double runningSpeed= Double.parseDouble(tempSpeed);

        System.out.print("Enter Characters speed variation => ");
        String tempVar = sc.nextLine();
        Double variationOfSpeed = Double.parseDouble(tempVar);


        if (species.toUpperCase() =="TORTOISE" ){

            Animal a1 = new Animal(name,"Tortoise", runningSpeed,variationOfSpeed,0);
            contestants1.add(a1);
        }

        if (species.toUpperCase() =="HARE" ){

            System.out.println("Enter Hare's nap time = >");
            String tempNapStartTime = sc.nextLine();
            int napStartTime = Integer.parseInt(tempNapStartTime);

            System.out.println("Enter Hare's nap duration = >");
            String tempNapDuration = sc.nextLine();
            int napDuration = Integer.parseInt(tempNapDuration);

            Hare h1 = new Hare(name, runningSpeed, variationOfSpeed, napStartTime,napDuration);
            contestants1.add(h1);
        }

        if (species.toUpperCase() =="DOG" ){

            System.out.println("Enter time for squirrel to enter = >");
            String tempSquirrelTime = sc.nextLine();
            int squirrelTime = Integer.parseInt(tempSquirrelTime);

            System.out.println("Enter time for dog to chase squirrel = >");
            String tempSquirrelDuration = sc.nextLine();
            int squirrelDuration = Integer.parseInt(tempSquirrelTime);

            Dog d1 = new Dog(name,"Dog", runningSpeed, variationOfSpeed,squirrelTime, squirrelDuration);
            contestants1.add(d1);
        }

        if (species.toUpperCase() =="HORSE" ){

            System.out.println("Enter time for horse to get spooked = >");
            String tempSpookTime = sc.nextLine();
            int spookedLocation = Integer.parseInt(tempSpookTime);

            System.out.println("Enter time for horse to get spooked = >");
            String tempSpookduration = sc.nextLine();
            int spookedDuration = Integer.parseInt(tempSpookTime);

            Horse hr1 = new Horse(name, runningSpeed, variationOfSpeed,spookedLocation, spookedDuration);
            contestants1.add(hr1);
        }

        if (species.toUpperCase() =="PIG" ){

            System.out.println("Enter Pig's meal time = >");
            String tempMealStartTime = sc.nextLine();
            int mealStartTime = Integer.parseInt(tempMealStartTime);

            System.out.println("Enter Pig's meal duration = >");
            String tempMealDuration = sc.nextLine();
            int mealDuration = Integer.parseInt(tempMealDuration);

            Pig p1 = new Pig(name, runningSpeed, variationOfSpeed, mealStartTime,mealDuration);
            contestants1.add(p1);
        }

        Menus.returnToSetupMenu(race1, contestants1);

    }

    public static void preBuiltCharacter(Race race1, Animal animal1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of your Character =>");
        animal1.setName(sc.nextLine());

        Menus.returnToSetupMenu(race1, contestants1);
    }

    public static void generateRandomCharacter(Race race1,ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        Random rando = new Random();
        List<String> speciesList = new ArrayList<>();
        speciesList.add("Tortoise");
        speciesList.add("Hare");
        speciesList.add("Dog");
        speciesList.add("Horse");
        speciesList.add("Pig");

        List<Double> speedList = new ArrayList<>();
        for (double i = 1; i < 120 ; i++) {
            speedList.add(i);
        }

        List<Double> varList = new ArrayList<>();
        for (double i = 0; i < 16 ; i++) {
            varList.add(i);
        }

        List<Double> lengthList = new ArrayList<>();
        for (double i = 0; i < race1.getLength() ; i++) {
            lengthList.add(i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Characters name => ");
        String name= sc.nextLine();

        String species = speciesList.get(rando.nextInt(speciesList.size()));
        Double runningSpeed = speedList.get(rando.nextInt(speedList.size()));
        Double variationOfSpeed = varList.get(rando.nextInt(varList.size()));
        double eventOccurs = lengthList.get(rando.nextInt(lengthList.size()));


        if (species.toUpperCase().equals("TORTOISE")){
            Animal a1 = new Animal(name,"Tortoise", runningSpeed,variationOfSpeed,0);
            contestants1.add(a1);
        }

        if (species.toUpperCase().equals("HARE")){
            Hare h1 = new Hare(name, runningSpeed, variationOfSpeed, (int) eventOccurs,80);
            contestants1.add(h1);
        }

        if (species.toUpperCase().equals("DOG")){
            Dog d1 = new Dog(name,"Dog", runningSpeed, variationOfSpeed,(int) eventOccurs, 20);
            contestants1.add(d1);
        }

        if (species.toUpperCase().equals("HORSE")){
            Horse hr1 = new Horse(name, runningSpeed, variationOfSpeed,(int) eventOccurs, 80);
            contestants1.add(hr1);
        }

        if (species.toUpperCase().equals("PIG")){
            Pig p1 = new Pig(name, runningSpeed, variationOfSpeed, (int) eventOccurs,90);
            contestants1.add(p1);
        }


        System.out.println("New Character Created");


        Menus.returnToSetupMenu(race1, contestants1);
    }

}
