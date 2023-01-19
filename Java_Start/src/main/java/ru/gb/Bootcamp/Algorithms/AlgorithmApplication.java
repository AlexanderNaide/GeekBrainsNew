package ru.gb.Bootcamp.Algorithms;

import java.util.Arrays;

public class AlgorithmApplication {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 1, 2, 7, 8, 4, 22, 9, 10};
//        DirectSort.sort(array);
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
//        int[] array2 = new int[]{5, 3, 9, 2, 7, 8, 4, 6, 1};
//        BubbleSort.sort(array2);
//        System.out.println(Arrays.toString(array2));

        System.out.println(BinarySearch.search(array, 24));
        System.out.println(BinarySearch.search(10, array, 0, array.length - 1));

        final BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(1);
        tree.add(7);
        tree.add(2);
        tree.add(8);
        tree.add(4);
        tree.add(9);
        tree.add(6);

        System.out.println(tree.exist(9));
        System.out.println(tree.exist(12));

        final RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.add(3);
        redBlackTree.add(1);
        redBlackTree.add(4);
        redBlackTree.add(2);
        redBlackTree.add(5);
        redBlackTree.add(6);
        redBlackTree.add(9);
        redBlackTree.add(7);
        redBlackTree.add(11);
        redBlackTree.add(10);
        redBlackTree.add(12);
        redBlackTree.add(13);
        redBlackTree.add(14);
        redBlackTree.add(15);


    }
}
