package ru.gb.HomeWorks_core1.lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {

    public static void main(String[] args) {

        System.out.println("----------Задание 1----------");
        int[] zerosAndOnes = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] invertZerosAndOnes = turningOvers(zerosAndOnes);
        System.out.println("Было:  " + Arrays.toString(zerosAndOnes));
        System.out.println("Стало: " + Arrays.toString(invertZerosAndOnes));
        System.out.println();

        System.out.println("----------Задание 2----------");
        int[] arrayPerHundred = new int[100];
        fillingAnArray(arrayPerHundred);
        System.out.println(Arrays.toString(arrayPerHundred));
        System.out.println();

        System.out.println("----------Задание 3----------");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] elevatedArr = promotionArr(arr);
        System.out.println("Было:  " + Arrays.toString(arr));
        System.out.println("Стало: " + Arrays.toString(elevatedArr));
        System.out.println();

        System.out.println("----------Задание 4----------");
        print2dArray(diagonalFillingArr(9));
        System.out.println();

        System.out.println("----------Задание 5----------");
        System.out.println(Arrays.toString(fillingArrayWithNumber(10,8)));
        System.out.println();

        System.out.println("----------Задание 6----------");
        int[] arrRandom = fillingAnArrayRandom(20);
        System.out.println(Arrays.toString(arrRandom));
        maxAndMin(arrRandom);
        System.out.println();

        System.out.println("----------Задание 7----------");
        int[] arrRandom2 = {2, 2, 2, 1, 2, 2, 10, 1}; //11=11
//        int[] arrRandom2 = {85, 26, 62, 41, 53, 72, 26, 45, 61, 63}; //267=267
//        int[] arrRandom2 = {1, 1, 1, 2, 1}; //3=3
//        int[] arrRandom2 = {99, 1, 1, 1, 96}; //99=99
//        int[] arrRandom2 = fillingAnArrayRandom(10); //Тут получаем массив случайных чисел
        System.out.println(Arrays.toString(arrRandom2));
        System.out.println(checkBalance(arrRandom2));
        System.out.println();

        System.out.println("----------Задание 8----------");
        int[] arrayBeforeShift = {1, 2, 3, 4, 5, 6};
        System.out.println("Было:  " + Arrays.toString(arrayBeforeShift));
        shift(arrayBeforeShift, -2);
        System.out.println("Стало: " + Arrays.toString(arrayBeforeShift));

    }

    // Задание 1: заменить 0 на 1 и наоборот
    public static int[] turningOvers(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] == 0 ? 1 : 0;
        }
        return newArr;
    }

    // Заданте 2: заполнить массив на 100 в цикле значениями 1-100
    public static void fillingAnArray (int[] arr){
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
    }

    // Задание 3: пройти по массиву циклом, и числа меньше 6 умножить на 2
    public static int[] promotionArr (int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }
        return newArr;
    }

    // Задание 4: Создать квадратный двумерный массив, по диагоналям заполнить 1-ми
    public static int[][] diagonalFillingArr(int count){
        int[][] arr = new int[count][count];
        for (int i = 0; i < count; i++) {
            arr[i][i] = 1;
            arr[i][count - 1 - i] = 1;
        }
        return arr;
    }

    // Метод для печати 2D массивов
    public static void print2dArray (int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    // Задание 5: Метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static int[] fillingArrayWithNumber (int len, int initialValue){
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    // Задание 6_a: метод, возвращающий массив произвольных чисел заданной (переданной в аргументе) длинны
    public static int[] fillingAnArrayRandom(int ints){
        int[] arr = new int[ints];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    // Задание 6_б: метод выводит в консоль максимальное и минимальное значение массива.
    public static void maxAndMin (int[] arr){
        int max = 0;
        int min = arr[0];
        for (int i : arr){
            if (i > max){
                max = i;
            }
            if (i < min){
                min = i;
            }
        }
        System.out.printf("Maximum = %s; Minimum = %s;\n", max, min);
    }

    // Задание 7: Найти, есть ли место в массиве, в котором сумма "до" равна сумме "после", либо вернуть false, если такого места нет.
    public static boolean checkBalance (int[] arr){

        boolean balance = false;

        for (int i = 1; i < arr.length; i++) {
            int prev = 0;
            int post = 0;
            for (int j = 0; j < i; j++) {
                prev += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                post += arr[j];
            }
            if (prev == post){
//                System.out.println(prev + " = " + post);  //раскомментировать, чтобы видеть совпавшие суммы.
                balance = true;
                break;
            }
            else {
                prev = 0;
                post = 0;
            }
        }
        return balance;
    }

    // Задание 8: Написть метод, который сдвигает значения переданного массива n раз в + или - сторону
    public static void shift(int[] arr, int n){
        for (int i = 0; i < (arr.length + (n % arr.length)); i++) {
            int a = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = a;
        }
    }
}
