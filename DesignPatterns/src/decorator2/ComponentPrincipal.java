package decorator2;
public class ComponentPrincipal implements UniqueInterface{
    public ComponentPrincipal() {
    }
    @Override
    public String display() {
        return this.getClass().getSimpleName();
    }
}
