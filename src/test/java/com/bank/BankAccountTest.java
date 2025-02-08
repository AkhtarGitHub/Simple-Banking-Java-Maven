package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class BankAccountTest {

    @Test
    void testInitialDeposit() {
        BankAccount account = new BankAccount("Peter Pan", new BigDecimal("200.00"));
        assertEquals(new BigDecimal("200.00"), account.getBalance());
    }

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("Peter Pan", new BigDecimal("200.00"));
        account.deposit(new BigDecimal("50.00"));
        assertEquals(new BigDecimal("250.00"), account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("Peter Pan", new BigDecimal("200.00"));
        account.withdraw(new BigDecimal("40.00"));
        assertEquals(new BigDecimal("160.00"), account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("Peter Pan", new BigDecimal("200.00"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(new BigDecimal("250.00"));
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }
}

