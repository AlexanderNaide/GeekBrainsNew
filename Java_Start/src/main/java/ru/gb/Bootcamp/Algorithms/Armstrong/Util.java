package ru.gb.Bootcamp.Algorithms.Armstrong;

public class Util {

    public static final int[][] MATRIX = new int[10][11];

    static {
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                MATRIX[i][j] = (int) Math.pow(i, j);
            }
        }
    }

    static int[] split (int value, int length){
        int[] result = new int[length];
        int currentValue = value;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = currentValue % 10;
            currentValue = currentValue / 10;
        }
        return result;
    }

    static int length(int value){
        if (value < 10) {
            return 1;
        } else {
            if (value < 100){
                return 2;
            } else {
                if (value < 1_000){
                    return 3;
                } else {
                    if (value < 10_000){
                        return 4;
                    } else {
                        if (value < 100_000){
                            return 5;
                        } else {
                            if (value < 1_000_000){
                                return 6;
                            } else {
                                if (value < 10_000_000){
                                    return 7;
                                } else {
                                    if (value < 100_000_000){
                                        return 8;
                                    } else {
                                        if (value < 1_000_000_000){
                                            return 9;
                                        } else {
                                            return 10;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
