package composite2;
import java.util.Iterator;

public class Leaf implements Component{
    private final String description;
    private final Integer value;
    public Leaf() {
        this("no description!",-1);
    }
    public Leaf(String description, Integer value) {
        this.description=description;
        this.value=value;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public Integer getValue() {
        return value;
    }
    @Override
    public void list() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return String.format("description:  "+"%-7s"+" value: "+"%3s", description, value);
    }
    @Override
    public Iterator<Component> getIterator() {
        return new NullIterator();
    }
}
