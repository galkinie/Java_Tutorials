/**
 * @author Ilya Galkin, @version %I%, date mm/dd/yy %G%, time %U%
 */
package com.github.galkinie.javatutorials01.elenacodes.objectorientedprogramming;


public class ObjectOrientedProgrammingApp {
    static void main() {
        Airplane boeing737 = new Airplane();
        boeing737.model = "Boeing 737";
        boeing737.capacity = 180;

        boeing737.fly();
        boeing737.landing();

        Calculator calculator1 = new Calculator();
        int sum = calculator1.add(10, 5);
        int difference = calculator1.sub(10, 5);
        int multiplication = calculator1.multiply(10, 5);
        int division = calculator1.divide(10, 5);
        int division1 = calculator1.divide(10, 0);

        System.out.println("sum= " + sum);
        System.out.println("difference= " + difference);
        System.out.println("multiplication= " + multiplication);
        System.out.println("division= " + division);
        System.out.println("division1= " + division1);

        Person person1 = new Person();
        person1.setName("Alex");
        person1.setAge(25);

        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());


        Animal animal = new Animal("Обычное животное");
        animal.makeSound();

        Cat cat = new Cat("A cat.");
        cat.makeSound();
        cat.move();


        Transport[] transports = {
                new Car(),
                new Boat(),
                new AirBus()
        };

        for (Transport transport : transports) {
            transport.move();
        }


    }
}
//The airplane is flying.
//The airplane is landing.
//ERROR = деление на ноль.
//sum= 15
//difference= 5
//multiplication= 50
//division= 2
//division1= 0
//Name: Alex
//Age: 25
//Обычное животное издаёт звук.
//A cat. издаёт звук.
//A cat. мяукает
//A cat. moves.

//The car is riding on the road.
//The boat is cruising on the river.
//The airbus is flying.
