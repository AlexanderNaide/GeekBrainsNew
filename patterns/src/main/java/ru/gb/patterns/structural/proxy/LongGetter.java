package ru.gb.patterns.structural.proxy;

import java.util.Timer;

public interface LongGetter {

    default long getLong(long value){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

}
