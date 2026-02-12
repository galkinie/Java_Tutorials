package com.github.galkinie.elenacodes.streamapi.demo5;

import java.io.IOException;
import java.util.stream.Stream;


public class Demo17Peek {

    public static void main(String[] args) throws IOException {
        final Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray(); //terminal method that makes this stream an array of objects
    }
}
//Fetching 1.0
//Fetching 2.0
//Fetching 4.0
//Fetching 8.0
//Fetching 16.0
//Fetching 32.0
//Fetching 64.0
//Fetching 128.0
//Fetching 256.0
//Fetching 512.0
//Fetching 1024.0
//Fetching 2048.0
//Fetching 4096.0
//Fetching 8192.0
//Fetching 16384.0
//Fetching 32768.0
//Fetching 65536.0
//Fetching 131072.0
//Fetching 262144.0
//Fetching 524288.0

