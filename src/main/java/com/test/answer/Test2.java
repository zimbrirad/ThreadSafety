package com.test.answer;

/**
 * LiveLock
 */
public class Test2 {

//        transaction-1 withdraw 10$ from account “1”
//        transaction-2 withdraw 10$ from account “2”
//        transaction-1 failed to deposit in account “2” because “transaction-2” already hold the lock on that account. Account “1” refunded
//        transaction-2 failed to deposit in account “1” because “transaction-1” already hold the lock on that account. Account “2” refunded
//        transaction-1 withdraw 10.000000 from account “1”
//        transaction-2 withdraw 10.000000 from account “2”
//        transaction-1 failed to deposit in account “2” because “transaction-2” already hold the lock on that account. Account “1” refunded
//        transaction-2 failed to deposit in account “1” because “transaction-1” already hold the lock on that account. Account “2” refunded
//        and so on …
}
