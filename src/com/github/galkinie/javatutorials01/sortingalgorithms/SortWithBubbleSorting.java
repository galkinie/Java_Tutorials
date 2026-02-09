/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 * <a href="https://youtu.be/aXyMkR8LGEo">https://youtu.be/aXyMkR8LGEo</a>
 */
package com.github.galkinie.javatutorials01.sortingalgorithms;

public class SortWithBubbleSorting {

    public static void main(String[] params) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        measureTime(() -> bubbleSort(array));

    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) { //64>42
                    int tmp = array[i]; //tmp=42
                    array[i] = array[i - 1]; //42:=64
                    array[i - 1] = tmp; //64:=tmp=42
                    isSorted = false;
                    System.out.println("i=" + i + ", " + array[i-1] + ", " + array[i]);
                }

            }
            System.out.println();
        }
        System.out.println(arrayToString(array));
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}
//i=1, 42, 64
//i=3, 41, 73
//i=4, 32, 73
//i=5, 53, 73
//i=6, 16, 73
//i=7, 24, 73
//i=8, 57, 73
//i=9, 42, 73
//i=11, 55, 74
//i=12, 36, 74
//
//i=2, 41, 64
//i=3, 32, 64
//i=4, 53, 64
//i=5, 16, 64
//i=6, 24, 64
//i=7, 57, 64
//i=8, 42, 64
//i=10, 55, 73
//i=11, 36, 73
//
//i=1, 41, 42
//i=2, 32, 42
//i=4, 16, 53
//i=5, 24, 53
//i=7, 42, 57
//i=9, 55, 64
//i=10, 36, 64
//
//i=1, 32, 41
//i=3, 16, 42
//i=4, 24, 42
//i=6, 42, 53
//i=8, 55, 57
//i=9, 36, 57
//
//i=2, 16, 41
//i=3, 24, 41
//i=8, 36, 55
//
//i=1, 16, 32
//i=2, 24, 32
//i=7, 36, 53
//
//i=6, 36, 42
//
//i=5, 36, 42
//
//i=4, 36, 41
//
//
//[16, 24, 32, 36, 41, 42, 42, 53, 55, 57, 64, 73, 74]
//Затраченное время: 44 ms
