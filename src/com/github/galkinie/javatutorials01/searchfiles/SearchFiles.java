/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 * <a href="https://youtu.be/OaltzA7uCRY">https://youtu.be/OaltzA7uCRY</a>
 */
package com.github.galkinie.javatutorials01.searchfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles {

    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        measureTime(()-> searchFiles(fileList));
    }

    private static void searchFiles(ArrayList<File> fileList) {
//        getFiles(new File("D:\\"), fileList);
        getFiles(new File("/home/disco/Downloads/english new 1/"), fileList);
        for(File file: fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void getFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("searching: " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file: directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList);
                    } else {
//                        if (file.getName().toLowerCase().endsWith(".jpg")) {
                        if (file.getName().toLowerCase().endsWith(".mp4")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }
}
//java -javaagent:/home/disco/idea-IU-253.29346.240/lib/idea_rt.jar=43561 -Dfile.encoding=UTF-8 -classpath /home/disco/IdeaProjects/java_tutorials/out/production/java_tutorials com.github.galkinie.javatutorials01.searchfiles.SearchFiles
//searching: /home/disco/Downloads/english new 1
/// home/disco/Downloads/english new 1/Pressure- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Djoghurt- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Bård's speach and Massachusetts- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Trucker's Hitch, Djoghurt & Fooling around.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Pressure.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal Soundcheck Stonehenge.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Massachusetts.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Vegard fooling around.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Shabby Chic.mp4
/// home/disco/Downloads/english new 1/Bård's speach and Jeg heter Finn- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Work it- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck Sammen Finner Vi Frem.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck The Cabin 2.mp4
/// home/disco/Downloads/english new 1/Ylvis in Mandal soundcheck The Cabin.mp4
/// home/disco/Downloads/english new 1/Intolerant- Ylvis in Stockholm live.mp4
/// home/disco/Downloads/english new 1/Ylvis in Sandefjord Bård speech & Jeg heter Finn.mp4
//Затраченное время: 185 ms
//
//Process finished with exit code 0

