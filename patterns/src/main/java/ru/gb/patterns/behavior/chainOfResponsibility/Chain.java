package ru.gb.patterns.behavior.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Chain {

    private List<ChainItem> chain;

    public Chain(){
        chain = new ArrayList<>();
    }

    public List<ChainItem> chain(){
        return chain;
    }

    public void add(ChainItem... items){
        chain.addAll(List.of(items));
    }

    public Object process(Object object){
        Object cur = object;
        for (ChainItem chainItem : chain){
            cur = chainItem.consume(cur);
        }
        return cur;
    }

}
