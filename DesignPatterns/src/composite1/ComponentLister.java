package composite1;
import java.util.Iterator;

public class ComponentLister {
    public static void list() { //calling CompositeCreator create() method, iterating its Component elements (root Composites) and listing them through the recursive and polymorphic list() method.
        Iterator<Component> componentListIterator = CompositeCreator.create().iterator();
        componentListIterator.forEachRemaining(x->{System.out.println("\n****Hierarchy "+x+"****");x.list();}); //calling list() for every different hierarchy root Component (node).
        System.out.println("");
    }
}
