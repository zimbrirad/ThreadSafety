package com.threadsafety;

public class BalanceMonitor implements Runnable {
    private BankAccount1 account;
    public BalanceMonitor(BankAccount1 account) { this.account = account;}
    boolean alreadyNotified = false;

    public void run() {
        System.out.format("%s started execution%n", Thread.currentThread().getName());
        while (true) {
            if(account.getBalance() <= 0) {
                // send email, or sms, clouds of smoke ...
                break;
            }
        }
        System.out.format("%s : account has gone too low, email sent, exiting.", Thread.currentThread().getName());
    }

}
