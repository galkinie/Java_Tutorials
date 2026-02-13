/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.iterator.pattern;


import com.github.galkinie.elenacodes.iterator.DinnerFriendsMenu;
import com.github.galkinie.elenacodes.iterator.MenuItem;
import com.github.galkinie.elenacodes.iterator.PancakeHouseMenu;

public class Waiter {
    PancakeHouseMenu pancakeHouseMenu;
    DinnerFriendsMenu dinnerFriendsMenu;

    public Waiter(PancakeHouseMenu pancakeHouseMenu, DinnerFriendsMenu dinnerFriendsMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerFriendsMenu = dinnerFriendsMenu;
    }

    /**
     *  Метод без аргументов
     */
    public void printMenu() {
        IteratorMy pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        IteratorMy dinnerFriendsMenuIterator = dinnerFriendsMenu.createIterator();

        System.out.println("Morning: ");
        printMenu(pancakeHouseMenuIterator);

        System.out.println();
        System.out.println("Midday or evening: ");
        printMenu(dinnerFriendsMenuIterator);
    }

    /**
     *  Перегрузка метода с приёмом аргументов
     */
    public void printMenu(IteratorMy iteratorMy) {
        while (iteratorMy.hasNext()) {
            MenuItem item = iteratorMy.next();
            System.out.println(item.getName());
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            System.out.println(item.isVegetarian());
        }
    }

}
