package ru.gb.patterns.structural.composite;

import java.util.List;

public class Dir implements Item {
    private List<Item> files;

    public Dir(List<Item> files) {
        this.files = files;
    }

    public List<Item> getFiles() {
        return files;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for (Item file : files) {
            if(file.isFile()){
                s.append("file ");
            } else {
                s.append(file);
            }
        }
        s.append(")");
        return s.toString();
    }
}
