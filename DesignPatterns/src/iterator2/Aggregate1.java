package iterator2;
import java.util.Iterator;

public class Aggregate1 implements AggregateInterface{
    private final ItemInterface[] itemArray;
    public Aggregate1(ItemInterface... itemArray) {
        this.itemArray = itemArray;
    }
    @Override
    public Iterator<? extends Object> getIterator(){
        return new Aggregate1Iterator(itemArray);
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
