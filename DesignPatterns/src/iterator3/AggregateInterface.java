package iterator3;
import java.util.ListIterator;

public interface AggregateInterface {
    public ListIterator<ItemInterface> getIterator();
    public int getSize();
}
