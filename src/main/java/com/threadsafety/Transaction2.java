package com.threadsafety;

public class Transaction2 implements Runnable {
    private BankAccount2 sourceAccount, destinationAccount;
    private double amount;

    public Transaction2(BankAccount2 sourceAccount, BankAccount2 destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public void run() {
        while (!sourceAccount.tryTransfer(destinationAccount, amount))
            continue;
        System.out.printf("%s completed ", Thread.currentThread().getName());
    }

}
