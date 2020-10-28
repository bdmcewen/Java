package bankapp;

public class Savings extends Account {
    //List properties unique to this account type
    int safetyDepositBoxID;
    int safetyDepositBoxKey;

    // Constructor to set properties and initialize account
    public Savings(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        accountNumber = "1" + accountNumber;

        // call method to set safety deposit box
        setSafetyDepositBox();

//        //for testing
//        System.out.println("Savings account creation successful");
//        System.out.println(this.toString());
//        System.out.println();
    }

    // List methods unique to this account type

    private void setSafetyDepositBox(){
        safetyDepositBoxID =(int)(Math.random() * Math.pow(10,3));
        safetyDepositBoxKey =(int)(Math.random() * Math.pow(10,4));

    }
    @Override
    public void showInfo() {
        System.out.println("Account Type: Savings");
        super.showInfo();
        System.out.println("\tSafety Deposit Box ID: " + safetyDepositBoxID +
                "\n\tSafety Deposit Box KEY: " + safetyDepositBoxKey);
    }
}
