package factory2;

public class Food extends Product{
    public Food(int code, String name, String description, float price, float weight, String creator){
        super(code, name, description, price, weight, creator);
    }
    @Override
    public final String toString() {
        return "Food-> code: "+code+" name: "+name+" description: "+description+" price: "+price+" weight: "+weight+" creator: "+creator;
    }
}
