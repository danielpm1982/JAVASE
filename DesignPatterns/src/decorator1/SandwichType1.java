package decorator1;
public class SandwichType1 implements Sandwich{
    private final Size size;
    private Double individualCost;
    public SandwichType1(Size size) {
        this.size=size;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        return new String[]{(getSize().name()+" SandwichType1 $"+getIndividualCost())};
    }
    @Override
    public Size getSize() {
        return size;
    }
    @Override
    public Double getCost() {
        return individualCost;
    }
    private void setIndividualCost() {
        switch(size){
            case Ultra:
                individualCost = 5.5;
                break;
            case Big:
                individualCost = 4.5;
                break;
            case Medium:
                individualCost = 3.5;
                break;
            case Small:
                individualCost = 2.5;
                break;
            case Mini:
                individualCost = 1.5;
                break;
            default:
                individualCost = 0.0;
        }
    }
    public Double getIndividualCost() {
        return individualCost;
    }
}
