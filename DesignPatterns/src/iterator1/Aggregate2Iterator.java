package iterator1;
import java.util.List;

public class Aggregate2Iterator implements IteratorInterface{
    private int position;
    private final List<ItemInterface> itemList;
    public Aggregate2Iterator(List<ItemInterface> itemList) {
        this.position=0;
        this.itemList=itemList;
    }
    @Override
    public boolean hasNext() {
        if(position>=itemList.size()||itemList.get(position)==null){
            return false;
        } else{
            return true;
        }
    }
    @Override
    public Object next() {
        return itemList.get(position++);
    }
}
