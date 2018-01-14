package composite2;
import java.util.Iterator;

public class NullIterator implements Iterator<Component>{
    @Override
    public boolean hasNext() {
        return false;
    }
    @Override
    public Component next() {
        return null;
    }
}
