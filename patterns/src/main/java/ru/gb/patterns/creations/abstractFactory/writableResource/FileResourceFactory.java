package ru.gb.patterns.creations.abstractFactory.writableResource;

import java.io.IOException;

public class FileResourceFactory implements ResourceFactory {

    private final String resource;

    public FileResourceFactory(String resource) {
        this.resource = resource;
    }

    @Override
    public WritableResource getResource() throws IOException {
        return new FileResource(resource);
    }

}
