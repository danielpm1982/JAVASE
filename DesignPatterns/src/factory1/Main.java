package factory1;
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------F-A-C-T-O-R-Y-1------------------");
        Lister.getInstance(ProductCreator.getInstance()).getList().forEach(System.out::println);
        System.out.println("\n------------------F-A-C-T-O-R-Y-2------------------");
        Lister.getInstance(AnotherProductCreator.getInstance()).getList().forEach(System.out::println);
        System.out.println("");
    }
}

/*
A simpleFactory encapsulation of the instantiation of Products through a ProductFactory - 
ProductCreator (factory1), AnotherProductFactory (factory2) or other future 
ones with the same interface. 
Open Closed SOLID principle would be followed: new Product types could be added, 
as well as new factories, and the only eventual change would be at the concrete factory 
itself (and the enum type class), and only minimally at the client accessible class 
(Lister class), with no changes at other parts.
According to this factory interface, the creation can be done by product type alone
(with generic, internal and fixed parameter values) or also with customized parameter 
values passed by the client (see Lister code).
It could also be an unparameterized creator method, with a one and only type of produdct created.
This is not the FactoryMethod Pattern, though. It is just the SimpleFactory Pattern.
There are three kinds of Factory Patterns: SimpleFactory, FactoryMethod and AbstractFactory.
At SimpleFactory, although there is the uncoupling and encapsulation of the instanciation of
the products at concrete factories, the client accessible class (Lister) concretely has to
call the creating method at the concrete factory after getting a factory instance by composition.
Which does not occur at FactoryMethod Pattern (see factory2 package - where the calling is through dynamic 
linking). The difference from AbstractFactory is more discrete: generically speaking, it would be
due to the various creational methods the interface of the AbstractFactory would be expected
to define (and its concrete factories to implement). In this package case, although an interface is used,
the creational methods, for each product, are not defined. The creation of the Products is selected 
and the product types instantiated directly at the concrete factories, without creational methods 
for each one (see factory3 package for a real AbstractFactory example). Anyway, SimpleFactory is least worse
than no encapsulation at all, like if the selection and instantiation of the products had been done directly
at the Lister class, in this case. But FactoryMethod and AbstractFactory are far better options.
*/