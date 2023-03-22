package ru.gb.patterns.creations.abstractFactory.writableResource;

import java.io.IOException;

public interface ResourceFactory {

    WritableResource getResource() throws IOException;

}
