package decorator2;
public class Main {
    public static void main(String[] args) {
        UniqueInterface composingComponent = new ComponentPrincipal();
        composingComponent = new Decorator1(composingComponent);
        composingComponent = new Decorator2(composingComponent);
        composingComponent = new Decorator3(composingComponent);
        System.out.println(composingComponent.display());
    }
}

/*
Using one same interface (differently from Adapter Pattern where you've got at
least two), the main components, as well as the Decorator components, implement
the same method: display(). With Decorators, however, they receive,
dynamically, an instance of other component (or previously composed components),
in order to use these together with its proper methods, composing thus behaviors
that will come together as one, with the execution of methods of the main interface.
As, by principle, each decorator doesn't know about what has been composed before,
or even if the component it is receiving is a previous composition or the main
component itself, the composition process is controlled only at the Client level,
who will configure the composition in whatever order he chooses. For keeping track, 
internally, of the objects composed and with what order, data structures have
to be used and passed along with the composing components. As it's been done with 
the example at the decorator1 package (sandwich orders decorators). Composing
components (or previously composed components) for adding behavior to the present
component has nothing to do with composing Adaptee interface(s) with an Adapter that
implements a Target interface, in order to make one interface dissembled by another,
the one which the Client will make use.
*/