package com.github.galkinie.elenacodes.streamapi.demo6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.github.galkinie.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


public class Demo21AnyMatch {

    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //Если требуется только выяснить, имеется ли вообще совпадение,
        // то следует воспользоваться методом anyMatch()
        final boolean anyMatch = words
                .stream()
                .anyMatch(s -> s.startsWith("с"));//принимает предикатный аргумент, поэтому не нуждается в filter()
        System.out.println(anyMatch); //true
    }

    //также есть allMatch(), noneMatch(), возвращающие логическое значение true, если с предикатом совпадают все элементы
    //в потоке данных или не совпадает ни один из его элементов. Их также выгодно использовать в параллельном режиме =)
}

