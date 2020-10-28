package bankapp;

public interface IBaseRate {
    // create method that returns a base  interest rate
    default double getBaseRate(){
        return 2.5;
    }
}
