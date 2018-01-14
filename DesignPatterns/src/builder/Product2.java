package builder;

public class Product2 implements ProductInterface{
    private final String attribute1;
    private final int attribute2;
    public Product2(String att1, int att2) {
        this.attribute1=att1;
        this.attribute2=att2;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" attribute1: "+attribute1+" attribute2: "+attribute2;
    }
}
