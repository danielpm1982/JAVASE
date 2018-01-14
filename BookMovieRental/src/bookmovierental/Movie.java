package bookmovierental;
public class Movie extends Item{
    private int classification;
    public Movie(String title, int classification, double rentalPrice) {
        this.title=title;
        this.classification=classification;
        this.rentalPrice=rentalPrice;
    }
    @Override
    protected double getFineTax() {
        return 0.3;
    }
    @Override
    public String toString() {
        return "Movie -> title: "+title+"; classification: "+classification+"; rentalPrice: "+rentalPrice+" rentalFineIfAny: "+getFineTax()*rentalPrice;
    }
}
