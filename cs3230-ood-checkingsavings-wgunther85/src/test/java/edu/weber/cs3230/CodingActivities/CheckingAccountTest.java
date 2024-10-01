package edu.weber.cs3230.CodingActivities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount();
    }

    @Test
    void isLimitMetShouldReturnTrueWhenBalanceIsLessThanLimit() {
        checkingAccount.deposit(BigDecimal.valueOf(100));
        checkingAccount.setLimit(BigDecimal.valueOf(200));
        assertTrue(checkingAccount.isLimitMet());
    }

    @Test
    void isLimitMetShouldReturnFalseWhenBalanceIsEqualToLimit() {
        checkingAccount.deposit(BigDecimal.valueOf(200));
        checkingAccount.setLimit(BigDecimal.valueOf(200));
        assertFalse(checkingAccount.isLimitMet());
    }

    @Test
    void isLimitMetShouldReturnFalseWhenBalanceIsGreaterThanLimit() {
        checkingAccount.deposit(BigDecimal.valueOf(300));
        checkingAccount.setLimit(BigDecimal.valueOf(200));
        assertFalse(checkingAccount.isLimitMet());
    }

    @Test
    void depositShouldIncreaseBalance() {
        checkingAccount.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), checkingAccount.getBalance());
    }

    @Test
    void setLimitShouldThrowExceptionForNegativeLimit() {
        // Redirect System.out to capture printed messages
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Perform the test
        checkingAccount.setLimit(BigDecimal.valueOf(-100));

        // Reset System.out
        System.setOut(System.out);

        // Verify that the expected message is printed to the console
        String consoleOutput = outputStream.toString().trim();
        assertTrue(consoleOutput.contains("Invalid limit!"), "Expected error message not found in console output");    }

    @Test
    void setLimitShouldSetLimitForValidInput() {
        checkingAccount.setLimit(BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), checkingAccount.getWithdrawLimit());
    }

    @Test
    void withdrawShouldReturnTrueForValidWithdrawal() {
        checkingAccount.deposit(BigDecimal.valueOf(500));
        assertTrue(checkingAccount.withdraw(BigDecimal.valueOf(200)));
        assertEquals(BigDecimal.valueOf(300), checkingAccount.getBalance());
    }

    @Test
    void withdrawShouldReturnFalseForInsufficientBalance() {
        checkingAccount.deposit(BigDecimal.valueOf(200));
        assertFalse(checkingAccount.withdraw(BigDecimal.valueOf(300)));
        assertEquals(BigDecimal.valueOf(200), checkingAccount.getBalance());
    }

    @Test
    void withdrawShouldReturnFalseForExceedingLimit() {
        checkingAccount.deposit(BigDecimal.valueOf(500));
        checkingAccount.setLimit(BigDecimal.valueOf(400));
        assertFalse(checkingAccount.withdraw(BigDecimal.valueOf(500)));
        assertEquals(BigDecimal.valueOf(500), checkingAccount.getBalance());
    }
}

