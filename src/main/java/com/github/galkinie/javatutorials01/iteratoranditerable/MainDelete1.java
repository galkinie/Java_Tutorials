package com.github.galkinie.javatutorials01.iteratoranditerable;

import java.util.LinkedList;
import java.util.ListIterator;

public class MainDelete1 {

    public static void main(String[] args) {
        LinkedList<Integer> list = getRandomList();

        /** better */
        list.removeIf(item -> item >= 128);
        for (Integer integer: list) {
            System.out.print(integer + ", ");
        }
        System.out.println();

        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            if (item >= 50) {
                iterator.remove();
            }
        }

        for (Integer integer: list) {
            System.out.print(integer + ", ");
        }
    }

    public static LinkedList<Integer> getRandomList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) Math.round(Math.random() * 256));
        }
        return list;
    }
}
//96, 10, 16, 38, 15, 75, 44, 68, 1, 116, 84, 45, 114, 103, 70, 58, 95, 30, 100, 3, 59, 11, 97, 25, 17, 75, 19, 1,
// 85, 48, 116, 127, 71, 2, 102, 14, 38, 91, 84, 44, 75, 78, 115, 108, 123, 47, 119, 111, 34, 51, 101,

//10, 16, 38, 15, 44, 1, 45, 30, 3, 11, 25, 17, 19, 1, 48, 2, 14, 38, 44, 47, 34,