package builder;
import java.util.Map;
import java.util.TreeMap;

public class RequestControl {
    private Long requestNumber;
    private AbstractBuilder builder;
    private final Map<Long,ProductInterface> productMap;
    public RequestControl() {
        requestNumber=1000000L;
        this.builder=new ConcreteBuilder();
        this.productMap=new TreeMap<>();
    }
    public ProductInterface constructProduct(String att1, String att2, String att3) throws InstantiationException{
        requestNumber++;
        productMap.put(requestNumber,null);
        builder.clearPreviousValues();
        builder.buildAttribute1(att1);
        builder.buildAttribute2(att2);
        builder.buildAttribute3(att3);
        ProductInterface tempProduct = builder.getFinalProduct();
        productMap.put(requestNumber,tempProduct);
        return tempProduct;
    }
    public ProductInterface constructProduct(String att1, String att2) throws InstantiationException{
        requestNumber++;
        productMap.put(requestNumber,null);
        builder.clearPreviousValues();
        builder.buildAttribute1(att1);
        builder.buildAttribute2(att2);
        ProductInterface tempProduct = builder.getFinalProduct();
        productMap.put(requestNumber,tempProduct);
        return tempProduct;
    }
    public ProductInterface constructProduct(String att1) throws InstantiationException{
        requestNumber++;
        productMap.put(requestNumber,null);
        builder.clearPreviousValues();
        builder.buildAttribute1(att1);
        ProductInterface tempProduct = builder.getFinalProduct();
        productMap.put(requestNumber,tempProduct);
        return tempProduct;
    }
    public ProductInterface constructProduct() throws InstantiationException{
        requestNumber++;
        productMap.put(requestNumber,null);
        builder.clearPreviousValues();
        ProductInterface tempProduct = builder.getFinalProduct();
        productMap.put(requestNumber,tempProduct);
        return tempProduct;
    }
    public Map<Long, ProductInterface> getProductMap() {
        return productMap;
    }
    public void changeBuilder(AbstractBuilder builder){
        this.builder=builder;
    }
}
