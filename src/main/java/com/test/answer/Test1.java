package com.test.answer;

/**
 * Starvation
 */
public class Test1 {
//        BalanceMonitor lock account foo
//        Transaction 1 tries to acquire lock on account foo. Cannot, because balance monitor hold it. Waiting …
//        BalanceMonitor read balance
//        BalanceMonitor unlock acccount
//        BalanceMonitor lock account foo
//        Transaction 1 retry to aquire lock, Cannot, BalanceMonitor still holding it.
//                BalanceMonitor read balance
//        BalanceMonitor unlock acccount
//        BalanceMonitor lock account foo
//        Transaction 1 retry to aquire lock, Cannot, BalanceMonitor still holding it.
//                BalanceMonitor read balance
//        BalanceMonitor unlock acccount
//        And so on a lot of time until Transaction 1 and Transaction 2 finally execute
}
