package bankapp;

public abstract class Account implements IBaseRate {
    //List common properties of both account types
    String name;
    String sSN;
    double balance;

    String accountnumber;
    double rate;

    // Constructor to set base properties  and initialize accounts
    public Account(String name){
        System.out.print("New Account Created: ");
        System.out.println("Customer Name: " + name);
    }

    // List common methods of both account types

}
