package iterator2;
import java.util.Iterator;

public class AggregatesLister {
    public static void list() { //calling AggregatesCreator create() method, iterating its Aggregates elements and listing their items, with external iteration.
        Iterator<AggregateInterface> aggregatesListIterator = AggregatesCreator.create().iterator();
        aggregatesListIterator.forEachRemaining(x->list(x));
    }
    private static void list(AggregateInterface aggregate){ //one same interface and code for listing all heterogeneous aggregates
        System.out.println("Aggregate "+aggregate+" - size: "+aggregate.getSize()+" elements:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        Iterator aggregateIterator = aggregate.getIterator();
        while(aggregateIterator.hasNext()){
            System.out.println(((ItemInterface)aggregateIterator.next()).getDescription());
        }
        System.out.println("");
    }
}
