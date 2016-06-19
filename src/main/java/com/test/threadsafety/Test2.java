package com.test.threadsafety;

import com.threadsafety.BankAccount2;
import com.threadsafety.Transaction2;
import org.junit.Test;

/**
 * Ce problema de Liveness avem in acest caz
 */
public class Test2 {

    public void test() {
        final BankAccount2 fooAccount = new BankAccount2(1, 500d);
        final BankAccount2 barAccount = new BankAccount2(2, 500d);

        new Thread(new Transaction2(fooAccount, barAccount, 10d), "transaction-1").start();
        new Thread(new Transaction2(barAccount, fooAccount, 10d), "transaction-2").start();
    }
}
