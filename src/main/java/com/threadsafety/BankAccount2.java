package com.threadsafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount2 {
    double balance;
    int id;
    Lock lock = new ReentrantLock();

    public BankAccount2(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    boolean withdraw(double amount) {
        if (this.lock.tryLock()) {
            // Wait to simulate io like database access ...
            try {Thread.sleep(10l);} catch (InterruptedException e) {}
            balance -= amount;
            return true;
        }
        return false;
    }

    boolean deposit(double amount) {
        if (this.lock.tryLock()) {
            // Wait to simulate io like database access ...
            try {Thread.sleep(10l);} catch (InterruptedException e) {}
            System.out.println("Deposit into account");
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean tryTransfer(BankAccount2 destinationAccount, double amount) {
        if (this.withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            } else {
                // destination account busy, refund source account.
                System.out.println("Refund source account");
                this.deposit(amount);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        final BankAccount2 fooAccount = new BankAccount2(1, 500d);
        final BankAccount2 barAccount = new BankAccount2(2, 500d);

        new Thread(new Transaction2(fooAccount, barAccount, 10d), "transaction-1").start();
        new Thread(new Transaction2(barAccount, fooAccount, 10d), "transaction-2").start();

    }

}
