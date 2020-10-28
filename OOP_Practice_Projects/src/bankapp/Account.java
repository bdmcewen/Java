package bankapp;

public abstract class Account implements IBaseRate {
    //List common properties of both account types
    String name;
    String sSN;
    double balance;

    String accountNumber;
    double rate;

    // Constructor to set base properties  and initialize accounts
    public Account(String name, String sSn, double initDeposit){

        this.name = name;
        this.sSN = sSn;
        balance = initDeposit;

        //for test
        System.out.print("New Account Created: ");
        System.out.println(this.toString());
    }

    // List common methods of both account types


    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", sSN='" + sSN + '\'' +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", rate=" + rate +
                '}';
    }
}
