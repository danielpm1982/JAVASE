package visitor;
public class ElementA implements ElementInterface{
    private String stateString;
    public ElementA(String stateString) {
        this.stateString=stateString;
    }
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visitElementA(this);
    }
    public void operationA(String stateString){
        this.stateString=stateString;
    }
    @Override
    public String toString() {
        return stateString;
    }
}
