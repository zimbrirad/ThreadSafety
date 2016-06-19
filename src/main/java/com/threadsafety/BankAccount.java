package com.threadsafety;

/**
 *
 */
public interface BankAccount {

    boolean tryTransfer(BankAccount2 destinationAccount, double amount);
    void transfer(BankAccount1 to, double amount);
}
