package bankapp;

public class Checking extends Account {

    //List properties unique to this account type
    int debitCardNumber;
    int debitCardPin;


    // Constructor to set properties  and initialize account
    public Checking(String name, String sSn, double initDeposit) {
        super(name, sSn, initDeposit);
        accountNumber = "2" + accountNumber;

        // call method to set debitcard
        setDebitCard();

//        //for testing
//        System.out.println("Checking account creation successful");
//        System.out.println(this.toString());
//        System.out.println();
    }


    // List methods unique to this account type
    private void setDebitCard() {
        debitCardNumber =(int)(Math.random() * Math.pow(10,12)) ;
        debitCardPin =(int)(Math.random() * Math.pow(10,4)) ;
    }

    @Override
    public void showInfo() {
        System.out.println("Account Type: Checking");
        super.showInfo();
        System.out.println("\tDebit Card Number: " + this.debitCardNumber +
                "\n\tDebit Card Pin: " + this.debitCardPin);
    }
}
