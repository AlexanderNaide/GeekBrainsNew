package ru.gb.Bootcamp.AlgorithmsRestart;


import java.util.Arrays;

/**
 * Сортировка прямым выбором.
 * *
 * Суть: заходим на первый элемент, пробегаемся по всем остальным, находим наименьший, если есть - меняем его местами с первым.
 * Далее заходим на второй и то же самое. Таким образом каждый элемент наименьший из тех, которые идут далее.
 * *
 * Сложность алгоритма: O(N^2)
 */

public class DirectSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 5, 7, 3, 4, 1, 6, 8};
        System.out.println(Arrays.toString(array));
        search(array);
        System.out.println(Arrays.toString(array));
    }

    public static void search(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int position = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    position = j;
                }
            }
            if (min != array[i]){
                int temp = array[i];
                array[i] = array[position];
                array[position] = temp;
            }
        }
    }
}
