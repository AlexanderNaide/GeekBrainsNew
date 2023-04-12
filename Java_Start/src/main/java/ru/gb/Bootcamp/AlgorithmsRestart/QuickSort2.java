package ru.gb.Bootcamp.AlgorithmsRestart;

import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 5, 7, 3, 4, 1, 6, 8};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[]array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while(array[leftPosition] < pivot){
                leftPosition++;
            }
            while(array[rightPosition] > pivot){
                rightPosition--;
            }
            if (leftPosition <= rightPosition){
                if (leftPosition < rightPosition){
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition){
            sort(array, leftPosition, endPosition);
        }
        if (rightPosition > startPosition){
            sort(array, startPosition, rightPosition);
        }
    }
}
