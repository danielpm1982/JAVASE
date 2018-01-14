package iterator2;
import java.util.Iterator;

public interface AggregateInterface {
    public Iterator<? extends Object> getIterator();
    public int getSize();
}
