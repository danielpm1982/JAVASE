package decorator1;
import java.util.Arrays;

public class FrenchFries implements AccompanimentDecorator{
    private final Size size;
    private final Order orderWrapped;
    private Double individualCost;
    public FrenchFries(Order orderWrapped, Size size) {
        this.size=size;
        this.orderWrapped=orderWrapped;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        String[] array = Arrays.copyOf(getOrderWrapped().getItemDescription(),getOrderWrapped().getItemDescription().length+1);
        array[array.length-1]=getSize().name()+" FrenchFries $"+getIndividualCost();
        return array;
    }
    @Override
    public Size getSize() {
        return size;
    }
    @Override
    public Double getCost() {
        return individualCost+getOrderWrapped().getCost();
    }
    private void setIndividualCost() {
        switch(size){
            case Ultra:
                individualCost=6.5;
                break;
            case Big:
                individualCost=5.5;
                break;
            case Medium:
                individualCost=4.5;
                break;
            case Small:
                individualCost=3.5;
                break;
            case Mini:
                individualCost=2.5;
                break;
            default:
                individualCost=0.0;
                break;
        }
    }
    public Double getIndividualCost() {
        return individualCost;
    }
    public Order getOrderWrapped() {
        return orderWrapped;
    }
}
