package com.test.threadsafety;

import com.threadsafety.Friends;
import org.junit.Test;

/**
 * Ce problema de Liveness avem in acest caz
 */
public class Test3 {

    public void test(){
        Friends friends = new Friends();
        friends.executeFriends();
    }
}
