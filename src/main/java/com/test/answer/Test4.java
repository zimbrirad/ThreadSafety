package com.test.answer;

/**
 *
 */
public class Test4 {

    public void test(){
        final Friends alphonse =
                new Friends("Alphonse");
        final Friends gaston =
                new Friends("Gaston");
        alphonse.executeFriends();

//pentru mai multe executii:
//        new Thread(new BowLoop(alphonse, gaston)).start();
//        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
