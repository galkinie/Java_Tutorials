/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.immutableclasses;


import java.util.Date;

/**
 * объявлен как final чтобы предотвратить наследование,
 * никто не сможет измениить поведение класса создав подкласс
 */
public final class ImmutableWithMutableFields {
    static void main() throws InterruptedException {
        ImmutableWithMutableFields immutableWithMutableFields = new ImmutableWithMutableFields(1, new Date());
        System.out.println(immutableWithMutableFields);
        Thread.sleep(3000);
        System.out.println(immutableWithMutableFields);
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:29 KRAT 2026}
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:29 KRAT 2026}

        System.out.println();
        ImmutableWithMutableFields immutableWithMutableFields1 = new ImmutableWithMutableFields(1, new Date());
        System.out.println(immutableWithMutableFields1);
        Thread.sleep(1000);
        System.out.println(immutableWithMutableFields1);
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:32 KRAT 2026}
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:32 KRAT 2026}

        System.out.println();
        ImmutableWithMutableFields immutableWithMutableFields2 = new ImmutableWithMutableFields(1, new Date());
        System.out.println(immutableWithMutableFields2);
        Thread.sleep(1000);
        System.out.println(immutableWithMutableFields2);
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:33 KRAT 2026}
        //ImmutableWithMutableFields{id=1, date=Sun Feb 08 21:41:33 KRAT 2026}



    }

    /**
     * Поля объявлены как private и final, это означает, что
     * они могут быть установлены только один раз, и
     * их нельзя изменить после создания объекта.
     */
    private final int id;
    private final Date date;

    public ImmutableWithMutableFields(int id, Date date) {
        this.id = id;
        /**
         * В конструкторе создаётся защитная копия defensive copy
         * изменяемого объекта.
         * В 'new Date(date.getTime())' создаём защитную копию
         * переданного объекта 'date', и этим мы предотвращаем
         * возможность изменения переданного объекта 'date' извне
         */
        this.date = new Date(date.getTime());
    }

    /**
     * У нас отсутствуют методы, которые изменяют состояние переданного объекта.
     * У нас отсутствуют Setters и другие методы, которые позволят изменить
     * состояние объекта после того, как он создан.
     *
     */
    public int getId() {
        return id;
    }

    /**
     *  Есть некоторая уязвимость.
     *  getDate() возвращает значение поля date.
     *  Возвращается ссылка на внутренний объект date.
     *  Это потенциальная уязвимость и лучше возвращать копию объекта date.
     *  Лучше возвращать 'new Date(date.getTime())' для того,
     *  чтобы не допустить изменение нашего объекта извне.
     */
    public Date getDate() {
//        return date;
        return new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableWithMutableFields{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
