package edu.weber.cs3230.CodingActivities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.RoundingMode;

public class SavingsAccount {

    private static int nextId = 1;
    private int id;
    private String name;
    private LocalDate openingDate;
    private BigDecimal balance;
    private BigDecimal interestRate;    // represents a percentage, for example, if interestRate is 4.5, it means 4.5%;

    public SavingsAccount(String name, BigDecimal balance, BigDecimal interestRate)
    {
        // TODO: store the new variables
        this.name = name;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal calculateMonthlyInterest()
    {
       // TODO: calculate the interest amount for one month based on the current balance, and it returns the interest;
        BigDecimal InterestDecimal = interestRate.divide(BigDecimal.valueOf(100));
        BigDecimal InterestAmount = balance.multiply(InterestDecimal);
        //return InterestAmount.setScale(0, RoundingMode.DOWN).intValue();
        return InterestAmount.setScale(0, RoundingMode.DOWN);
    }

    public void updateBalanceWithInterest()
    {
        // TODO: update balance based on the monthly interest;
        BigDecimal InterestAmount = calculateMonthlyInterest();
        balance = balance.add(InterestAmount);
    }

    public void deposit(BigDecimal amount) {
        // TODO: method to deposit a certain amount in the Savings account.
        balance = balance.add(amount);
    }


    public boolean withdraw(BigDecimal amount) {
        /* TODO: withdraw a certain amount from the checking account. If there is no enough money in the account,
            display an error message: "no enough balance"
         */
        //if amount is bigger than the balance then we can't change the amount
        if(amount.compareTo(balance) > 0){
            //"No Enough Balance!" In case there needs to be the specific error message
            System.out.println("\nInsufficient funds.\n");
            return false;
        }
        else{
            //if amount is smaller or equal to the balance we can withdraw
            balance = balance.subtract(amount);
            return true;
        }
    }


}
