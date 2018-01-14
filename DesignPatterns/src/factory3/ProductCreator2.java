package factory3;

public class ProductCreator2 extends ProductCreator{
    ProductCreatorAbstractFactory productAbstractFactory;
    public ProductCreator2() {
        productAbstractFactory = new ProductCreator2ProductsCreator();
    }
    @Override
    public Product createProduct(ProductType type){
        switch(type.name()){
            case "Book":
                return productAbstractFactory.createBook();
            case "Food":
                return productAbstractFactory.createFood();
            case "Notebook":
                return productAbstractFactory.createNotebook();
            default:
                return null;
        }
    }
    public static ProductCreator getInstance() {
        return new ProductCreator2();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
