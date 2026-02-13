/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.iterator;


import com.github.galkinie.elenacodes.iterator.pattern.DinnerFriendsMenuIterator;
import com.github.galkinie.elenacodes.iterator.pattern.IteratorMy;

public class DinnerFriendsMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerFriendsMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("name10", "item10", true, 299);
        addItem("name10", "item10", false, 299);
        addItem("name10", "item10", false, 329);
        addItem("name10", "item10", false, 305);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full, can not add.");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    /**
     * Раскрывает внутреннюю реализацию
     */
//    public MenuItem[] getMenuItems() {
//        return menuItems;
//    }

    /**
     * create object of the class and return it
     * @return
     */
    public IteratorMy createIterator() {
        return new DinnerFriendsMenuIterator(menuItems);
    }

}
