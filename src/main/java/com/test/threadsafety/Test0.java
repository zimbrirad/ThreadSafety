package com.test.threadsafety;

import com.threadsafety.ThreadInterference;
import org.junit.Test;

/**
 *  rezultatul count-ului este imprevizibil cum putem modifica clasa ThreadInterference pentru
 *  a avea ca rezultat al count-ului numarul de thread-uri (3 metode)
 */
public class Test0 {
    public void threadInterferenceTest(){
        //Concurency
        ThreadInterference threadInterfernce = new ThreadInterference();
        threadInterfernce.execute();
    }
}

