package com.github.galkinie.elenacodes.streamapi.demo5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.github.galkinie.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


public class Demo16 {

    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //метод sorted() выдает новый поток данных, элементы которого пораждаются
        // из исходного поттока и располагаются в отсортированном порядке
        final Stream<String> sorted = words
                .stream()
                .sorted(Comparator.comparing(String::length).reversed());
    }
}

