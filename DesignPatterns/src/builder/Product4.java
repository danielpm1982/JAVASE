package builder;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Product4 implements ProductInterface{
    private final Double attribute1;
    private final Float attribute2;
    private final BigInteger attribute3;
    private final LocalDateTime attribute4;
    public Product4(Double att1, Float att2, BigInteger att3) {
        this.attribute1 = att1;
        this.attribute2 = att2;
        this.attribute3 = att3;
        this.attribute4=LocalDateTime.now();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" attribute1: "+attribute1+" attribute2: "+attribute2+" attribute3: "+attribute3+" attribute4: "+attribute4.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
