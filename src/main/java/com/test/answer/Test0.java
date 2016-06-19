package com.test.answer;

/**
 *
 */
public class Test0 {


    /* putem adauga una din metodele
         synchronized void incrementSync() {
        count = count + 1;
    }
     */

    /*
    void incrementSyncBlock() {
        synchronized (this) {
            count = count + 1;
        }
    }
     */

    /* putem face count atomic folosind java.lang.concurrent
    AtomicInteger count = new AtomicInteger(0);
        void  increment() {
        count.incrementAndGet();
        }

     */
}
