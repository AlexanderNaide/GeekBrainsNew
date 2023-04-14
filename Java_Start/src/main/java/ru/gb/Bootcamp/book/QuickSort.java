package ru.gb.Bootcamp.book;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QuickSort {
    public static void main(String[] args) {

        int[] arrNonSort = new int[]{5, 7, 9, 2, 4, 8, 6, 1, 3, 10};
        System.out.println(Arrays.toString(arrNonSort));
//        int[] arrSort = quickSort(arrNonSort);
        int[] arrSort = minQuickSort(arrNonSort);
        System.out.println(Arrays.toString(arrSort));

        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            int a = (int) (Math.random() * 10000);
            arr[i] = a;
        }
        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        int[] arrResult1 = minQuickSort(arr);
        System.out.println("Время сортировки Стримами заняло " + (System.currentTimeMillis() - start1) / 1000 + " секунд");
        System.out.println(Arrays.toString(arrResult1));
        long start2 = System.currentTimeMillis();
        classicQuickSort(arr, 0, arr.length - 1);
        System.out.println("Время классической сортировки заняло " + (System.currentTimeMillis() - start2) / 1000 + " секунд");
        System.out.println(Arrays.toString(arr));


    }

    public static int[] quickSort(int[] array){
        if (array.length < 2){
            return array;
        } else {
            int pivot = array[array.length / 2];
            return IntStream.concat(IntStream.concat(Arrays.stream(quickSort(Arrays.stream(array).filter(k -> k < pivot).toArray())), IntStream.of(pivot)), Arrays.stream(quickSort(Arrays.stream(array).filter(k -> k > pivot).toArray()))).toArray();
        }
    }

    public static int[] minQuickSort(int[] array){
        if(array.length < 2){
            return array;
        } else {
            return IntStream.concat(IntStream.concat(Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e < array[array.length / 2]).toArray())), IntStream.of(array[array.length / 2])), Arrays.stream(minQuickSort(Arrays.stream(array).filter(e -> e > array[array.length / 2]).toArray()))).toArray();
        }
    }

    public static void classicQuickSort(int[] array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while(array[leftPosition] < pivot){
                leftPosition++;
            }
            while (array[rightPosition] > pivot){
                rightPosition--;
            }
            if(leftPosition <= rightPosition){
                if (leftPosition < rightPosition){
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
            if(leftPosition < endPosition){
                classicQuickSort(array, leftPosition, endPosition);
            }
            if(rightPosition > startPosition){
                classicQuickSort(array, startPosition, rightPosition);
            }
        }while (leftPosition <= rightPosition);
    }
}
