package bankapp;

public class Checking extends Account {

    //List properties unique to this account type
    int debitCardNumber;
    int debitCardPin;


    // Constructor to set properties  and initialize account
    public Checking(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        accountNumber = "2" + accountNumber;

//        //for testing
//        System.out.println("Checking account creation successful");
//        System.out.println(this.toString());
//        System.out.println();
    }

    // List methods unique to this account type

    @Override
    public void showInfo() {
        System.out.println("Account Type: Checking");
        super.showInfo();
    }
}
