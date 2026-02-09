package com.github.galkinie.javatutorials01.iteratoranditerable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class MainIteration1 {
    public static void main(String[] args) {

        Integer[] array = new Integer[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        Collections.addAll(list, array);
        Collections.addAll(list2, array);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();

        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) +", ");
        }
        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        for (Integer integer: list) {
            System.out.print(integer + ", ");
        }
    }
}
