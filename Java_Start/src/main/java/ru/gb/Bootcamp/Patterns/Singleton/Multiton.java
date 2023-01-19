package ru.gb.Bootcamp.Patterns.Singleton;

import java.util.HashMap;
import java.util.Map;

public class Multiton {

    private static final Map instance = new HashMap();

    private static Multiton multitonInstanse = null;

    private Multiton(){}

    public static Multiton getInstance(String key){
        multitonInstanse = (Multiton) instance.get(key);
        if (multitonInstanse == null){
            multitonInstanse = new Multiton();
            instance.put(key, multitonInstanse);
        }
        return multitonInstanse;

    }

}
