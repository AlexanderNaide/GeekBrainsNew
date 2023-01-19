package ru.gb.Bootcamp.Hash;

import java.util.ArrayList;
import java.util.List;

public class HashTable<T> {

    private int size = 128;

    private List<T>[] table = new ArrayList[size];

    HashTable(){
    }

    public HashTable(int size){
        this.size = size;
    }

    private int hashCode(T object){
        int hash = object.hashCode() % size;
        return hash < 0 ? -hash : hash;
    }

    public void put(T object){
        if (contains(object)) {
            return;
        }
        int ix = hashCode(object);
        if (table[ix] == null){
            table[ix] = new ArrayList<>();
        }
        table[ix].add(object);
    }

    public boolean contains(T object){
        int ix = hashCode(object);
        if (table[ix] == null){
            return false;
        }
        int itemIx = table[ix].indexOf(object);
        return itemIx >= 0;
    }

    public void remove(T object){
        int ix = hashCode(object);
        if (table[ix] == null){
            return;
        }
        table[ix].remove(object);
    }
}
