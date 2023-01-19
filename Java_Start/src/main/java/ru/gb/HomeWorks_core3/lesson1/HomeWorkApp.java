package ru.gb.HomeWorks_core3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {

        /**
         * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
         */
        System.out.println("\n\n-------start 1-------");

        String[] arrayString = {"Кафе", "Кино", "Боулинг"};
        System.out.println(Arrays.toString(arrayString));
        replacingElement(arrayString, 1, 2);
        System.out.println(Arrays.toString(arrayString));

        Integer[] arrayInt = {9, 5, 7};
        System.out.println(Arrays.toString(arrayInt));
        replacingElement(arrayInt, 1, 2);
        System.out.println(Arrays.toString(arrayInt));


        /**
         * 2. Написать метод, который преобразует массив в ArrayList;
         */
        System.out.println("\n\n-------start 2-------");

        ArrayList<String> listString = conversionToArrayList(arrayString);
        System.out.println(listString);
        ArrayList<Integer> listInt = conversionToArrayList(arrayInt);
        System.out.println(listInt);


        /**
         * 3. Большая задача.
         */
        System.out.println("\n\n-------start 3-------");

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        System.out.printf("Колличество фруктов в коробке с яблоками: %d, коробка имеет вес: %.2f.\n", appleBox.getList().size(), appleBox.getWeight());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.printf("Колличество фруктов в коробке с аппельсинами: %d, коробка имеет вес: %.2f.\n", orangeBox.getList().size(), orangeBox.getWeight());
        System.out.println("Результат сравнения: " + appleBox.compare(orangeBox));
        orangeBox.addFruit(new Orange());
        System.out.printf("Теперь колличество фруктов в коробке с аппельсинами: %d, коробка имеет вес: %.2f.\n", orangeBox.getList().size(), orangeBox.getWeight());
        System.out.println("Результат сравнения: " + appleBox.compare(orangeBox));
        Box<Orange> orangeBoxNew = new Box<>();
//        appleBox.pourOver(orangeBoxNew); // - яблоки в новую коробку для аппельсинов не пересыпать.

        orangeBox.pourOver(orangeBoxNew); // Берем коробку, которую собрались пересыпать, а в параметрах указываем "Куда" пересыпаем.
        System.out.printf("В первой коробке осталось %d фруктов, а во второй их стало %d.\n", orangeBox.getList().size(), orangeBoxNew.getList().size());

    }

    public static <T> void replacingElement(T[] array, int a, int b) { // 1. Метод меняет два элемента массива местами.
        T t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public static <T> ArrayList<T> conversionToArrayList(T[] array) { // 2. Метод преобразует массив в ArrayList.
        ArrayList<T> list = new ArrayList<>(array.length + 1); // Ну вдруг массив придет очень большим - сразу сэкономим на перезаписи.
        list.addAll(Arrays.asList(array));
        return list;
    }
}
