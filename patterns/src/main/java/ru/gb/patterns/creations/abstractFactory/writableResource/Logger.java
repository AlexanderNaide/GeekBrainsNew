package ru.gb.patterns.creations.abstractFactory.writableResource;

import java.io.IOException;

public class Logger {
    private WritableResource resource;

    public Logger(ResourceFactory resourceFactory) throws IOException {
        resource = resourceFactory.getResource();
    }

    public void log(String massage){
        resource.write(massage);
    }
}
