package com.github.galkinie.javatutorials01.elenacodes.streamapi.demo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.github.galkinie.javatutorials01.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


public class Demo5 {
    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));
        String contents = new String(bytes, StandardCharsets.UTF_8);

        Stream<String> words = Pattern.compile("\\PL+").splitAsStream(contents);
    }
}
