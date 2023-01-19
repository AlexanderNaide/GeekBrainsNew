package ru.gb.HomeWorks_core2.lesson2;

public class MyArrayDataException extends Exception{
    int y;
    int x;

    public MyArrayDataException(int y, int x){
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Error in the cell [" + y + "][" + x + "]: " + super.toString();
    }
}
