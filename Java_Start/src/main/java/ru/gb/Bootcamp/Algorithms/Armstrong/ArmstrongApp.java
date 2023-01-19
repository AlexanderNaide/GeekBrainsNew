package ru.gb.Bootcamp.Algorithms.Armstrong;

public class ArmstrongApp {
    public static void main(String[] args) {
        warmup();
        Logger.show = true;
//        System.out.println("String algorithm");
//        new BasicAlgorithm().calculate(10_000_000);
//        System.out.println("String algorithm with Matrix");
//        new BasicAlgorithm().calculateWithMatrix(10_000_000);
        System.out.println("Integer algorithm");
        new IntAlgorithm().calculate(10_000_000);
        System.out.println("Integer algorithm with Matrix");
        new IntAlgorithm().calculateWithMatrix(10_000_000);
        System.out.println("Integer ArrayAlgorithm");
        new ArrayAlgorithm().arrayCalculateWithMatrix(Integer.MAX_VALUE);

    }

    private static void warmup(){
        for (int i = 0; i < 100; i++) {
//            new BasicAlgorithm().calculate(100_000);
            new IntAlgorithm().calculate(100_000);
            new IntAlgorithm().calculateWithMatrix(100_000);
            new ArrayAlgorithm().arrayCalculateWithMatrix(100_000);
        }
    }
}
