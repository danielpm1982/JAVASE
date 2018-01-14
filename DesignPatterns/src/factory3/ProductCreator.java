package factory3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ProductCreator {
    private final List<Product> list;
    public ProductCreator() {
        list = new ArrayList<>();
    }    
    public Product orderProduct(ProductType type){
        Product product = createProduct(type);
        list.add(product);
        return product;
    }
    public final List<Product> getOrderedList() {
//        Collections.sort(list);
        list.sort(Comparator.naturalOrder());
        return list;
    }
    protected abstract Product createProduct(ProductType type);
}
