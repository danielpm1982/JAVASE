package iterator3;

public class Main {
    public static void main(String[] args) {
        AggregatesLister.list();
    }
}

/*
The same as Iterator2 package, except that, instead of the inbuilt Iterator<> interface 
it was used the ListIterator<> one, and the AggregateInterface modified in order to return
that: either the concrete inbuilt ListIterator<> from the java.util.List API or the customized
ListIterator<> implemented for the array-based structured aggregate: Aggregate1Iterator.
A third Aggregate type, with a TreeMap structure, has been used to show how easy it is to extend
the current design.
Other than, or together with, Iterator<> interface, extended Iterators could be
used, as in this case, with the ListIterator<>, or using any other Iterator<>-derivated class.
For heterogenous data-structure classes, in which someone has inbuilt Java Collection's
aggregate structures and Iterator or ListIterator as the Iteration class, it's better for
the programmer to extend the native Iterator classes rather than creating completely new ones,
facilitating integration and polymorphic iteration designs (internal or external iterations).
There should be a common Interface for all Iterators, both for inbuilt and customized concrete ones.

"The Iterator Pattern provides a way to access the elements of an aggregate object sequentially 
without exposing its underlying representation."
(Head First, Design Patterns, 2004)
*/
