package com.github.galkinie.elenacodes.streamapi.demo7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo25_02 {

    public static void main(String[] args) {
        final List<String> results = new ArrayList<>();

        Optional<String> optionalValue = evaluate(50);

        optionalValue.ifPresent(x -> results.add(x));

        System.out.println(results);
        //[]

        optionalValue = evaluate(101);
        final Optional<Boolean> added = optionalValue
                /**
                 * this map() is from Stream API, not from Optional
                 */
                .map(results::add);
        System.out.println(results);
        //[Ok]

    }

    public static Optional<String> evaluate(int value) {
        if (value > 100) {
            return Optional.of("Ok");
        } else {
            return Optional.ofNullable(null);
        }
    }

}
