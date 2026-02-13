package com.github.galkinie.elenacodes.iterator.pattern;

import com.github.galkinie.elenacodes.iterator.MenuItem;

public interface IteratorMy {
    /**
     *
     * @return true if there are elements in collection
     */
    boolean hasNext();

    /**
     *
     * @return next element
     */
    MenuItem next();
}
