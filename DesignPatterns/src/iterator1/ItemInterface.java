package iterator1;
public interface ItemInterface {
    public abstract String getDescription();
    public default String getClassName(){
        return this.getClass().getSimpleName();
    }
    public default int getHashCode(){
        return this.hashCode();
    }
}
