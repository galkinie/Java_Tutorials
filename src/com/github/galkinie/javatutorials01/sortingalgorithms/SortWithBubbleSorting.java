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
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
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
//java -javaagent:/home/disco/idea-IU-253.29346.240/lib/idea_rt.jar=39519 -Dfile.encoding=UTF-8 -classpath /home/disco/IdeaProjects/java_tutorials/out/production/java_tutorials com.github.galkinie.javatutorials01.sortingalgorithms.SortWithBubbleSorting
//[16, 24, 32, 36, 41, 42, 42, 53, 55, 57, 64, 73, 74]
//Затраченное время: 1 ms
//
//Process finished with exit code 0
