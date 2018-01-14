package decorator1;
import java.util.Arrays;

public class SimpsonsGift implements GiftDecorator{
    private final Order orderWrapped;
    private final SimpsonsGiftType simpsonsGiftType;
    private Double individualCost;
    public SimpsonsGift(Order orderWrapped, SimpsonsGiftType simpsonsGiftType){
        this.orderWrapped=orderWrapped;
        this.simpsonsGiftType=simpsonsGiftType;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        String[] array = Arrays.copyOf(getOrderWrapped().getItemDescription(),getOrderWrapped().getItemDescription().length+1);
        array[array.length-1]=getSimpsonsGiftType().name()+" $"+getIndividualCost();
        return array;
    }
    @Override
    public Size getSize() {
        return null;
    }
    public SimpsonsGiftType getSimpsonsGiftType() {
        return simpsonsGiftType;
    }
    @Override
    public Double getCost() {
        return getIndividualCost()+getOrderWrapped().getCost();
    }
    private void setIndividualCost() {
        this.individualCost = 5.00;
    }
    public Double getIndividualCost() {
        return individualCost;
    }
    public Order getOrderWrapped() {
        return orderWrapped;
    }
}
