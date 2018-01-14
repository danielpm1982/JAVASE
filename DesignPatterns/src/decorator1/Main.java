package decorator1;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("ORDER 0001");
        Order order = new SandwichType1(Size.Ultra);
        Stream.of(order.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order.getCost());
        System.out.println("----------------------------");
        System.out.println("ORDER 0007");
//        Order order2 = new SandwichType2(Size.Medium);
//        order2 = new FreeSalad(order2);
//        order2 = new FrenchFries(order2,Size.Small);
//        order2 = new PaidSauce(order2,PaidSauceType.ChocolateSauce);
//        order2 = new SoftDrink(order2,Size.Ultra);
        Order order2 = new SoftDrink(new PaidSauce(new FrenchFries(new FreeSalad(new SandwichType2(Size.Medium)), Size.Small), PaidSauceType.ChocolateSauce), Size.Ultra);
        Stream.of(order2.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order2.getCost());
        System.out.println("----------------------------");
        System.out.println("ORDER 00012");
        Order order3 = new SandwichType2(Size.Ultra);
        order3 = new FreeSalad(order3);
        order3 = new FrenchFries(order3,Size.Ultra);
        order3 = new PaidSauce(order3,PaidSauceType.BarbecueSauce);
        order3 = new SoftDrink(order3,Size.Ultra);
        Stream.of(order3.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order3.getCost());
        System.out.println("----------------------------");
        System.out.println("ORDER 00016");
        Order order4 = new SandwichType1(Size.Mini);
        order4 = new SoftDrink(order4,Size.Mini);
        Stream.of(order4.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order4.getCost());
        System.out.println("----------------------------");
        System.out.println("ORDER 00018");
        Order order5 = new SandwichType2(Size.Ultra);
        order5 = new FreeSalad(order5);
        order5 = new FrenchFries(order5,Size.Ultra);
        order5 = new PaidSauce(order5,PaidSauceType.MayonnaiseSauce);
        order5 = new SoftDrink(order5,Size.Ultra);
        order5 = new SimpsonsGift(order5, SimpsonsGiftType.Bart);
        Stream.of(order5.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order5.getCost());
        System.out.println("----------------------------");
        System.out.println("ORDER 00020");
        Order order6 = new SandwichType1(Size.Medium);
        order6 = new FrenchFries(order6,Size.Small);
        order6 = new PaidSauce(order6,PaidSauceType.TartarSauce);
        order6 = new SoftDrink(order6,Size.Medium);
        order6 = new SimpsonsGift(order6, SimpsonsGiftType.Maggie);
        Stream.of(order6.getItemDescription()).forEach(System.out::println);
        System.out.println("Total: $"+order6.getCost());
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
}

/*
Under AccompanimentDecorator or GiftDecorator interfaces, decorators of the main order are created, and, that interfaces, themselves, inherit 
from the same general interface of the main order (Order), making decorators (accompaniments and gifts) and the main order (Sandwiches) composible and
interchangeable at general instance variables of Order type. That way one can compose any number or arrangement of decorators, as well as the main component
itself (main order), and finally call for the outermost method of the object chain, in order to calculate, via delegation to all insider methods and objects, 
the total... in this case the description and the cost methods. For individual prices to be shown, specific methods were created at each chain component, 
and later called, but the two exemplified and extended behaviors (or responsabilities) - overall description and cost - were calculated by delegation and 
with the inner components' methods transparent to the user class layer (Main). The fact of the (so many) instances of each component being needed at this client 
layer is resolveable with Factory and Builder creational patterns. And the other two disavantages are: excess of individual classes and difficulty for 
understanding the whole design. As well as the type problem: if the user needs to use specific object methods not present at the general abstract classes to which 
the whole pattern is oriented, type-problem issues may arise. The advantage is the clear garantee of the open-closed principle, and the fact that the extension 
of the Order main components can be done dinamically and flexibly, instead of statically and rigidly like when inheritance is used instead of composition.

"The Decorator Pattern attaches additional responsibilities to an object dynamically.  
Decorators provide a ﬂexible alternative to subclassing, for extending functionality." 
(Head First, Design Patterns, 2004)
*/