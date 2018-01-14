package factory3;

public class ProductCreator1 extends ProductCreator{
    ProductCreatorAbstractFactory productAbstractFactory;
    public ProductCreator1() {
        productAbstractFactory = new ProductCreator1ProductsCreator();
    }
    @Override
    public Product createProduct(ProductType type){
        switch(type.name()){
            case "Notebook":
                return productAbstractFactory.createNotebook();
            case "Book":
                return productAbstractFactory.createBook();
            case "Food":
                return productAbstractFactory.createFood();
            default:
                return null;
        }
    }
    public static ProductCreator getInstance() {
        return new ProductCreator1();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
