package composite2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Composite implements Component{
    private final String description;
    private final List<Component> list;
    public Composite(String description, Component... initialComponents) {
        this.description=description;
        list = new ArrayList<>();
        list.addAll(Arrays.asList(initialComponents));
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void list() {
        list.forEach(Component::list);
    }
    @Override
    public void add(Component component) {
        list.add(component);
    }
    @Override
    public void remove(Component component) {
        list.remove(component);
    }
    @Override
    public Component getComponent(int i) {
        return list.get(i);
    }
    @Override
    public Integer sum() {
        Integer result=0;
        Iterator<Component> iterator = list.iterator();
        while(iterator.hasNext()){
            Component c = iterator.next();
            if(c instanceof Leaf){
                result+=c.getValue();
            } else{
                result+=c.sum();
            }
        }
        return result;
    }
//    @Override
//    public Long multiplicationOfNonZeroValues() {
//        Long result=1L;
//        Iterator<Component> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Component c = iterator.next();
//            if(c instanceof Leaf){
//                if(c.getValue()!=0){
//                    result*=c.getValue();
//                }
//            } else{
//                result*=c.multiplicationOfNonZeroValues();
//            }
//        }
//        return result;
//    }
    @Override
    public Long multiplicationOfNonZeroValues() {
        return getNonZeroValuesList().stream().reduce(1L, (a,b)->a*b);
    }
    @Override
    public List<Long> getNonZeroValuesList(){
        List<Long> tempList = new ArrayList<>();
        Iterator<Component> iterator = list.iterator();
        while(iterator.hasNext()){
            Component c = iterator.next();
            if(c instanceof Leaf){
                if(c.getValue()!=0){
                    tempList.add(c.getValue().longValue());
                }
            } else{
                if(c instanceof Composite){
                    tempList.addAll(((Composite)c).getNonZeroValuesList());
                }
            }
        }
        return tempList;
    }
//    @Override
//    public List<Integer> getAllValuesList(){
//        List<Integer> tempList = new ArrayList<>();
//        Iterator<Component> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Component c = iterator.next();
//            if(c instanceof Leaf){
//                tempList.add(c.getValue());
//            } else{
//                if(c instanceof Composite){
//                    tempList.addAll(c.getAllValuesList());
//                }
//            }
//        }
//        return tempList;
//    }
    @Override
    public List<Integer> getAllValuesList(){
        List<Integer> tempList = new ArrayList<>();
        list.forEach(t -> {
            if(t instanceof Leaf){
                tempList.add(t.getValue());
            } else{
                tempList.addAll(t.getAllValuesList());
            }
        });
        return tempList;
    }
    @Override
    public Iterator<Component> getIterator() {
        return new CompositeIterator(list.iterator());
    }
    @Override
    public String toString() {
        return getDescription();
    }
}
