package L01InterestRate;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;


    private static int idCounter;

    private int id;
    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount(){
        this.id = ++idCounter;
    }

    public int getId(){
        return this.id;
    }

    public static void setInterestRate(double interest){
        interestRate = interest;
    }

    public double getInterest(int years){
        return this.balance * interestRate * years;
    }

    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Entered value must be positive number");
        }
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
