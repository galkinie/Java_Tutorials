/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package ru.arhiser.minimal;


public class Minimal {
    public static void main(String[] args) {
        int [] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        int minValue = array[0];
        int minIndex = 0;

        for (int i=0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("min value= " + minValue);
        System.out.println("min index= " + minIndex);

    }
}

//~/jdk-11.0.29/bin/java -javaagent:~/idea-IU-253.29346.240/lib/idea_rt.jar=35931 -Dfile.encoding=UTF-8
// -classpath ~/IdeaProjects/java_tutorials/out/production/java_tutorials ru.arhiser.minimal.Minimal
//min value= 16
//min index= 6
//
//Process finished with exit code 0