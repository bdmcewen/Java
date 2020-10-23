package studetndatabaseapp;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        // Ask the user how many new students will be added to the database
        Student s1 = new Student();

        //Testing
        s1.enroll();
        s1.payTuition();

        //Display
        System.out.println();
        System.out.println(s1.toString());


    }
}
