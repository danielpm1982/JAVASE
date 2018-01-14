package iterator4;
import java.util.Comparator;

public class ItemComparator<I extends Item> implements Comparator<I>{
    @Override
    public int compare(I o1, I o2) {
        return o1.getCode()-o2.getCode();
    }
    public static ItemComparator<Item> getInstance(){
        return new ItemComparator<>();
    }
}
