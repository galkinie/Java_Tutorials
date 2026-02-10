package com.github.galkinie.javatutorials01.elenacodes.streamapi.demo4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.github.galkinie.javatutorials01.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


/**
 * Допустим у нас есть метод, возвращающий не одно значение, а поток значений.
 * Например, в результате вызова letters("boat") образуется поток данных ["b", "o", "a", "t"]
 */
public class Demo11 {
    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Передаем метод letters() в метод flatMap() для преобразования потока символьных строк
        final Stream<String> flatResult = words
                .stream()
                .flatMap(Demo11::letters);//вызываем метод letters() для каждого слова и сводим результаты

        // [д, о, л, л, а, р, С, Ш, А, с, л, е, г, к, а]

    }

    /**
     * Данный метод можно реализовать намного
     * изящнее с помощью IntStream.rage()
     */
    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
