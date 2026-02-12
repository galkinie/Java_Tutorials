/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.nullsafety;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NullSafety01 {
    public static void main(String[] args) {
        NullSafetyClient client = null;

        /**
         * Produces error
         * Exception in thread "main" java.lang.NullPointerException
         * 	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.main(NullSafety01.java:11)
         */
//        client.setName("aaa");

        if (client != null) {
            client.setName("aaa");
        }
        System.out.println(client); //null

//        setName(client,"bbb");
        //Exception in thread "main" java.lang.IllegalArgumentException:
        // Argument for @NotNull parameter 'client' of
        // com/github/galkinie/javatutorials01/nullsafety/NullSafety01.setName must not be null
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.$$$reportNull$$$0(NullSafety01.java)
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.setName(NullSafety01.java)
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.main(NullSafety01.java:25)

        /**
         * Another situation
         * 'final' can be added
         */
        final NullSafetyClient client1 = new NullSafetyClient("aaa", 20, true);
        /** intentionally or accidentally */
        //client1 = null;
        client1.setName("ccc");
        //Exception in thread "main" java.lang.NullPointerException
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.main(NullSafety01.java:39)
        System.out.println(client1);
        //Client{name='ccc', balance=20, isActive=true}


        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1); testList.add(2);
        testList.add(3); testList.add(4);
        SuperList<Integer> superList = new SuperList<>(testList);
        superList.mySuperFunction();
        //4
        testList.clear();
        superList.mySuperFunction();

        SuperList<Integer> superList2 = new SuperList<>();
        //superList2.mySuerFunction();
        //Exception in thread "main" java.lang.NullPointerException
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01$SuperList.mySuerFunction(NullSafety01.java:82)
        //	at com.github.galkinie.javatutorials01.nullsafety.NullSafety01.main(NullSafety01.java:59)

        SuperList3<Integer> superList3 = new SuperList3<>();
        superList3.mySuperFunction();
        //0





        ArrayList<NullSafetyClient> clientsList = new ArrayList<>();
        clientsList.add(new NullSafetyClient("Harry Carter", 15, true));
        clientsList.add(new NullSafetyClient("John Doe", 15, true));
        clientsList.add(new NullSafetyClient("Alex Smith", 15, true));

        NullSafetyClient nullSafetyClient = findByName(clientsList, "adsfadf");
        if (nullSafetyClient != null) {
            System.out.println(nullSafetyClient);
            //
        }

        Optional<NullSafetyClient> nullSafetyClientOptional = findByName2(clientsList, "adsfadf");
        System.out.println(nullSafetyClientOptional.isPresent());
            //false

    }

    /**
     * there is also @Nullable annotation
     */
    public static void setName(@NotNull NullSafetyClient client, String name) {
        client.setName(name);
    }

    public static class SuperList3<T> {
        final ArrayList<T> internalList = new ArrayList<>();

        public SuperList3(ArrayList<T> internalList) {
            this.internalList.addAll(internalList);
        }

        /** Constructor with Select None */
        public SuperList3() {
        }

        public void mySuperFunction() {
            System.out.println(internalList.size());
        }
    }

    /**
     * Not good variant
     */
    public static class SuperList<T> {
        ArrayList<T> internalList;

        public SuperList(ArrayList<T> internalList) {
            this.internalList = internalList;
        }

        /** Constructor with Select None */
        public SuperList() {
        }

        public void mySuperFunction() {
            System.out.println(internalList.size());
        }
    }

    static NullSafetyClient findByName(List<NullSafetyClient> clients, String name) {
        for (NullSafetyClient client : clients) {
            if (name.equals(client.getName())) {
                return client;
            }
        }
        return null;
    }

    static Optional<NullSafetyClient> findByName2(List<NullSafetyClient> clients, String name) {
        for (NullSafetyClient client : clients) {
            if (name.equals(client.getName())) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

}
//null
//Client{name='ccc', balance=20, isActive=true}
//4
//0
//0
//false

