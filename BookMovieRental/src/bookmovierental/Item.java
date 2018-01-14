package bookmovierental;
public abstract class Item {
    protected String title;
    protected double rentalPrice;
    protected abstract double getFineTax();
}
