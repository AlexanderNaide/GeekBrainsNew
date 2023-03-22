package ru.gb.patterns.creations.abstractFactory.writableResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileResource implements WritableResource, Closeable {

    private final String resource;
    private OutputStream os;

    public FileResource(String resource) throws IOException {
        this.resource = resource;
        os = new FileOutputStream(resource, true);
    }

    @Override
    public void write(Object... args) {
        String result = Arrays.stream(args)
                .map(Object::toString)
                .collect(Collectors.joining(" ")) + "\n";

        try {
            os.write(result.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        os.close();
    }
}
