package integersetlowlevel;
public interface IntegerSet {
    public abstract void add(Integer n);
    public abstract void remove(Integer n);
    public abstract IntegerSet union(IntegerSet set);
    public abstract IntegerSet interSection(IntegerSet set);
    public abstract IntegerSet diff(IntegerSet set);
}
