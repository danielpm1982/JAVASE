package composite1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite1 implements Component, Composite{
    private final List<Component> componentList;
    public Composite1(Component... componentArray) {
        componentList = new ArrayList<>();
        componentList.addAll(Arrays.asList(componentArray));
    }
    @Override
    public int getSize(){
        return componentList.size();
    }
    public String getDescription() {
        return "Composite1Type";
    }
    @Override
    public String toString() {
        return getDescription();
    }
    @Override
    public void add(Component component) {
        componentList.add(component);
    }
    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }
    @Override
    public Component getChild(int i) {
        return componentList.get(i);
    }
    @Override
    public void list() {
        System.out.println("\nComponent "+this+" - size: "+getSize()+" elements:");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        componentList.iterator().forEachRemaining(Component::list); //polymorphic recursive listing (for Composite and Leaf objects, regardless). Pre-order tree traversal.
    }
}
