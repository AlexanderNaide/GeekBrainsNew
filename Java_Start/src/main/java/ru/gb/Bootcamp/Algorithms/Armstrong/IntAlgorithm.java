package ru.gb.Bootcamp.Algorithms.Armstrong;

public class IntAlgorithm {

    private final Logger logger = new Logger();

    public void calculate(int max){

        for (int i = 0; i < max; i++) {
            int length = Util.length(i);
            int[] split = Util.split(i, length);
            int result = 0;
            for (int j = 0; j < split.length; j++) {
                result += Math.pow(split[j], length);
            }
            if (result == i){
                logger.log(result);
            }
        }
    }

    public void calculateWithMatrix(int max){

        for (int i = 0; i < max; i++) {
            int length = Util.length(i);
            int[] split = Util.split(i, length);
            int result = 0;
            for (int j = 0; j < split.length; j++) {
                result += Util.MATRIX[split[j]][length];
            }
            if (result == i){
                logger.log(result);
            }
        }
    }

}
