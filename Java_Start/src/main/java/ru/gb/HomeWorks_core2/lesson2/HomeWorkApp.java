package ru.gb.HomeWorks_core2.lesson2;



public class HomeWorkApp {
    public static void main(String[] args) {

        String[][] arr = new String[4][4]; // создали массив

        for (int i = 0; i < arr.length; i++) {        // заполнили массив строками
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = "" + i + j;
            }
        }

        arr[1][1] = "four"; // Закомментировать/расскоментировать для получения MyArrayDataException

        int summ;
        try {
            summ = HomeWorkMethod(arr);
            System.out.println(summ);
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
    }

    public static int HomeWorkMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        boolean checkSize = true;
        if (arr.length != 4) {
            checkSize = false;
        } else {
            for (String[] strings : arr) {
                if (strings.length != 4) {
                    checkSize = false;
                    break;
                }
            }
        }
        if (!checkSize) {
            throw new MyArraySizeException();
        }
        int summ = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return summ;
    }
}
