package bankapp;

public abstract class Account implements IBaseRate {
    //List common properties of both account types
    String name;
    String sSN;
    double balance;

    static int index = 1000;
    String accountNumber;
    double rate;

    // Constructor to set base properties  and initialize accounts
    public Account(String name, String sSn, double initDeposit){

        this.name = name;
        this.sSN = sSn;
        balance = initDeposit;

        // call method that generates the account number
        index++;
        accountNumber = generateAccountNumber();




    }

    // List common methods of both account types
    public String generateAccountNumber(){
        String lastTwoofsSn = sSN.substring(sSN.length()-2);
        int uniqueID = index;
        int randNum = (int)(Math.random() * Math.pow(10,3));
        return lastTwoofsSn + uniqueID + randNum;
    }


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
