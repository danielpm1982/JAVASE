package composite2;
import java.util.Iterator;
import java.util.List;

public interface Component {
    public abstract String getDescription();
    public abstract void list();
    public abstract Iterator<Component> getIterator();
    public default void add(Component component){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default void remove(Component component){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default Component getComponent(int i){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default Integer getValue(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default Integer sum(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default Long multiplicationOfNonZeroValues(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default List<Long> getNonZeroValuesList(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default List<Integer> getAllValuesList(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
}
