package ru.gb.HomeWorks_core3.lesson6;

public class HomeWork6 {
    public Integer[] arrayAfterFour(Integer[] arr) {
        Integer[] result;
        int pos = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                pos = i;
                break;
            }
            if (arr[i] != 4 && i == 0) {
                throw new RuntimeException();
            }
        }
        result = new Integer[arr.length - pos - 1];
        for (int i = pos + 1, j = 0; i < arr.length; i++, j++) {
            result[j] = arr[i];
        }

        return result;
    }

    public boolean containsOneAndFour(Integer[] arr) {
        boolean one = false;
        boolean four = false;

        for (Integer integer : arr) {
            if (integer == 1) {
                one = true;
            } else if (integer == 4) {
                four = true;
            } else {
                throw new RuntimeException();
                /**
                 * Мне не совсем понятно по заданию: может ли массив содержать
                 * другие числа, кроме 1 и 4 или не может.
                 * Решил для себя, что не может и слегка усложнил выбрасыванием
                 * RuntimeException если число отличается от 1 и 4.
                 * Тут прошу строго не судить - Переделать можно как угодно
                 * в зависимости от ТЗ)
                 */
            }
        }

        return one && four;
    }
}
