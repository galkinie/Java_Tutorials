/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.iterator.pattern;


import com.github.galkinie.elenacodes.iterator.MenuItem;

public class DinnerFriendsMenuIterator implements IteratorMy {

    MenuItem[] items;
    int position;

    public DinnerFriendsMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        /**
         * written differently
         */
        return position < items.length && items[position] != null;
//        if (position >= items.length || items[position] == null) {
//            return false;
//        }
    }

    @Override
    public MenuItem next() {
        MenuItem item = items[position];
        position++;
        return item;
    }
}
