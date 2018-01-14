package factory3;

public abstract class Product implements Comparable<Product>{
    protected int code;
    protected String name;
    protected String description;
    protected float price;
    protected float weight;
    protected String creator;
    public Product(int code, String name, String description, float price, float weight, String creator) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.creator = creator;
    }
    public final int getCode() {
        return code;
    }
    public final String getName() {
        return name;
    }
    public final String getDescription() {
        return description;
    }
    public final float getPrice() {
        return price;
    }
    public final float getWeight() {
        return weight;
    }
    public final String getCreator() {
        return creator;
    }
    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
