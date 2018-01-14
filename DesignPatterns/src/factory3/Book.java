package factory3;

public abstract class Book extends Product{
    public Book(int code, String name, String description, float price, float weight, String creator) {
        super(code, name, description, price, weight, creator);
    }
    @Override
    public final String toString() {
        return "Book-> code: "+code+" name: "+name+" description: "+description+" price: "+price+" weight: "+weight+" creator: "+creator;
    }
}
