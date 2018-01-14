package shoppingCartWithGenerics;

public class Item {
    private final Product product;
    private final Integer amount;
    public Item(Product product, Integer amount) {
        this.product=product;
        this.amount=amount;
    }
    public Integer getAmount() {
        return amount;
    }
    public Product getProduct() {
        return product;
    }
    public String getProductName(){
        return product.getName();
    }
    @Override
    public String toString() {
        return "ItemDescription: "+product+" Amount: "+amount;
    }
}
