package composite2;
import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Component>{
    Stack<Iterator<Component>> stack;
    public CompositeIterator(Iterator<Component> iterator) {
        stack = new Stack<>();
        this.stack.push(iterator);
    }
    @Override
    public boolean hasNext() {
        if(stack.isEmpty()){
            return false;
        } else{
            Iterator<Component> iterator = stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            } else{
                return true;
            }
        }
    }
    @Override
    public Component next() {
        if(hasNext()){
            Iterator<Component> iterator = stack.peek();
            Component component = iterator.next();
            if(component instanceof Composite){
                stack.push(component.getIterator());
            }
            return component;
        } else{
            return null;
        }
    }
}
