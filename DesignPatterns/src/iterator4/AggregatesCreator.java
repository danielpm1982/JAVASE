package iterator4;
import java.util.Arrays;
import java.util.List;

public class AggregatesCreator {
    public static List<AggregateInterface> create() {
        AggregateInterface a1 = new Aggregate(new Item(), new Item("just another item"), new Item(555, "Item3", "a third item"), new Item(), new Item());
        return Arrays.asList(a1);
    }
}
