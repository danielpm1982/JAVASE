package iterator4;

public class Main {
    public static void main(String[] args) {
        AggregatesLister.list();
    }
}

/*
The same as Iterator3, but with an Iterator that provides internal iteration,
not returning any indexes to the user nor allowing him to control iteration.
It still happens the encapsulation of the structure details inside the Aggregate
class, being public to the user only the getIterator() and Iterator methods, but
not any specifics about the data structure used inside the Aggregate or Iterator
classes.

"The Iterator Pattern provides a way to access the elements of an aggregate object sequentially 
without exposing its underlying representation."
(Head First, Design Patterns, 2004)
*/
