package ru.oshkina.demo7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo25 {
    public static void main(String[] args) {
        Optional<String> optionalValue = evaluate(50);
        final int length = optionalValue.get().length();

        final String s = evaluate2(50);
        s.length();
    }

    public static Optional<String> evaluate(int value) {
        if (value > 100) {
            return Optional.of("Ok");
        } else {
            return Optional.ofNullable(null);
        }
    }

    public static String evaluate2(int value) {
        if (value > 100) {
            return "Ok";
        } else {
            return null;
        }
    }
}
