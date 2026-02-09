/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.immutableclasses;


import java.util.ArrayList;
import java.util.List;

public final class ImmutableWithMutableCollection {
    private  final int id;
    private  final List<String> mutableList;

    static void main() {
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        ImmutableWithMutableCollection immutableWithMutableCollection =
                new ImmutableWithMutableCollection(1, list);
        System.out.println("id = " + immutableWithMutableCollection.getId());
        System.out.println("list = " + immutableWithMutableCollection.getMutableList());

        //попытка изменить вернувшуюся копию списка
        List<String> retrievedList = immutableWithMutableCollection.getMutableList();
        retrievedList.add("item3");
        System.out.println("retrievedList: " + retrievedList);

        //изменился ли внутренний список
        System.out.println("Result: ");
        System.out.println(immutableWithMutableCollection.getMutableList());
        //id = 1
        //list = [item1, item2]
        //retrievedList: [item1, item2, item3]
        //Result:
        //[item1, item2]

    }

    public ImmutableWithMutableCollection(int id, List<String> mutableList) {
        this.id = id;
        /**
         * Для того чтобы сделать нашу коллекцию неизменяемой, мы
         * не копируем ссылку, а создаём новый экземпляр.
         * Мы создаём копию переданной коллекции. - Это предотвращает
         * возможность изменения исходной коллекции извне.
         */
        // this.mutableList = mutableList;
        // изменение mutableList повлияет на изменение коллекции
        // который является полем конкретного экземпляра нашего класса,
        // a defensive copy предотвращает эту ситуацию, и мы
        // создали независимую копию коллекции.
        this.mutableList = new ArrayList<>(mutableList);
    }

    public int getId() {
        return id;
    }

    /**
     * And, here is a problem, too.
     * Если мы оставляем 'return mutableList;' - то внешние объекты смогут
     * изменить содержимое нашей коллекции, и это нарушит принцип Immutableness.
     * Нам нужно попробовать вернуть копию коллекции, 'new ArrayList<>(mutableList)'
     */
    public List<String> getMutableList() {
//        return mutableList;
        return new ArrayList<>(mutableList);
    }
}
