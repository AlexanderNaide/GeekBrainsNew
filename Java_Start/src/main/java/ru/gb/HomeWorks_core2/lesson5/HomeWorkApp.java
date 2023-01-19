package ru.gb.HomeWorks_core2.lesson5;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) throws InterruptedException {
        final int size = 10000000;
        final int h = size/2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0F);


        /******  Первый метод  ******/

        Thread methodLine = new Thread(() -> Calculation(arr));
        long lStart = System.currentTimeMillis();   // Для первого метода замеряем время на:
        methodLine.start();                         // - прогон массива в одном потоке
        methodLine.join();
        long lFinish = System.currentTimeMillis();
        System.out.println("Время однопоточного метода в миллисекундах: " + (lFinish - lStart));


        /******  Второй метод  ******/

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        Thread methodParallel1 = new Thread(() -> Calculation(a1));
        Thread methodParallel2 = new Thread(() -> Calculation(a2));

        long pStart = System.currentTimeMillis();          // Для второго метода замеряем время на:

        System.arraycopy(arr, 0, a1, 0, h);  // - разбивку массива на 2
        System.arraycopy(arr, h, a2, 0, h);

        methodParallel1.start();                           // - прогон 2х потоков параллельно
        methodParallel2.start();
        methodParallel1.join();
        methodParallel2.join();

        System.arraycopy(a1, 0, arr, 0, h);  // - склейку массивов обратно в один
        System.arraycopy(a2, 0, arr, h, h);

        long pFinish = System.currentTimeMillis();
        System.out.println("Время параллельного метода в миллисекундах: " + (pFinish - pStart));

    }
    // Метод статический и все вычисления идут внутри метода, поэтому я его НЕ помечаю как synchronized - это правильно?
    // Кстати, если этот метод синхронизировать, то параллельное выполнение занимет столько же времени,
    // сколько и однопоточное выполнение (практически).
    public static void Calculation (float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
