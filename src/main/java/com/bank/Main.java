package com.bank;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Aloha", new BigDecimal("200.00"));

        System.out.println("Initial Balance: $" + account.getBalance());

        account.deposit(new BigDecimal("50.00"));
        System.out.println("After Deposit of $50: $" + account.getBalance());

        account.withdraw(new BigDecimal("100.00"));
        System.out.println("After Withdrawal of $100: $" + account.getBalance());

        try {
            account.withdraw(new BigDecimal("500.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}