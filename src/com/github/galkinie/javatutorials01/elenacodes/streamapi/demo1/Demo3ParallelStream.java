package com.github.galkinie.javatutorials01.elenacodes.streamapi.demo1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.github.galkinie.javatutorials01.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


/**
 * Нам нужно подсчитать все длинные слова в книге
 */
public class Demo3ParallelStream {
    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Осуществляем преобразования с помощью потоков данных
        long count = words.parallelStream() //stream() -> parallelStream()
                .filter(w -> w.length() > 12)
                .count();

        System.out.println(count);
    }
}
//1