package ru.oshkina.demo5;

import java.util.stream.Stream;

public class Demo15 {

    public static void main(String[] args) {
        final Stream<String> distinct = Stream.of("Hello", "Hello", "Hello", "world").distinct();
        System.out.println(distinct.count()); // 2
    }
}
