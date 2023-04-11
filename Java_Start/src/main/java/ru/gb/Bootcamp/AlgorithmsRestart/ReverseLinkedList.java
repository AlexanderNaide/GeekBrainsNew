package ru.gb.Bootcamp.AlgorithmsRestart;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Домашнее задание
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("element " + (i + 1));
        }
        System.out.println(list);
        System.out.println(reverseLinkedListForIterator(list));
        System.out.println(list);
        System.out.println(reverseLinkedListForCycle(list));

        System.out.println("\n\n через Collections");
        System.out.println(list);
        reverseLinkedListForCollection(list);
        System.out.println(list);

    }

    //        Через итератор
    public static LinkedList<String> reverseLinkedListForIterator(LinkedList<String> list){
        Iterator<String> iterator = list.descendingIterator();
        LinkedList<String> returnList = new LinkedList<>();
        while (iterator.hasNext()){
            returnList.add(iterator.next());
        }
        return returnList;
    }

    //        Через цикл (вполовину короче)
    public static LinkedList<String> reverseLinkedListForCycle(LinkedList<String> list){
        for (int i = 0; i < list.size() / 2; i++) {
            String temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
        return list;
    }

    public static void reverseLinkedListForCollection(LinkedList<String> list){
        Collections.reverse(list);
    }

}
