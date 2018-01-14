package factory3;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------F-A-C-T-O-R-Y-1------------------");
        ProductCreator productCreator1 = ProductCreator1.getInstance();
        productCreator1.orderProduct(ProductType.Notebook);
        productCreator1.orderProduct(ProductType.Book);
        productCreator1.orderProduct(ProductType.Food);
        productCreator1.getOrderedList().forEach(System.out::println);
        System.out.println("\n------------------F-A-C-T-O-R-Y-2------------------");
        ProductCreator productCreator2 = ProductCreator2.getInstance();
        productCreator2.orderProduct(ProductType.Notebook);
        productCreator2.orderProduct(ProductType.Book);
        productCreator2.orderProduct(ProductType.Food);
        productCreator2.getOrderedList().forEach(System.out::println);
        System.out.println("");
    }
}

/*
Adapting the code from factory2 package, in this package we have not only the same FactoryMethod
Pattern used previously, but also, inside each of concrete factory of this, we have another Factory Pattern,
that is the AbstractFactory Pattern, by whose concrete factories the Products are actually created,
instead of by each client selection. The Client now only specifies which kind of product to create and
the concrete factory of the AbstractFactory, inside the concrete factory method of the FactoryMethod, 
instantiates the correct and fixed product instance. This additional level of abstraction, using AbstractFactory 
pattern inside the FactoryMethod Pattern is merely didatic, none of the patterns depend on each other. 
It could be implemented any example with AbstractFactory alone, although, internally, the concrete factories 
of the AbstractMethod Pattern generally are also implemented using FactoryMethod Pattern as in this example, also. 
But there's no need for using FactoryMethod Pattern at the external classes of the class that actually 
uses the AbstractFactory concrete classes for creating the products, nor there would be any need of
using AbstractMethod Pattern for creating the products here.
The differences of these two main Factory Patterns are that with FactoryMethod the objective is to 
create one ONLY product at a time (with or without using parameters for that), while for AbstractFactory
Pattern the purpose is to create many similar objects (from one same interface). With FactoryMethod the
means for that is by using inheritance and ONE abstract factory method, whose implementation at the concrete
factory is called dynamically, after the user calls for the public method (order) at the specialized instance.
On the other hand, AbstractFactory Pattern determines another way for encapsulating the products creation, which
is by defining a unique interface for the concrete factories, and each of these defining its own way
for creating the lots of the products the interface means to produce. The interface, in this case,
needs to include ALL creational methods for each concrete factory to implement, not only one factory method
as with FactoryMethod Pattern, and changes in the products may demand change at the interface and all
implemented concrete factories, differently from the FactoryMethod Pattern, where you have only
one single factory method pattern that does not need to change with the extension with new factories. Instead
of using inheritance, and dynamic linking, the concrete factories from AbstractFactory interfaces
have their methods called using composition, and the concrete factory is instantiated 
or passed as argument to the client class, in order to be used, as with SimpleFactory Pattern. With SimpleFactory
you have no interface, only the separation of the instantiation at a concrete factory that is accessed directly
by the client, similarly, by composition.
Using either FactoryMethod or AbstractFactory Patterns, not only you can program to interfaces (abstractions), rather than for
concrete classes, but you also may reach the dependence inversion of the design and implementation of the project,
with much lower coupling between related objects and with much more flexibility and extensibility, along with the 
encapsulated instatiation of products.

The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without 
specifying their concrete classes.
(Head First, Design Patterns, 2004)
*/