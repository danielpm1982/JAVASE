package decorator1;
import java.util.Arrays;

public class PaidSauce implements AccompanimentDecorator{
    private final Order orderWrapped;
    private final PaidSauceType paidSauceType;
    private Double individualCost;
    public PaidSauce(Order orderWrapped, PaidSauceType paidSauceType) {
        this.orderWrapped=orderWrapped;
        this.paidSauceType=paidSauceType;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        String[] array = Arrays.copyOf(getOrderWrapped().getItemDescription(),getOrderWrapped().getItemDescription().length+1);
        array[array.length-1]=getPaidSauceType().name()+" $"+getIndividualCost();
        return array;
    }
    @Override
    public Size getSize() {
        return null;
    }
    public PaidSauceType getPaidSauceType() {
        return paidSauceType;
    }
    @Override
    public Double getCost() {
        return getIndividualCost()+getOrderWrapped().getCost();
    }
    private void setIndividualCost() {
        switch(paidSauceType){
            case BarbecueSauce:
                individualCost = 0.5;
                break;
            case BologneseSauce:
                individualCost = 0.75;
                break;
            case ChocolateSauce:
                individualCost = 0.25;
                break;
            default:
                individualCost = 0.0;
        }
    }
    public Double getIndividualCost() {
        return individualCost;
    }
    public Order getOrderWrapped() {
        return orderWrapped;
    }
}
