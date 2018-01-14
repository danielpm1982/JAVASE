package builder;

public class Product3 implements ProductInterface{
    private final String attribute1;
    public Product3(String att1) {
        this.attribute1=att1;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" attribute1: "+attribute1;
    }
}
