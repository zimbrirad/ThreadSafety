package com.test.answer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Friends {
    private final String name;
    private final Lock lock = new ReentrantLock();

    public Friends(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //acquire locks for both participants
    public boolean impendingBow(Friends bower) {
        Boolean myLock = false;
        Boolean yourLock = false;
        try {
            myLock = lock.tryLock();
            yourLock = bower.lock.tryLock();
        } finally {
            if (!(myLock && yourLock)) {
                if (myLock) {
                    lock.unlock();
                }
                if (yourLock) {
                    bower.lock.unlock();
                }
            }
        }
        return myLock && yourLock;
    }

    public void bow(Friends bower) {
        if (impendingBow(bower)) {
            try {
                System.out.format("%s: %s has"
                                + " bowed to me!%n",
                        this.name, bower.getName());
                bower.bowBack(this);
            } finally {
                lock.unlock();
                bower.lock.unlock();
            }
        } else {
            System.out.format("%s: %s started"
                            + " to bow to me, but saw that"
                            + " I was already bowing to"
                            + " him.%n",
                    this.name, bower.getName());
        }
    }

    public void bowBack(Friends bower) {
        System.out.format("%s: %s has" +
                        " bowed back to me!%n",
                this.name, bower.getName());
    }
    //saracii...
    public void executeFriends() {
        final Friends alphonse =
                new Friends("Alphonse");
        final Friends gaston =
                new Friends("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}

class BowLoop implements Runnable {
    private Friends bower;
    private Friends bowee;

    public BowLoop(Friends bower, Friends bowee) {
        this.bower = bower;
        this.bowee = bowee;
    }

    public void run() {
        Random random = new Random();
        for (; ; ) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
            }
            bowee.bow(bower);
        }
    }
}
