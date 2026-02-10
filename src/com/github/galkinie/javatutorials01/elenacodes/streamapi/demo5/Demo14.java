package ru.oshkina.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo14 {

    public static void main(String[] args) {
        final Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
        //получается следующий поток данных ["H", "e", "l", "l", "o", "W", "o", "r", "l", "d"]
    }

    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
