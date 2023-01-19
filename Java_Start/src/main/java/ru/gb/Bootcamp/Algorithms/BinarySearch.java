package ru.gb.Bootcamp.Algorithms;

public class BinarySearch {

    public static int search (int value, int[] array, int min, int max){
        int midpoint;
        if (max < min){
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }
        if (array[midpoint] < value){
            return search(value, array, midpoint + 1, max);
        } else if (array[midpoint] > value){
            return search(value, array, min, midpoint - 1);
        } else {
            return midpoint;
        }
    }

    public static int search (int[] array, int value){
        if (array.length == 0){
            return -1;
        }

        int position = 0;
        int step = array.length;
        int positionValue = array[position];
        do {
            step = Math.max(step / 2, 1);
            if (positionValue < value) {
                position = Math.min(position + step, array.length - 1);
            } else if (positionValue > value){
                position = Math.max(position - step, 0);
            }
            int previousPositionValue = positionValue;
            positionValue = array[position];
            if (positionValue == value) {
                return position;
            }
            if (step == 1){
                if (previousPositionValue > value && positionValue < value){
                    return -1;
                }
                if (previousPositionValue < value && positionValue > value){
                    return -1;
                }
                if (position == array.length - 1 && value > positionValue){
                    return -1;
                }
                if (position == 0 && value < positionValue){
                    return -1;
                }
            }
        } while (true);
    }
}
