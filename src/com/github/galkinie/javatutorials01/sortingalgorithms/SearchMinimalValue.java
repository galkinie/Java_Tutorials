/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 * <a href="https://youtu.be/J8CbZYnJ5O8">https://youtu.be/J8CbZYnJ5O8</a>
 */
package com.github.galkinie.javatutorials01.sortingalgorithms;


public class SearchMinimalValue {
    public static void main(String[] args) {
        int [] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        measureTime(() -> searchMinimalValue(array));

    }

    private static void searchMinimalValue(int[] array) {
        int minValue = array[0];
        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("min value= " + minValue);
        System.out.println("min index= " + minIndex);
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}
//java -javaagent:/home/disco/idea-IU-253.29346.240/lib/idea_rt.jar=40307
// -Dfile.encoding=UTF-8 -classpath /home/disco/IdeaProjects/java_tutorials/out/production/java_tutorials
// com.github.galkinie.javatutorials01.sortingalgorithms.SearchMinimalValue
//min value= 16
//min index= 6
//Затраченное время: 39 ms
//
//Process finished with exit code 0