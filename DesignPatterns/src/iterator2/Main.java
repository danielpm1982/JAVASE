package iterator2;

public class Main {
    public static void main(String[] args) {
        AggregatesLister.list();
    }
}

/*
The same as Iterator1 package, except that, instead of a customized Iterate Interface
and concrete Iterators, it was used the inbuilt Iterator<E> interface and the List
interator() method that returns a concrete iterator for the list (at Aggregate2 class).
For the array-structured class (Aggregate1), a concrete and customized iterator, that
implemented the inbuilt Iterator<E> Interface, was still necessary to be implemented,
as the array structure doesn't have any inbuilt concrete iterator to be retrieved.
For creating and listing the Aggregates, instead of the former Aggregates class, the
two responsabilities were separated in two divided classes (AggregatesCreator and 
AggregatesLister). The user calls the list() method of AggregatesLister class, in which
the AggregatesCreator create() method is called, retreiving a List of Aggregates whose
iterator is iteratively listed. When being listed, each Aggregate has its own Iterator,
through which all of its items are then iterated and displayed.
There's one Iterator for the list of Aggregates and another for each Aggregate (with Items).
Single Responsability Principle and Cohesion are also obeyed. As well as the Open Closed
Principle (for the AggregatesLister class, at least).

"The Iterator Pattern provides a way to access the elements of an aggregate object sequentially 
without exposing its underlying representation."
(Head First, Design Patterns, 2004)
*/
