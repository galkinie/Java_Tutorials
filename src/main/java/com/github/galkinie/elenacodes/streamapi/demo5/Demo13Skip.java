package com.github.galkinie.elenacodes.streamapi.demo5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.github.galkinie.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


public class Demo13Skip {

    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов и пропуск первой пустой строки

        /**
         * Returns a stream consisting of the remaining elements of this stream
         * after discarding the first n elements of the stream. If this stream
         * contains fewer than n elements then an empty stream will be returned.
         */
        final Stream<String> skip = Stream.of(contents.split("\\PL+")).skip(1);

    }
}
