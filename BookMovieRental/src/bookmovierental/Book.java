package bookmovierental;
public class Book extends Item{
    private String author;
    public Book(String title, String author, double rentalPrice) {
        this.title=title;
        this.author=author;
        this.rentalPrice=rentalPrice;
    }
    @Override
    protected double getFineTax() {
        return 0.2;
    }
    @Override
    public String toString() {
        return "Book -> title: "+title+"; author: "+author+"; rentalPrice: "+rentalPrice+" rentalFineIfAny: "+getFineTax()*rentalPrice;
    }
}
