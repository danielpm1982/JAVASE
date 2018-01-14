package builder;

public interface AbstractBuilder {
    public abstract void buildAttribute1(String att1);
    public abstract void buildAttribute2(String att2);
    public abstract void buildAttribute3(String att3);
    public abstract ProductInterface getFinalProduct() throws InstantiationException;
    public abstract void clearPreviousValues();
}
