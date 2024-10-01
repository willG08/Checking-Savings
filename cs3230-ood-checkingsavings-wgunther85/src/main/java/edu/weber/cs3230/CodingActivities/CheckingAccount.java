package edu.weber.cs3230.CodingActivities;

import java.math.BigDecimal;

public class CheckingAccount {

    private BigDecimal balance;
    private BigDecimal withdrawLimit;

    public CheckingAccount()
    {
        this.balance = BigDecimal.valueOf(0);
        this.withdrawLimit = BigDecimal.valueOf(Integer.MAX_VALUE);
    }

    public CheckingAccount(BigDecimal withdrawLimit)
    {
        this();
        this.withdrawLimit = withdrawLimit;

    }

    // return true if balance is less than the limit, false otherwise
    public boolean isLimitMet()
    {
        // TODO: return true if balance is less than the limit, false otherwise.
       //if balance is less than the withdraw limit
        if(balance.compareTo(withdrawLimit) < 0){
            return true;
        }
        System.out.println("Withdraw Limit is exceeded.");
        return false;
    }

    //deposits amount into the balance
    public void deposit(BigDecimal amount) {
        // TODO: method to deposit a certain amount in the checking account.
        balance = balance.add(amount);
    }

    //  set a limit for this account,
    //  if you try to set a negative limit, it will throw an exception.
    //  message should be "Limit is less than zero!"
    public void setLimit(BigDecimal withdrawLimit) {
        /* TODO: set a limit for this account, if you try to set a negative limit, it will display a message "Invalid limit!".
         */
        //withdraw limit is less than 0
        if(withdrawLimit.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Invalid limit!");
        }
        //else set withdrawlimit
        else{
            this.withdrawLimit = withdrawLimit;
        }

    }

    public boolean withdraw(BigDecimal amount) {
        /* TODO: withdraw a certain amount from the checking account. If there is no enough money in the account,
            display an error message: "no enough balance"
         */
        //if amount is bigger than the balance then we can't change the amount
        if(amount.compareTo(balance) > 0 || amount.compareTo(withdrawLimit) > 0){
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

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getWithdrawLimit() {
        return withdrawLimit;
    }

}