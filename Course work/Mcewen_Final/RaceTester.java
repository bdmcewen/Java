import java.io.IOException;
import java.util.ArrayList;

//TODO make prebuilt race


public class RaceTester {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList <Animal>  contestants= new ArrayList<>();

        Race race1 = new Race(100,  contestants);
        Menus.setupMenu(race1, contestants);


//        Animal a1 = new Animal("Tommy","Tortoise", 2.0, .2  );
//        contestants.add(a1);
//        Hare h1 = new Hare("Harry", 12,2,5,5 );
//        contestants.add(h1);
//        Pig p1 = new Pig("Browney", 4, 1,4,6);
//        contestants.add(p1);
//        Race r1 = new Race(1000,  contestants);
//        r1.runRace();
//
//        contestants.clear();
//        Animal a2 = new Animal("Speedy","Tortoise", 2.0, .5  );
//        contestants.add(a2);
//        Hare h2 = new Hare("Thumper", 10.0, 1.5, 60, 80);
//        contestants.add(h2);
//        Dog d2 = new Dog("Doug", 6.5, .75, 200);
//        contestants.add(d2);
//        Pig p2 = new Pig("Whitey", 3, .5, 55, 100 );
//        contestants.add(p2);
//        Race r2 = new Race(500,  contestants);
//        r2.runRace();
//
//        contestants.clear();
//        Animal a3 = new Animal("Creepy","Tortoise", 2.1, 1  );
//        contestants.add(a3);
//        Hare h3 = new Hare("Buggs", 11.0, 2, 80, 250);
//        contestants.add(h3);
//        Dog d3 = new Dog("Pluto", 9, .5, 600);
//        contestants.add(d3);
//        Animal a31 = new Animal("Gary","Snail", 1.0, .25 );
//        contestants.add(a31);
//        Pig p3 = new Pig("Blackey", 3, .5, 55, 100 );
//        contestants.add(p3);
//        Race r3 = new Race(1000,  contestants);
//        r3.runRace();

    }


}
