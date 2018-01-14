package composite1;
import java.util.Arrays;
import java.util.List;

public class CompositeCreator {
    public static List<Component> create() { //every Composite here is a separate hierarchy, and more than one is returned in a list.
        Component subC1A = new Composite1(new Leaf("yet another Leaf"));
        Component subC1B = new Composite1(new Leaf());
        Component c1 = new Composite1(new Leaf(), new Leaf("just another Leaf"), new Leaf(555, "Leaf3", "a third Leaf"), subC1A, subC1B);
        Component c2 = new Composite2();
        return Arrays.asList(c1,c2);
    }
}
