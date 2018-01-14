package iterator4;
import java.util.Iterator;

public class AggregatesLister {
    public static void list() { //calling AggregatesCreator create() method, iterating its Aggregates elements and listing their items, with internal iteration.
        Iterator<AggregateInterface> aggregatesListIterator = AggregatesCreator.create().iterator();
        aggregatesListIterator.forEachRemaining(x->list(x));
    }
    private static void list(AggregateInterface aggregate){ //one same interface and code for listing all heterogeneous aggregates.
        System.out.println("Aggregate "+aggregate+" - size: "+aggregate.getSize()+" elements:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        aggregate.getIterator().list();
        System.out.println("");
        aggregate.getIterator().listOrdered();
        System.out.println("");
        aggregate.getIterator().listReversed();
        System.out.println("");
    }
}
