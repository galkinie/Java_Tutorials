package com.github.galkinie.javatutorials01.elenacodes.streamapi.demo2;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static com.github.galkinie.javatutorials01.elenacodes.streamapi.Constants.PATH_TO_DEMO_TXT_FILE;


//Создание потока данных
public class Demo4 {
    public static void main(String[] args) throws IOException {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get(PATH_TO_DEMO_TXT_FILE));
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //метод split() возвращает массив типа String[]
        Stream<String> words = Stream.of(contents.split("\\PL+"));

        //У метода of() имеются аргументы переменной длины, поэтому поток данных можно построить
        // из любого количества аргументов, как показано выше
        //Также можем создать поток данных из части массива Arrays.stream(array, from, to)

        //Чтобы создать поток данных без элементов -> вызов статического метода Stream.empty()

        final Stream<String> empty = Stream.empty();
        Stream<String> empty2 = Stream.<String>empty();

        //Для создания бесконечных потоков данных в интерфейсе Stream есть два статических метода
        Stream<String> echos = Stream.generate(() -> "Echo");

        //Поток случайных чисел
        Stream<Double> randoms = Stream.generate(Math::random); //Math::random
        Stream<Double> randoms1 = Stream.generate(() -> Math.random()); //Math::random

        //Для получения бесконечной последовательности типа 0 1 2 3 4 ... есть метод iterate()
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }
}
