Project 3

# Bank Application

## Scenario: You are a back end developer and need to create an application to handle new customer bank account requests

## create an application to manage bank accounts and balances.

## Your application should do the following:

```
- Read a .csv file of names, social security numbers, account type, and initial deposit
- Use a proper datastructure to hold all these accounts
- Both savings and checking accounts will have the following attributes:
    - 11-digit account number generated as a composite value from the following values
        - account type(1 for savings and 2 for checking)
        - last two digits of the account holders SSN
        - unique 5-digit number
        - random 3-digit number
- Both savings and checking accounts share the following actions:
    - deposit()
    - withdraw()
    - transfer()
    - showinfo()
- Savings Account holders are given a safety Deposit Box, identified by a 3-digit number
    and accessed with a 4 digit code
- Checking Account holders are assigned a Debit Card with a 12-digit number 
    and a 4-digit PIN
- Both accounts will use an interface that determines the base interest rate as follows:
    - savings accounts will use .25 points less tha the base rate
    - checkings accounts will use 15% of the base rate
- The showinfo() method should reveal relevant account holder information 
    as well as inforamtion specific to checking/savings
```
## Skills required
```
- Application architecture
- OOP concepts
    - Inheritance
        - abstract super class
        - abstract super methods,  account.setRate()
    - Constructors
        - use of super key word
    - Interface API
        - use of implements 
    - Encapsulation
        - access modifiyers
            - private, static(auto_increment)
    - Polymorphism
        - @override, showInfo()
            - super.showInfo();

```

