package composite1;

public class Main {
    public static void main(String[] args) {
        ComponentLister.list();
    }
}

/*
Composition Pattern is a way of organizing Composite and Leaf (whole-part) objects 
into a Tree structure, oriented to a Component Interface, in order to use methods 
(list(), for instance) in a recursive and polymorphic way, whether over other 
Composite or final Leaf components. Instead of external Iterators, the Composite 
aggregate may offer this polymorphic and recursive list() method (which may use 
an internal Iterator), and at the Client class (ComponentLister, here) only the 
list() of the root Component (Composite1 and Composite2, here) is called... the other 
list() methods of the other Composite and Leaf objects that are part of the root hierarchy
are called recursively. This pattern, by using a tree structure, and a common 
Component interface, turns it possible to create more flexible and complex Aggregates, 
with sub, sub, subComponents of Components, if necessary, as well as facilitates and 
encapsulates even more the structuring and listing of all Components (the structuring
is totally encapsulated at the Composite and the listing both in the Composite and Leaf).
Although all interface methods may not be coherent to the two different concrete type 
classes (Composite and Leaf), not every method of the interface has to be implemented 
(if it doesn't make sense for that type of Component), and a default concrete 
implementation can be done at the interface itself (or abstract class), like throwing an 
UnsupportedOperationException. Because of the polymorphism and single interface used, 
it is transparent for the Client which component he is manipulating, or listing. The 
trade off for having a double responsibility at the interface (for two different concrete 
types) is the transparency for the Client while dealing with the Components (whether 
Composite or Leaf objects).
For conditional iteration method calls, other than the iteration of the whole structure
and calling of every element method, external Iterators could be developed, in order to 
receive root Component Iterators and iterate the whole tree structure of this component, 
while conditioning the method call to a certain boolean attribute (or any other checking), 
that, if true, would liberate for the calling, for instance, of the list() method of 
that specific Component but not of some others in the same Tree.

"The Composite Pattern allows you to compose objects into tree structures to represent 
part-whole hierarchies. Composite lets clients treat individual objects and compositions 
of objects uniformly."
(Head First, Design Patterns, 2004)
*/
