package composite1;

public interface Component {
    public default String getDescription(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default int getSize(){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default String getClassName(){
        return this.getClass().getSimpleName();
    }
    public default int getHashCode(){
        return this.hashCode();
    }
    public default void add(Component component){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default void remove(Component component){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public default Component getChild(int i){
        throw new UnsupportedOperationException("Operation not supported for this object!");
    }
    public abstract void list();
}
