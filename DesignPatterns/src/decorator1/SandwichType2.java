package decorator1;
public class SandwichType2 implements Sandwich{
    private final Size size;
    private Double individualCost;
    public SandwichType2(Size size) {
        this.size=size;
        setIndividualCost();
    }
    @Override
    public String[] getItemDescription() {
        return new String[]{(getSize().name()+" SandwichType2 $"+getIndividualCost())};
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
                individualCost = 10.5;
                break;
            case Big:
                individualCost = 9.5;
                break;
            case Medium:
                individualCost = 8.5;
                break;
            case Small:
                individualCost = 7.5;
                break;
            case Mini:
                individualCost = 6.5;
                break;
            default:
                individualCost = 0.0;
        }
    }
    public Double getIndividualCost() {
        return individualCost;
    }
}
