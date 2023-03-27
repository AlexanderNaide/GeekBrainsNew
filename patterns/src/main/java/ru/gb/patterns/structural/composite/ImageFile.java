package ru.gb.patterns.structural.composite;

import java.io.FileInputStream;
import java.io.IOException;

public class ImageFile extends File{

    private final String url;
    private final byte[] data;

    public ImageFile(String url) throws IOException {
        this.url = url;
        data = new byte[]{1, 2, 3};
    }

    @Override
    public byte[] getData() {
        return data;
    }
}
