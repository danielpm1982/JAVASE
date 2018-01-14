package builder;
import java.math.BigDecimal;

public class Product1 implements ProductInterface{
    private final String attribute1;
    private final int attribute2;
    private final BigDecimal attribute3;
    public Product1(String att1, int att2, BigDecimal att3) {
        this.attribute1=att1;
        this.attribute2=att2;
        this.attribute3=att3;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" attribute1: "+attribute1+" attribute2: "+attribute2+" attribute3: "+attribute3;
    }
}
