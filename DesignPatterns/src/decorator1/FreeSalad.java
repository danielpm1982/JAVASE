package decorator1;
import java.util.Arrays;

public class FreeSalad implements AccompanimentDecorator{
    private final Order orderWrapped;
    private Double individualCost;
    public FreeSalad(Order orderWrapped) {
        this.orderWrapped=orderWrapped;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        String[] array = Arrays.copyOf(getOrderWrapped().getItemDescription(),getOrderWrapped().getItemDescription().length+1);
        array[array.length-1]="FreeSalad $"+getIndividualCost();
        return array;
    }
    @Override
    public Size getSize() {
        return null;
    }
    @Override
    public Double getCost() {
        return individualCost+getOrderWrapped().getCost();
    }
    private void setIndividualCost() {
        individualCost=0.0;
    }
    public Double getIndividualCost() {
        return individualCost;
    }
    public Order getOrderWrapped() {
        return orderWrapped;
    }
}
