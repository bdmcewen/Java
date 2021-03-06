package bankapp;

public abstract class Account implements IBaseRate {
    static int index = 1000;
    //List common properties of both account types
    String name;
    String sSN;
    double balance;
    String accountNumber;
    double rate;

    // Constructor to set base properties  and initialize accounts
    public Account(String name, String sSn, double initDeposit) {

        this.name = name;
        this.sSN = sSn;
        balance = initDeposit;

        // call method to set the account number
        index++;
        accountNumber = setAccountNumber();

        // call method to set interest rate
        setRate();

    }

    // List common methods of both account types
    public abstract void setRate();

    public String setAccountNumber() {
        String lastTwoOfsSn = sSN.substring(sSN.length() - 2);
        int uniqueID = index;
        int randNum = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfsSn + uniqueID + randNum;
    }

    public void showInfo() {
        System.out.println("Name: " + name +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nRate: " + rate + "%"
        );
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
