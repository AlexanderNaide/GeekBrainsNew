package ru.gb.Bootcamp.AlgorithmsRestart;


import java.util.Arrays;

/**
 * Пузырьковая сортировка.
 * *
 * Суть: сравниваются соседние элементы и если следующий элемент меньше предыдущего - они меняются местами.
 * Так повторяется до тех пор, пока не останется замен. (можно использовать вложенный цикл, но тогда сортировка будет всегда
 * ходить максимальное количество раз, а через булеву переменную мы гоняем минимальное количество раз до отсортированного массива.)
 * *
 * Сложность алгоритма: O(N^2)
 */

public class BobbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 5, 7, 3, 4, 1, 6, 8};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
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
