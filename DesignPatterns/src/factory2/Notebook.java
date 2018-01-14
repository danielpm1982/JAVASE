package factory2;

public class Notebook extends Product{
    public Notebook(int code, String name, String description, float price, float weight, String creator) {
        super(code, name, description, price, weight, creator);
    }
    @Override
    public final String toString() {
        return "Notebook-> code: "+code+" name: "+name+" description: "+description+" price: "+price+" weight: "+weight+" creator: "+creator;
    }
}
