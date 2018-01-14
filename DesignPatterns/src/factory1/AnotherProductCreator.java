package factory1;
public class AnotherProductCreator implements ProductFactory{
    @Override
    public Product createProduct(ProductType type){
        switch(type.name()){
            case "Notebook":
                return createProduct(type, 999, "Notebook", "a generic notebook", -1f, -1f);
            case "Book":
                return createProduct(type, 999, "Book", "a generic book", -1f, -1f);
            case "Food":
                return createProduct(type, 999, "Food", "a generic food", -1f, -1f);
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
    public static AnotherProductCreator getInstance(){
        return new AnotherProductCreator();
    }
}
