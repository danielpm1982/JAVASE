package templateMethod2;
public class Main {
    public static void main(String[] args) {
        ComposedClass composedClass = new ComposedClassConcrete();
        TemplateClass templateClass = new TemplateClass(composedClass);
        templateClass.templateMethod();
    }
}

/*
Flexibilization of TemplateMethod Pattern, in which composition, instead of inheritance,
is used. The central definition of the pattern is maintained, that is, the template
method keeps control and the calling of all methods, and part of these are implemented 
by other classes that, in this case, interact with the TemplateClass through composition
and not generalization (inheritance).
Another example, regarding Java API, is the sort() template method that delegates to the
class that implements the Comparable interface the implementation of the compareTo() method
that the template method uses internally.
*/
