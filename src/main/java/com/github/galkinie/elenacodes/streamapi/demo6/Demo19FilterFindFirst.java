package com.github.galkinie.elenacodes.streamapi.demo6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.github.galkinie.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


public class Demo19FilterFindFirst {

    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Поиск первого слова, начинающегося с буквы "Q"
        final Optional<String> startWithQ = words
                .stream()
                .filter(s -> s.startsWith("Q"))
                .findFirst();


        System.out.println("startWithQ: " + startWithQ.orElse("ничего не нашлось"));
        final Optional<String> startWith1 = words
                .stream()
                .filter(s -> s.startsWith("М"))
                .findFirst();
        System.out.println("startWith1: " + startWith1.orElse("ничего не нашлось"));
        //startWithQ: ничего не нашлось
        //startWith1: Московской

    }





}

