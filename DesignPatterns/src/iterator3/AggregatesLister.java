package iterator3;
import java.util.Iterator;
import java.util.ListIterator;

public class AggregatesLister {
    public static void list() { //calling AggregatesCreator create() method, iterating its Aggregates elements and listing their items, with external iteration.
        Iterator<AggregateInterface> aggregatesListIterator = AggregatesCreator.create().iterator();
        aggregatesListIterator.forEachRemaining(x->list(x));
    }
    private static void list(AggregateInterface aggregate){ //one same interface and code for listing all heterogeneous aggregates
        System.out.println("Aggregate "+aggregate+" - size: "+aggregate.getSize()+" elements:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        ListIterator<ItemInterface> aggregateIterator = aggregate.getIterator();
        while(aggregateIterator.hasNext()){
            System.out.print("Item "+aggregateIterator.nextIndex()+": ");
            System.out.println(aggregateIterator.next().getDescription());
        }
        System.out.println("");
        System.out.println("Now backwards:");
        while(aggregateIterator.hasPrevious()){
            System.out.print("Item "+aggregateIterator.previousIndex()+": ");
            System.out.println(aggregateIterator.previous().getDescription());
        }
        System.out.println("");
    }
}
