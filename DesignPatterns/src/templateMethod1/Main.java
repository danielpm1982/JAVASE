package templateMethod1;
public class Main {
    public static void main(String[] args) {
        TemplateClass templateClass1 = new ConcreteClass1();
        TemplateClass templateClass2 = new ConcreteClass2();
        templateClass1.templateMethod();
        templateClass2.templateMethod();
    }
}

/*
At the Template Pattern, there is an abstract Template Class in which a template
method is defined, but where parts of the algorithm of this template method
is pending implementation by other classes, especially and officially subclasses,
but also, informally, other composed classes. The fact is: at the template method
you have part of an algorithm that uses parts that will be implemented by other
classes.
In this example, the template method has 5 methods: 
- 2 of which (method1 and method2) are abstract methods (implemented mandatorily 
by the subclasses, but controlled by the superclass); 
- 1 concrete and final method (method3 - part of the algorithm that is implemented already); 
- and 2 concrete NOT final methods (method4 and method5 - already implemented or with an 
empty implementation, in both ways allowing overriding at subclasses, optionally). These
are called hook methods, because they offer the subclasses a way to hook into the superclass
algorithm, optionally, but without creating any more dependencies.
Only the superclass has the responsibility of controlling and executing all these methods
(abstracts, concrete final or concrete not final - hook ones), and the dependencies of
the client class (in terms of design) is always with the interface (in this case, the 
abstract class), and not with its subclasses (although the subclasses are the ones to
generate the instances, but what references these will be superclasses' reference variables).
For an example of a flexibilization of this pattern, where not subclasses but composed
classes are used to implement part of the template method's algorithm, see the templateMethod2
package. Although similar to the Strategy pattern, the difference is that the strategy pattern
composed classes implement and encapsulate all the changeable behavior algorithms. There's
no partial implementation from one and later from the another. FactoryMethod pattern, on the
other hand, is a specialization of the template method, where subclasses decide which concrete 
classes to create, that is, where the subclasses implement the super abstract method regarding 
specifically the creation (instantiation) of objects.
Also related to this pattern is the Hollywood principle: "don't call us, we'll call you", where
high level classes take all the responsibility of calling and controlling the lower level ones,
and not the opposite, at least not before the high level call the lower level class first. The
least the lower level calls the high level classes the better, for avoiding circular dependencies
between them. The lower level classes only implement what's missing on the high level classes,
but it is the high level classes that define and calls all methods, including those implemented
later by the other lower classes.
One example at the API of TemplateMethod through Inheritance, is Jframe Swing template class, that
has the update() template method, which calls the paint() hook method, that can be overriden at
subclasses to diplay at Graphic object content at the frame.
Another similar example is the Applet API, that has a lot of hook methods so that the user can
implement whatever he wants when extending from the Applet Class: init(), start(), stop(), destroy().

The Template Method Pattern defines the skeleton of an algorithm in a method, deferring some steps 
to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without 
changing the algorithm’s structure.
(Head First, Design Patterns, 2004)
*/
