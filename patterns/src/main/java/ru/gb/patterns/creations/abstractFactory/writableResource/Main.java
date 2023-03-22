package ru.gb.patterns.creations.abstractFactory.writableResource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Logger logger = new Logger(new ConsoleResourceFactory());
        logger.log("Hello world!");

        logger = new Logger(new FileResourceFactory("out.txt"));
        logger.log("Hello world!!!");

    }
}