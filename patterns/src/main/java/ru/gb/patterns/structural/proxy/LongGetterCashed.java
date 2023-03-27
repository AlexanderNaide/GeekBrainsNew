package ru.gb.patterns.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class LongGetterCashed implements LongGetter{

    private LongGetter origin;
    private Map<Long, Long> cache;

    public LongGetterCashed(LongGetter origin) {
        this.origin = origin;
        cache = new HashMap<>();
    }

    @Override
    public long getLong(long value) {
        if (!cache.containsKey(value)){
            cache.put(value, origin.getLong(value));
        }

        return cache.get(value);
    }
}
