package visitor;
public class ElementC implements ElementInterface{
    private String stateString;
    public ElementC(String stateString) {
        this.stateString=stateString;
    }
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visitElementC(this);
    }
    public void operationC(String stateString){
        this.stateString=stateString;
    }
    @Override
    public String toString() {
        return stateString;
    }
}
