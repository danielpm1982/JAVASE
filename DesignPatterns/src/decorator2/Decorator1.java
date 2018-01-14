package decorator2;
public class Decorator1 implements Decorator{
    UniqueInterface componentToAdd;
    public Decorator1(UniqueInterface componentToAdd) {
        this.componentToAdd=componentToAdd;
    }
    @Override
    public String display() {
        return componentToAdd.display()+" "+this.getClass().getSimpleName();
    }
}
