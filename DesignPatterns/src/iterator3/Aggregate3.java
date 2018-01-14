package iterator3;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public class Aggregate3 implements AggregateInterface{
    private final Map<String,ItemInterface> itemMap;
    public Aggregate3(ItemInterface... itemArray) {
        itemMap = new TreeMap<>();
        ListIterator<ItemInterface> listIterator = Arrays.asList(itemArray).listIterator();
        while(listIterator.hasNext()){
            itemMap.put("Item "+listIterator.nextIndex()+": ", listIterator.next());
        }
    }
    @Override
    public ListIterator<ItemInterface> getIterator(){
        return Arrays.asList(itemMap.values().toArray(new ItemInterface[0])).listIterator();
    }
    @Override
    public int getSize(){
        return itemMap.size();
    }
    @Override
    public String toString() {
        return "Aggregate3";
    }
}
