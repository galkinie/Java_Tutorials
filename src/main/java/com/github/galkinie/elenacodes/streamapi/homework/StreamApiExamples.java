/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.elenacodes.streamapi.homework;


import java.util.*;
import java.util.stream.Collectors;

public class StreamApiExamples {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2011, 700),
                new Transaction(alan, 2012, 950)
        );

        /**
         * all transactions 2011 and sorted by value from less to greater
         */
        List<Transaction> collect1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect1);
        //[com.github.galkinie.elenacodes.streamapi.homework.Transaction@3d494fbf,
        // com.github.galkinie.elenacodes.streamapi.homework.Transaction@1ddc4ec2,
        // com.github.galkinie.elenacodes.streamapi.homework.Transaction@133314b]
        //

        /**
         * all unique cities
         */
        List<String> collect2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect2);
        //[Cambridge, Milan]


        Set<String> collect3 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(collect3);

        /**
         * all traders from, and sorted by name
         */
        List<Trader> cambridge1 = transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridge1);
        //[Trader{name='Alan', city='Cambridge'},
        // Trader{name='Brian', city='Cambridge'},
        // Trader{name='Raoul', city='Cambridge'}]

        /**
         * traders' names, sorted by name
         */
        String reduce1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(reduce1);
        //AlanBrianMarioRaoul

        /**
         * if there is at least one trader from Milan
         */
        boolean milan1 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity().equals("Milan"));
        System.out.println(milan1);
        //true

        /**
         * sum of all transactions of traders from Cambridge
         */
        List<Integer> collect4 = transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(t -> t.getValue())
                .collect(Collectors.toList());
        System.out.println(collect4);
        //[300, 1000, 400, 950]

        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(t -> t.getValue())
                .forEach(x -> System.out.println(x));
        //300
        //1000
        //400
        //950

        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(t -> t.getValue())
                .forEach(System.out::println);
        //300
        //1000
        //400
        //950

        /**
         * maximal sum of all transactions
         */
        Optional<Integer> reduce5 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce5);
        //Optional[1000]

    }
}
