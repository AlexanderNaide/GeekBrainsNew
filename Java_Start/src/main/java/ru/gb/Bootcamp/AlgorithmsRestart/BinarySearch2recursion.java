package ru.gb.Bootcamp.AlgorithmsRestart;

import java.util.Arrays;

public class BinarySearch2recursion {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,};
        System.out.println(search(array, 3));
    }

    public static int search(int[] array, int value){
        return search(array, value, 0, array.length - 1);
    }


    public static int search(int[] array, int value, int min, int max){
        int midpoint;
        if (max < min || array.length == 0){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value){
            return search(array, value, midpoint + 1, max);
        } else if (array[midpoint] > value){
            return search(array, value, min, midpoint - 1);
        } else {
            return midpoint;
        }
    }




}
