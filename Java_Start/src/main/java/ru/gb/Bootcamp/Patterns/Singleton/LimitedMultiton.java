package ru.gb.Bootcamp.Patterns.Singleton;

import java.util.HashMap;
import java.util.Map;

public class LimitedMultiton {

    public enum Count {
        ONE,
        TWO,
        THREE
    }

    private static final Map instances = new HashMap();

    private static LimitedMultiton limitedMultitonInstanse = null;

    private LimitedMultiton(){}

    public static LimitedMultiton getInstance(Count key){
        limitedMultitonInstanse = (LimitedMultiton) instances.get(key);
        if (limitedMultitonInstanse == null){
            limitedMultitonInstanse = new LimitedMultiton();
            instances.put(key, limitedMultitonInstanse);
        }
        return limitedMultitonInstanse;

    }
}
