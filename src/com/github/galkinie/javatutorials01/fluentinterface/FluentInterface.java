package com.github.galkinie.javatutorials01.fluentinterface;

import ru.arhiser.funcops.Client;
import ru.arhiser.funcops.inter.Action1;
import ru.arhiser.funcops.inter.Func1;
import ru.arhiser.funcops.inter.Func2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FluentInterface {

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();

        clients.add(new Client("Harry Carter", 15, true));
        clients.add(new Client("Adam Atkinson", 5, true));
        clients.add(new Client("Bobby Robertson", 8, true));
        clients.add(new Client("Liam Ellis", 6, false));
        clients.add(new Client("Alex Thomson", 9, true));
        clients.add(new Client("Ryan Ayala", 4, false));
        clients.add(new Client("Kale Molina", 3, true));
        clients.add(new Client("Otto Holman", 7, false));

        FluentInterfaceClient client = new FluentInterfaceClient();
        client.setName("Alex");
        client.setBalance(15);
        client.setActive(true);
        /** Changing Setters to return not void, but objectFluentInterfaceClient
         *  And those Setters 'return this;'
         *
         * */
        FluentInterfaceClient client2 = new FluentInterfaceClient();
        client2.setName("Alex")
                .setBalance(15)
                .setActive(true);

    }
}
