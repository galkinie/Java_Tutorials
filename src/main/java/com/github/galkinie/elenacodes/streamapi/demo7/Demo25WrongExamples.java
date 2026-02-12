package com.github.galkinie.elenacodes.streamapi.demo7;

import java.util.Optional;

public class Demo25WrongExamples {
    public static void main(String[] args) {
        Optional<String> optionalValue = evaluate(50);
        /**
         * неправильное использование
         */
        final int length = optionalValue.get().length();

        final String s = evaluate2(50);
        s.length();
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null
        //	at com.github.galkinie.elenacodes.streamapi.demo7.Demo25.main(Demo25.java:16)
    }

    /**
     * возвращает optional
     */
    public static Optional<String> evaluate(int value) {
        if (value > 100) {
            return Optional.of("Ok");
        } else {
            return Optional.ofNullable(null);
        }
    }

    /**
     * не возвращает optional
     */
    public static String evaluate2(int value) {
        if (value > 100) {
            return "Ok";
        } else {
            return null;
        }
    }
}
