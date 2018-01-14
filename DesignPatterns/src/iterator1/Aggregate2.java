package iterator1;
import java.util.Arrays;
import java.util.List;

public class Aggregate2 implements AggregateInterface{
    private final List<ItemInterface> itemList;
    public Aggregate2(ItemInterface... itemArray) {
        this.itemList = Arrays.asList(itemArray);
    }
//    public List<Item> getItemList() {
//        return itemList;
//    }
    @Override
    public IteratorInterface getIterator(){
        return new Aggregate2Iterator(itemList);
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
