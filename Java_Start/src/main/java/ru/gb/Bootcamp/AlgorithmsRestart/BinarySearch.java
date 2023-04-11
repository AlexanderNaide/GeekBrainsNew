package ru.gb.Bootcamp.AlgorithmsRestart;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Search(array, 3));
        System.out.println(Search(array, 3, 0, array.length - 1));

    }

    public static int Search(int[] array, int value, int min, int max){
        int midpoint;
        if(max < min){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value){
            return Search(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value){
                return Search(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }

    }

    public static int Search(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int position = 0;
        int step = array.length;
        int positionValue = array[position];
        do {
            step = Math.max(step / 2, 1);
            if (positionValue < value) {
                position = Math.min(position + step, array.length - 1);
            } else if (positionValue > value) {
                position = Math.max(position - step, 0);
            }
            int previousPositionValue = positionValue;
            positionValue = array[position];
            if (positionValue == value) {
                return position;
            }
            if (step == 1) {
                if (previousPositionValue > value && positionValue < value) {
                    return -1;
                }
                if (previousPositionValue < value && positionValue > value) {
                    return -1;
                }
                if (previousPositionValue == positionValue) {
                    return -1;
                }
            }

        } while (true);
    }
}
