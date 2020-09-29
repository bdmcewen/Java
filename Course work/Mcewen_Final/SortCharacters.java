import java.io.IOException;
import java.util.*;

public class SortCharacters {

    public static void sortByName(Race race1, ArrayList<Animal> contestants1) throws IOException, InterruptedException {
        //using hashmaps
        HashMap hm = arrayListToHashmap(contestants1);
        TreeMap<String, Animal> sortedTM = new TreeMap<String, Animal>(hm);
        Set<Map.Entry<String, Animal>> mappings = sortedTM.entrySet();

        //for testing
        for (Map.Entry<String, Animal> mapping: mappings) {
            System.out.println(mapping.getKey() + " ==>" + mapping.getValue());
        }

        contestants1.clear();

        for (Map.Entry<String, Animal> mapping: mappings) {
            contestants1.add(mapping.getValue());
        }

        Menus.returnToRaceCardMenu(race1, contestants1);

    }

    public static void sortBySpecies(Race race1,ArrayList<Animal> contestants1) throws IOException, InterruptedException {


        contestants1.sort((o1, o2) -> o1.getSpecies().compareToIgnoreCase(o2.getSpecies()));
        //for testing
        for (Animal animal: contestants1) {
            System.out.println(animal);
        }

        Menus.returnToRaceCardMenu(race1, contestants1);
    }

    public static void sortBySpeed(Race race1,ArrayList<Animal> contestants1) throws IOException, InterruptedException {

        //using treemap

        int contestantCounter = 0;
        // Creating HashMap
        TreeMap<Double, Animal> tm = new TreeMap<>();

        // Adding object in HashMap
        while(contestantCounter < contestants1.size()){
            for (Animal contestant: contestants1) {
                tm.put(contestant.getRunningSpeed(), contestant);
                contestantCounter++;
            }
        }

        Set<Map.Entry<Double, Animal>> mappings = tm.entrySet();

        //for testing
        for (Map.Entry<Double, Animal> mapping: mappings) {
            System.out.println(mapping.getKey() + " ==>" + mapping.getValue());
        }

        contestants1.clear();

        for (Map.Entry<Double, Animal> mapping: mappings) {
            contestants1.add(mapping.getValue());
        }

        Menus.returnToRaceCardMenu(race1, contestants1);

    }

    public static void fightQuery(Race race1,ArrayList<Animal> contestants1) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Would you like to allow contestants to fight?(Y/N) =>");
        String tempResponse = sc.nextLine();
        char response = tempResponse.toUpperCase().charAt(0);

        if (response == 'Y'){
            Race.fightMe(contestants1,1);
        }
        if (response == 'N'){
            Race.fightMe(contestants1,0);
        }

        Menus.returnToRaceCardMenu(race1, contestants1);

    }

    public static HashMap arrayListToHashmap(ArrayList<Animal> contestants1){

        int contestantCounter = 0;
        // Creating HashMap
        HashMap<String, Animal> hm = new HashMap<>();

        // Adding object in HashMap
        while(contestantCounter < contestants1.size()){
            for (Animal contestant: contestants1) {
                hm.put(contestant.getName(), contestant);
                contestantCounter++;
            }
        }

        return hm;
    }

}
