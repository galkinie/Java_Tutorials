package ru.oshkina.demo5;

import java.util.stream.Stream;

public class Demo12 {

    public static void main(String[] args) {
        final Stream<Double> limit = Stream.generate(Math::random).limit(100);
    }
}
