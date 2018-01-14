package factory3;
public class ProductCreator2ProductsCreator implements ProductCreatorAbstractFactory{
    @Override
    public Book createBook() {
        return new Book2(644, "Book2", "this is a book called "+"Book2", 55.5f, 2.5f, this.toString());
    }
    @Override
    public Food createFood() {
        return new Food2(887, "Book2", "this is a food called "+"Book2", 22.2f, 0.5f, this.toString());
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
