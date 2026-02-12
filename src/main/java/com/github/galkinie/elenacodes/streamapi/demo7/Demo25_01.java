package com.github.galkinie.elenacodes.streamapi.demo7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo25_01 {

    public static void main(String[] args) {
        String value = "Hello";

        final List<String> results = new ArrayList<>();

        final Optional<String> optionalValue = Optional.ofNullable(value);

        optionalValue.ifPresent(x -> results.add(x));

        Optional<Boolean> added = optionalValue.map(results::add);

        System.out.println(results); //[Hello, Hello]

    }


}
