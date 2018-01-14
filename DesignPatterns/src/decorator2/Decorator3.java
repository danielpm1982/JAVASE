package decorator2;
public class Decorator3 implements Decorator{
    UniqueInterface componentToAdd;
    public Decorator3(UniqueInterface componentToAdd) {
        this.componentToAdd=componentToAdd;
    }
    @Override
    public String display() {
        return componentToAdd.display()+" "+this.getClass().getSimpleName();
    }
}
