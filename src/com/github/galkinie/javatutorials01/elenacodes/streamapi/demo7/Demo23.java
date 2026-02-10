package ru.oshkina.demo7;

import java.util.Optional;

public class Demo23 {

    public static void main(String[] args) {
        String data = null;
        final Optional<String> optionalString = Optional.ofNullable(data);

        final String result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println("Результат=" + result);
    }
}
