package ru.gb.Bootcamp.Algorithms;

public class DirectSort {

    /**
     * Сортировка прямым выбором
     * O(x^2)
     */

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    minPosition = j;
                }
            }
            if (min != array[i]){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
        
    }
}
