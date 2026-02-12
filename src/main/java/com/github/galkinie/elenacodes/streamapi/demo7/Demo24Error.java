package com.github.galkinie.elenacodes.streamapi.demo7;

import java.util.Optional;

public class Demo24Error {

    public static void main(String[] args) {
        String data = null;
//        String data = "Hello";
        final Optional<String> optionalString = Optional.ofNullable(data);

        final String result = optionalString.orElseThrow(IllegalStateException::new);
        System.out.println("Результат=" + result);
        //Exception in thread "main" java.lang.IllegalStateException
        //	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
        //	at com.github.galkinie.elenacodes.streamapi.demo7.Demo24.main(Demo24.java:12)
    }



}
