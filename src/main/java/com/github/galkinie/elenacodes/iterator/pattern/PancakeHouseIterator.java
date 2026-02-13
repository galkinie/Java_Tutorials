/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.iterator.pattern;


import com.github.galkinie.elenacodes.iterator.MenuItem;

import java.util.List;

public class PancakeHouseIterator implements IteratorMy {
    List<MenuItem> items;
    int position = 0;

    public PancakeHouseIterator(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size() && items.get(position) != null;
//        if (position > items.size() || items.get(position) == null) {
//            return false;
//        } else {
//            return true;
//        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}
