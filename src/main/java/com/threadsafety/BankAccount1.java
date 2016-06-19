package com.threadsafety;

public class BankAccount1 {
    private double balance;
    int id;

    public BankAccount1(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    synchronized double getBalance() {
        // Wait to simulate io like database access ...
        try {
            System.out.println("Read balance");
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println("Unlock account");
        return balance;
    }

    synchronized void withdraw(double amount) {
        balance -= amount;
    }

    synchronized void deposit(double amount) {
        balance += amount;
    }

    synchronized void transfer(BankAccount1 to, double amount) {
        withdraw(amount);
        to.deposit(amount);
    }

}
