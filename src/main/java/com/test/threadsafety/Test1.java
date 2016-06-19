package com.test.threadsafety;

import com.threadsafety.BalanceMonitor;
import com.threadsafety.BankAccount1;
import com.threadsafety.Transaction1;
import org.junit.Test;

/**
 * Ce problema de Liveness avem in acest caz
 */
public class Test1 {

    public void test(){

        final BankAccount1 fooAccount = new BankAccount1(1, 500d);
        final BankAccount1 barAccount = new BankAccount1(2, 500d);
//
        Thread balanceMonitorThread1 = new Thread(new BalanceMonitor(fooAccount), "BalanceMonitor");
        Thread transactionThread1 = new Thread(new Transaction1(fooAccount, barAccount, 250d), "Transaction-1");
        Thread transactionThread2 = new Thread(new Transaction1(fooAccount, barAccount, 250d), "Transaction-2");

        balanceMonitorThread1.setPriority(Thread.MAX_PRIORITY);
        transactionThread1.setPriority(Thread.MIN_PRIORITY);
        transactionThread2.setPriority(Thread.MIN_PRIORITY);

        // Start the monitor
        balanceMonitorThread1.start();

        // And later, transaction threads tries to execute.
        try {Thread.sleep(10);} catch (InterruptedException e) {}
        transactionThread1.start();
        transactionThread2.start();
    }

}
