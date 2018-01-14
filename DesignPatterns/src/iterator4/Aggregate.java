package iterator4;

public class Aggregate implements AggregateInterface{
    private final Item[] itemArray;
    public Aggregate(Item... itemArray) {
        this.itemArray = itemArray;
    }
    @Override
    public AggregateIteratorInterface getIterator() {
        return new AggregateIterator(itemArray);
    }
    @Override
    public int getSize(){
        return itemArray.length;
    }
    @Override
    public String toString() {
        return "Aggregate1";
    }
}
