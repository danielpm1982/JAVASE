package iterator2;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Aggregate2 implements AggregateInterface{
    private final List<ItemInterface> itemList;
    public Aggregate2(ItemInterface... itemArray) {
        this.itemList = Arrays.asList(itemArray);
    }
    @Override
    public Iterator<? extends Object> getIterator(){
        return itemList.iterator();
    }
    @Override
    public int getSize(){
        return itemList.size();
    }
    @Override
    public String toString() {
        return "Aggregate2";
    }
}
