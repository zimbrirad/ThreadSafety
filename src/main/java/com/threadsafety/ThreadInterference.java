package com.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThreadInterference {
    int count = 0;

    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadInterference threadInterference = new ThreadInterference();
        for(int i = 0; i<1000000; i++) {
            executor.submit(new TaskInterference(threadInterference));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(threadInterference.count);

    }

    void  increment() {
        count = count + 1;
    }
}
final class TaskInterference implements Runnable {
    ThreadInterference threadInterference;
    TaskInterference(ThreadInterference threadInterference){
        this.threadInterference = threadInterference;
    }
    public void run() {
        threadInterference.increment();
    }
}
