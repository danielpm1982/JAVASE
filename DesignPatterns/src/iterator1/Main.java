package iterator1;
public class Main {
    public static void main(String[] args) {
        Aggregates.createAndlist();
    }
}

/*
The Iterator Pattern provides a way for iterating different and heterogeneous aggregates,
using one same reusable interface and code, instead of different codes for iterating each 
different aggregate individually.
In this example, the Aggregates object has a public method for listing all Item aggregates
created inside it. Within its class, the public createAndlist() method creates a number 
of examples of heterogeneous aggregates and calls a private list() method that
receives each created aggregate as an argument to list it, by calling its getIterator() 
method, and then the hasNext() and next() methods of each aggregates Iterator, iteratively.
If the Iterator interface and concrete Iterator classes were not used, it would not be
possible to treat different aggregates as one single type when calling a method for listing
them, as each aggregate would have different data structures (like List and array) with 
different methods to get its size and each element, for instance.
By using the Iterator interface, thus, for generically iterating different aggregates, it turns
possible to deal with these in one same manner, reusing the client code and encapsulating the 
differences of aggregate structures inside each concrete Iterator, and not at a client level
or at the level of the Aggregates class. The Aggregates class, here, has the responsibility of 
listing them all as one single type: Aggregate, and in a way oriented to their common Iterator 
interface, not knowing their inner structure details. These details and the low level iteration
methods are encapsulated inside the concrete Iterator objects, and nowhere else. This also 
facilitates maintenance. And, as each Aggregate interface presupposes a method for getting a 
concrete Iterator, any Aggregate can then be iterated, through its Iterator, using the reusable 
and private list method at the Aggregates class, that works somewhat as the client. This also 
favors extending the system and its components (with any number of aggregates) without changing 
the client accessible code. Only new concrete Iterators must be created for each different aggregate
added. The rest of the code doesn't change.

"The Iterator Pattern provides a way to access the elements of an aggregate object sequentially 
without exposing its underlying representation."
(Head First, Design Patterns, 2004)
*/
