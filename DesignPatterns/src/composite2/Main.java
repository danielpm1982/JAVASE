package composite2;
public class Main {
    public static void main(String[] args) {
        ComponentManager manager = new ComponentManager(ComponentManager.create());
        manager.list();
        manager.listAllValues();
        manager.listAllValuesThroughExternalIterator();
        manager.listNonZeroValues();
        manager.sum();
        manager.product();
    }
}

/*
Similar to composite1 package program, except that this one, in addition to
some various Composite new methods (instead of only one - list()), had external
Iterators added to the Composite and Leaf classes, in order to be used at the
client code (ComponentManager) and make the external iteration available, 
instead of only internal iterations. The external iteration could have been used 
to make any kind of iteration and selective manipulation of Component attribute 
values or methods, independently from the actions available through the Composite 
methods and their internal iterations, that have a fixed purpose and cannot be 
changed by the client for any other different use.
*/
