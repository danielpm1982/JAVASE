package factory1;
public class Food implements Product{
    private final int code;
    private final String name;
    private final String description;
    private final float price;
    private final float weight;
    public Food(int code, String name, String description, float price, float weight) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
    }
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public float getPrice() {
        return price;
    }
    @Override
    public float getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Food-> code: "+code+" name: "+name+" description: "+description+" price: "+price+" weight: "+weight;
    }
}
