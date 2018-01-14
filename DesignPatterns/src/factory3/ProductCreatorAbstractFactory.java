package factory3;
public interface ProductCreatorAbstractFactory {
    public abstract Book createBook();
    public abstract Food createFood();
    public abstract Notebook createNotebook();
}
