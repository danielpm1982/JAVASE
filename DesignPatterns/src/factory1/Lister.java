package factory1;
import java.util.Arrays;
import java.util.List;

public class Lister {
    private final ProductFactory factory;
    public Lister(ProductFactory factory) {
        this.factory=factory;
    }
    public List<Product> getList() {
        Product p1 = factory.createProduct(ProductType.Notebook);
        Product p2 = factory.createProduct(ProductType.Notebook, 456, "NotebookXYZ", "another notebook", 5500.0f,0.5f);
        Product p3 = factory.createProduct(ProductType.Book);
        Product p4 = factory.createProduct(ProductType.Book, 789, "BookkXYZ", "another book", 650.0f,3.5f);
        Product p5 = factory.createProduct(ProductType.Food);
        Product p6 = factory.createProduct(ProductType.Food, 120, "FoodXYZ", "another food", 10.0f,0.1f);
        return Arrays.asList(p1,p2,p3,p4,p5,p6);        
    }
    public static Lister getInstance(ProductFactory factory){
        return new Lister(factory);
    }
}
