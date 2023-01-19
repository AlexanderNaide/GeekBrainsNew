package ru.gb.HomeWorks_core1.lesson3;

import java.util.Arrays;

public class NewHomeWorkApp {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = invertArray(arr1);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(method(arr3));


    }

    public static int[] invertArray(int[] arr){
        int[] resultArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = ((resultArr[i] + 1) % 2);
        }
        return resultArr;
    }

    public static boolean method(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i + 1; j++) {
                left += arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                right += arr[j];
            }
//            System.out.println(left + " / " + right);
            if (left == right){
                return true;
            }
        }
        return false;
    }
}
