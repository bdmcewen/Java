import java.util.ArrayList;

public class RaceTester {
    public static void main(String[] args) {

        ArrayList <Animal>  c1= new ArrayList<>();
        ArrayList <Animal>  c2= new ArrayList<>();
        ArrayList <Animal>  c3= new ArrayList<>();

        Animal a1 = new Animal("Tommy","Tortoise", 2.0, .2  );
        c1.add(a1);
        Hare h1 = new Hare("Harry", 12,2,5,5 );
        c1.add(h1);
        Pig p1 = new Pig("Browney", 4, 1,4,6);
        c1.add(p1);
        Race r1 = new Race(100,  c1);
        r1.runRace();

        c2.clear();
        Animal a2 = new Animal("Speedy","Tortoise", 2.0, .5  );
        c2.add(a2);
        Hare h2 = new Hare("Thumper", 10.0, 1.5, 60, 80);
        c2.add(h2);
        Dog d2 = new Dog("Doug", 6.5, .75, 200);
        c2.add(d2);
        Pig p2 = new Pig("Whitey", 3, .5, 55, 100 );
        c2.add(p2);
        Race r2 = new Race(500,  c2);
        r2.runRace();

        c3.clear();
        Animal a3 = new Animal("Creepy","Tortoise", 2.1, 1  );
        c3.add(a3);
        Hare h3 = new Hare("Buggs", 11.0, 2, 80, 250);
        c3.add(h3);
        Dog d3 = new Dog("Pluto", 9, .5, 600);
        c3.add(d3);
        Animal a31 = new Animal("Gary","Snail", 1.0, .25 );
        c3.add(a31);
        Pig p3 = new Pig("Blackey", 3, .5, 55, 100 );
        c3.add(p3);
        Race r3 = new Race(1000,  c3);
        r3.runRace();

    }
}
