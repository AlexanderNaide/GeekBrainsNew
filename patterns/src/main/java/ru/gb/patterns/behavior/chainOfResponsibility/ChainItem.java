package ru.gb.patterns.behavior.chainOfResponsibility;

public interface ChainItem {

    Object consume(Object object);
}
