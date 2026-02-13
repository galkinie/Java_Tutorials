/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.iterator.pattern;


import com.github.galkinie.elenacodes.iterator.DinnerFriendsMenu;
import com.github.galkinie.elenacodes.iterator.PancakeHouseMenu;

public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerFriendsMenu dinnerFriendsMenu = new DinnerFriendsMenu();

        Waiter waiter = new Waiter(pancakeHouseMenu, dinnerFriendsMenu);
        waiter.printMenu();
    }
}
//Morning:
//name1
//item1
//299.0
//true
//name2
//item2
//299.0
//false
//name3
//item3
//349.0
//true
//name4
//item4
//359.0
//true
//
//Midday or evening:
//name10
//item10
//299.0
//true
//name10
//item10
//299.0
//false
//name10
//item10
//329.0
//false
//name10
//item10
//305.0
//false
