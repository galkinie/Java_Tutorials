package ru.oshkina.demo7;

import java.util.Optional;

public class Demo22 {

    public static void main(String[] args) {
        Cat cat = null; //допустим строку получаем по сети
        final Optional<Cat> optionalString = Optional.ofNullable(cat);
        //получаем либо строку либо ""
        final Cat cat1 = optionalString.orElse(new Cat());
        System.out.println(cat1); //"" пустая строка
    }


}
