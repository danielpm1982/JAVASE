package adapter1;
public class Adapter1 implements TargetInterface{
    private final Adaptee1 adaptee;
    public Adapter1(Adaptee1 adaptee) {
        this.adaptee=adaptee;
    }
    @Override
    public String targetMethod() {
        return adaptee.adapteeMethod();
    }
}
