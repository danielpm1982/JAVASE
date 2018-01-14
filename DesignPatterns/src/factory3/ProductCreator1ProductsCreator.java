package factory3;
public class ProductCreator1ProductsCreator implements ProductCreatorAbstractFactory{
    @Override
    public Book createBook() {
        return new Book1(456, "Book1", "this is a book called "+"Book1", 45.5f, 3f, this.toString());
    }
    @Override
    public Food createFood() {
        return new Food1(345, "Food1", "this is a food called "+"Food1", 56.2f, 2.5f, this.toString());
    }
    @Override
    public Notebook createNotebook() {
        return new Notebook1(897, "Notebook1", "this is a notebook called "+"Notebook1", 2045.5f, 1.5f, this.toString());
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
