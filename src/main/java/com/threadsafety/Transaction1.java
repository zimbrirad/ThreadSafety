package com.threadsafety;

public class Transaction1 implements Runnable {
    private BankAccount1 sourceAccount, destinationAccount;
    private double amount;

    public Transaction1(BankAccount1 sourceAccount, BankAccount1 destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        System.out.format("%s started execution%n", Thread.currentThread().getName());
        sourceAccount.transfer(destinationAccount, amount);
        System.out.printf("%s completed execution%n", Thread.currentThread().getName());
    }

}
