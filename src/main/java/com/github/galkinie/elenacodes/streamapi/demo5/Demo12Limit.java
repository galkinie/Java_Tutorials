package com.github.galkinie.elenacodes.streamapi.demo5;

import java.util.stream.Stream;

public class Demo12Limit {

    public static void main(String[] args) {
        final Stream<Double> limit = Stream.generate(Math::random).limit(10);

    }
}
