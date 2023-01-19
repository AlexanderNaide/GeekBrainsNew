package ru.gb.Bootcamp.Algorithms.Armstrong;

public class BasicAlgorithm {

    private final Logger logger = new Logger();

    public void calculate(int max){

        for (int i = 0; i < max; i++) {
            String number = String.valueOf(i);

            int length = number.length();
            String[] split = number.split("");
            int[] ints = new int[split.length];
            int result = 0;
            for (int j = 0; j < ints.length; j++) {
                result += Math.pow(Integer.parseInt(split[j]), length);
            }
            if (result == i){
//                System.out.println("Число Армстронга = " + result);
                logger.log(result);
            }

        }

    }

    public void calculateWithMatrix(int max){

        for (int i = 0; i < max; i++) {
            String number = String.valueOf(i);

            int length = number.length();
            String[] split = number.split("");
            int[] ints = new int[split.length];
            int result = 0;
            for (int j = 0; j < ints.length; j++) {
                result += Util.MATRIX[Integer.parseInt(split[j])][length];
            }
            if (result == i){
//                System.out.println("Число Армстронга = " + result);
                logger.log(result);
            }

        }

    }
}
