package decorator1;
public interface Order {
    public abstract String[] getItemDescription();
    public abstract Double getCost();
    public abstract Size getSize();
}
