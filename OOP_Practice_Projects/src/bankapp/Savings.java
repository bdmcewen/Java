package bankapp;

public class Savings extends Account{
    //List properties unique to this account type
    int safetyDepositBoxID;
    int safetyDepositBoxKey;

    // Constructor to set properties and initialize account
    public Savings(String name){
        super(name);
        System.out.println("Savings account creation successful");

        System.out.println();
    }

    // List methods unique to this account type
}
