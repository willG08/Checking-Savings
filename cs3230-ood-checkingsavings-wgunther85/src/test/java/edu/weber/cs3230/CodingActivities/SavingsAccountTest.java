package edu.weber.cs3230.CodingActivities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount("John Doe", BigDecimal.valueOf(1000), BigDecimal.valueOf(5));
    }

    @Test
    void getNameShouldReturnCorrectName() {
        assertEquals("John Doe", savingsAccount.getName());
    }

    @Test
    void getBalanceShouldReturnCorrectBalance() {
        assertEquals(BigDecimal.valueOf(1000), savingsAccount.getBalance());
    }

    @Test
    void getInterestRateShouldReturnCorrectInterestRate() {
        assertEquals(BigDecimal.valueOf(5), savingsAccount.getInterestRate());
    }

    @Test
    void setInterestRateShouldUpdateInterestRate() {
        savingsAccount.setInterestRate(BigDecimal.valueOf(7.5));
        assertEquals(BigDecimal.valueOf(7.5), savingsAccount.getInterestRate());
    }

    @Test
    void calculateMonthlyInterestShouldReturnCorrectAmount() {
        assertEquals(BigDecimal.valueOf(50), savingsAccount.calculateMonthlyInterest());
    }

    @Test
    void updateBalanceWithInterestShouldUpdateBalanceCorrectly() {
        savingsAccount.updateBalanceWithInterest();
        assertEquals(BigDecimal.valueOf(1050), savingsAccount.getBalance());
    }

    @Test
    void depositShouldIncreaseBalance() {
        savingsAccount.deposit(BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(1500), savingsAccount.getBalance());
    }

    @Test
    void withdrawShouldReturnTrueAndDecreaseBalanceForValidWithdrawal() {
        assertTrue(savingsAccount.withdraw(BigDecimal.valueOf(500)));
        assertEquals(BigDecimal.valueOf(500), savingsAccount.getBalance());
    }

    @Test
    void withdrawShouldReturnFalseForInsufficientBalance() {
        assertFalse(savingsAccount.withdraw(BigDecimal.valueOf(1500)));
        assertEquals(BigDecimal.valueOf(1000), savingsAccount.getBalance());
    }
}
