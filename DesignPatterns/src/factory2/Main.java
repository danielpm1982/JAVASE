package factory2;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------F-A-C-T-O-R-Y-1------------------");
        ProductCreator productCreator1 = ProductCreator1.getInstance();
        productCreator1.orderProduct(ProductType.Notebook1);
        productCreator1.orderProduct(ProductType.Book1);
        productCreator1.orderProduct(ProductType.Book2);
        productCreator1.orderProduct(ProductType.Food1);
        productCreator1.orderProduct(ProductType.Food2);
        productCreator1.getOrderedList().forEach(System.out::println);
        System.out.println("\n------------------F-A-C-T-O-R-Y-2------------------");
        ProductCreator productCreator2 = ProductCreator2.getInstance();
        productCreator2.orderProduct(ProductType.Notebook1);
        productCreator2.orderProduct(ProductType.Book1);
        productCreator2.orderProduct(ProductType.Book2);
        productCreator2.orderProduct(ProductType.Food1);
        productCreator2.orderProduct(ProductType.Food2);
        productCreator2.getOrderedList().forEach(System.out::println);
        System.out.println("");
    }
}

/*
Although similar to factory1 package api, this one has concrete factories that are subclasses of the
now abstract ProductCreator (former Lister user accessible class), an abstract factory. 
The createProduct method (factory method) is put as abstract and protected at the superclass, 
so that any concrete factory subclass has to implement it and is responsible for its instantiation and 
maintaining (keeping these changeable responsabilities encapsulated) and also inaccessible by external package classes.
At the same time, the other client methods (including orderProduct) are concrete, public and final at the 
superclass, and the creator method is now at this same superclass - although abstract,
not only at the concrete factories anymore (subclasses). These abstract methods are dinamically linked to 
the concrete factories instantiated by the user and to the respective factory method implemented by these. 
That way, only the creation is delegated to the subclasses by the abstract factory method, 
but not the rest of the superclass methods, garanteeing the uniformity of the api and user interface regarding 
any other responsabilities, which should be unchangeable.
Differently from the factory1 package API, this one also has a parameterized order method, so that,
at a more external user level, the user can order each product individually and a list is kept
inside ProductCreater class instance in order to return the whole list of products ordered to the user when requested.
This could also have been done with factory1 code, but the Lister class would still have to call the factory methods
for each kind of passed object type, statically! The Lister class would thus still have changeable code.
In the present API, the user class is the Main class, and ProductCreator is the middle one that passes the client orders, for the creation 
of products, to the concrete factories (its subclasses), as the client externally demands (calls order public method).
The difference to the Simple Factory Pattern is that, instead of an user accessible class (which is not
a factory) gets an instance of the concrete factories in order to call statically its concrete factory methods (Simple Factory), with
Factory Method Pattern the accesible class is an Abstract Factory that does have the factory method (abstract and protected)
and delegates to the concrete subclassed factories the actual creation, but without having to call the concrete factory methods itself 
(unlike Simple Fatory) and without knowing which object will actually be created. At the main class 
the user gets an instance of the concrete factory he wants and calls the inherited order method on it, and, by dynamic linking, 
the right concrete factory method is called. Similar to factory1 package code, Only the creation is delegated to the subclassed 
factories, as well as the maintaining of this piece of changeable code.
The upper Factory class never has to be changed when new concrete factories or products are included. Only if the abstract
factory method signature has to be changed.
Factory Method uses dynamic linking, instead of composition and calling for each factory product creation.
The fatory method signature, as well as with Simple Factory, can be parameterized or unparameterized, with one or more
objects to be created. If only one product for each factory, no deciding parameter should be needed.

The Factory Method Pattern deﬁnes an interface for creating an object, but lets subclasses decide which 
class to instantiate. Factory Method lets a class defer instantiation to subclasses.
(Head First, Design Patterns, 2004)
*/
