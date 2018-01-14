package shoppingCartWithGenerics;

public class ProductChild extends Product{
    private final String supplier;
    public ProductChild(Integer id, String name, Double price, String supplier) {
        super(id, name, price);
        this.supplier=supplier;
    }
    public String getSupplier() {
        return supplier;
    }
    @Override
    public String toString() {
        return "Product - Id: "+getId()+" Name: "+getName()+" Price: "+getPrice()+" Supplier: "+supplier;
    }
}
