package decorator2;
public class Decorator2 implements Decorator{
    UniqueInterface componentToAdd;
    public Decorator2(UniqueInterface componentToAdd) {
        this.componentToAdd=componentToAdd;
    }
    @Override
    public String display() {
        return componentToAdd.display()+" "+this.getClass().getSimpleName();
    }
}
