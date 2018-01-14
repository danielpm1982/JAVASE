package factory1;
public interface ProductFactory {
    public abstract Product createProduct(ProductType type);
    public abstract Product createProduct(ProductType type, int code, String name, String description, float price, float weight);
}
