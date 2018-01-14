package visitor;
public class ElementB implements ElementInterface{
    private String stateString;
    public ElementB(String stateString) {
        this.stateString=stateString;
    }
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visitElementB(this);
    }
    public void operationB(String stateString){
        this.stateString=stateString;
    }
    @Override
    public String toString() {
        return stateString;
    }
}
