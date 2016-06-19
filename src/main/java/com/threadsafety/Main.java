package com.threadsafety;

import com.test.threadsafety.Test0;
import com.test.threadsafety.Test1;
import com.test.threadsafety.Test2;
import com.test.threadsafety.Test3;
import com.test.threadsafety.Test4;

public class Main {
    public static void main(String[] args) {
//        Test0 test0 = new Test0();
//        test0.threadInterferenceTest();
//        Test1 test1 = new Test1();
//        test1.test();
//        Test2 test2 = new Test2();
//        test2.test();
//        Test3 test3 = new Test3();
//        test3.test();
        Test4 test4 = new Test4();
        test4.test();
    }
}
