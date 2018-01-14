package factory1;
public class ProductCreator implements ProductFactory{
    @Override
    public Product createProduct(ProductType type){
        switch(type.name()){
            case "Notebook":
                return createProduct(type, 000, "Notebook", "a generic notebook", 0.0f, 0.0f);
            case "Book":
                return createProduct(type, 000, "Book", "a generic book", 0.0f, 0.0f);
            case "Food":
                return createProduct(type, 000, "Food", "a generic food", 0.0f, 0.0f);
            default:
                return null;
        }
    }
    @Override
    public Product createProduct(ProductType type, int code, String name, String description, float cost, float weight){
        switch(type.name()){
            case "Notebook":
                return new Notebook(code, name, description, cost, weight);
            case "Book":
                return new Book(code, name, description, cost, weight);
            case "Food":
                return new Food(code, name, description, cost, weight);
            default:
                return null;
        }
    }
    public static ProductCreator getInstance(){
        return new ProductCreator();
    }
}
