package com.github.galkinie.elenacodes.streamapi.demo7;

import java.util.Optional;

public class Demo22ObtainOptional {

    public static void main(String[] args) {
        ObjectEmpty objectEmpty = null; //допустим строку получаем по сети
        final Optional<ObjectEmpty> optionalString = Optional.ofNullable(objectEmpty);
        //получаем либо строку, либо ""
        final ObjectEmpty objectEmpty1 = optionalString.orElse(new ObjectEmpty());
        System.out.println(objectEmpty1); //"" пустая строка
    }


}
