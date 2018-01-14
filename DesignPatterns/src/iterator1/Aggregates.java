package iterator1;
//import java.util.Arrays;

public class Aggregates {
    public static void createAndlist() {
        AggregateInterface a1 = new Aggregate1(new Item(), new Item("just another item"), new Item(555, "Item3", "a third item"), new Item(), new Item());
//        System.out.println("ItemArray - length "+a1.getItemArray().length+" elements:");
//        Arrays.stream(a1.getItemArray()).forEach(System.out::println);
        list(a1);

        AggregateInterface a2 = new Aggregate2(new Item(), new Item("just another item"), new Item(555, "item3", "a third item"), new Item(), new Item());
//        System.out.println("ItemList - size "+a2.getItemList().size()+" elements:");
//        a2.getItemList().forEach(System.out::println);
        list(a2);
    }
    private static void list(AggregateInterface aggregate){ //one same interface and code for listing all heterogeneous aggregates
        System.out.println("Aggregate "+aggregate+" - size: "+aggregate.getSize()+" elements:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        IteratorInterface aggregateIterator = aggregate.getIterator();
        while(aggregateIterator.hasNext()){
            System.out.println(((ItemInterface)aggregateIterator.next()).getDescription());
        }
        System.out.println("");
    }
}
