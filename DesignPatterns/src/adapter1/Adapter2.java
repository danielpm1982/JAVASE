package adapter1;
public class Adapter2 implements TargetInterface{
    private final Adaptee2 adaptee;
    public Adapter2(Adaptee2 adaptee) {
        this.adaptee=adaptee;
    }
    @Override
    public String targetMethod() {
        return adaptee.adapteeMethod();
    }
}
