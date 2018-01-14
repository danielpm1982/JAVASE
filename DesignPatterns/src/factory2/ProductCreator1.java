package factory2;

public class ProductCreator1 extends ProductCreator{
    @Override
    public Product createProduct(ProductType type){
        switch(type.name()){
            case "Notebook1":
                return new Notebook1(897, type.name(), "this is a notebook called "+type.name(), 2045.5f, 1.5f, this.toString());
            case "Book1":
                return new Book1(456, type.name(), "this is a book called "+type.name(), 45.5f, 3f, this.toString());
            case "Food1":
                return new Food1(345, type.name(), "this is a food called "+type.name(), 56.2f, 2.5f, this.toString());
            case "Book2":
                return new Book2(644, type.name(), "this is a book called "+type.name(), 55.5f, 2.5f, this.toString());
            case "Food2":
                return new Food2(887, type.name(), "this is a food called "+type.name(), 22.2f, 0.5f, this.toString());
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
