package adapter2;
import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumerationAdapter<T> implements Enumeration<T>{
    Iterator<T> iterator;
    public IteratorEnumerationAdapter(Iterator<T> iterator) {
        this.iterator=iterator;
    }
    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }
    @Override
    public T nextElement() {
        return iterator.next();
    }
}
