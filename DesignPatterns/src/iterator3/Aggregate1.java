package iterator3;
import java.util.ListIterator;

public class Aggregate1 implements AggregateInterface{
    private final ItemInterface[] itemArray;
    public Aggregate1(ItemInterface... itemArray) {
        this.itemArray = itemArray;
    }
    @Override
    public ListIterator<ItemInterface> getIterator(){
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
