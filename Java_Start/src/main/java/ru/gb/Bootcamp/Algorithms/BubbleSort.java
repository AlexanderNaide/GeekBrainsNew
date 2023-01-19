package ru.gb.Bootcamp.Algorithms;

public class BubbleSort {

    /**
     * Пузырьковая сортировка
     * O(x^2)
     */

    public static void sort(int[] array){
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needSort = true;
                }
            }
        } while (needSort);
    }
}
