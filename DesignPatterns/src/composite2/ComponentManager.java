package composite2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentManager {    
    private final Component component;
    public ComponentManager(Component component) {
        this.component=component;
    }
    public static Component create(){
        Leaf leaf0 = new Leaf("leaf0", 0);
        Leaf leaf5 = new Leaf("leaf5", 5);
        Leaf leaf10 = new Leaf("leaf10", 10);
        Leaf leaf15 = new Leaf("leaf15", 15);
        Leaf leaf20 = new Leaf("leaf20", 20);
        Composite c1 = new Composite("composite1", leaf0, leaf5, leaf10, leaf15, leaf20);
        Composite c2 = new Composite("composite2", leaf0, leaf5);
        Composite c3 = new Composite("composite3", leaf10, leaf15, leaf20);
        Composite c4 = new Composite("composite4", leaf0);
        Composite c5 = new Composite("composite5", leaf20);        
        Composite root = new Composite("compositeRoot", c1,leaf15,c2,c3,leaf10,c4,c5,leaf5);
        return root;
    }
    public void list(){
        component.list();
    }
    public void sum(){
        System.out.println("Sum: "+component.sum());
    }
    public void product(){
        System.out.println("Product: "+component.multiplicationOfNonZeroValues());
    }
    public void listAllValues(){
        List<Integer> list = component.getAllValuesList();
        System.out.print("All values ("+list.size()+"): ");
        System.out.println(list+" (internal Iterator)");
    }
    public void listAllValuesThroughExternalIterator(){
        List<Integer> list = component.getAllValuesList();
        System.out.print("All values ("+list.size()+"): ");
        list = new ArrayList<>();
        Iterator<Component> iterator = component.getIterator();
        while(iterator.hasNext()){
            Component nextComponent = iterator.next();
            if(nextComponent instanceof Leaf){
                list.add(nextComponent.getValue());
            }
        }
        System.out.println(list+" (external Iterator)");
    }
    public void listNonZeroValues(){
        List<Long> list = component.getNonZeroValuesList();
        System.out.print("All non zero values ("+list.size()+"): ");
        System.out.println(list);
    }
}
