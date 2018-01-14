package iterator3;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AggregatesCreator {
    public static List<AggregateInterface> create() {
        List<AggregateInterface> list = new ArrayList<>();
        AggregateInterface a1 = new Aggregate1(new Item(), new Item("just another item"), new Item(555, "Item3", "a third item"), new Item(), new Item());
        list.add(a1);
        AggregateInterface a2 = new Aggregate1(new Item(), new Item("just another item"), new Item(555, "Item3", "a third item"), new Item(), new Item());
        alterThirdItem(a2, new Item("Daniel's"));
        list.add(a2);
        AggregateInterface a3 = new Aggregate2(new Item(), new Item("just another item"), new Item(555, "item3", "a third item"), new Item(), new Item());
        list.add(a3);
        AggregateInterface a4 = new Aggregate2(new Item(), new Item("just another item"), new Item(555, "item3", "a third item"), new Item(), new Item());
        alterThirdItem(a4, new Item("Daniel's"));
        list.add(a4);
        AggregateInterface a5 = new Aggregate3(new Item(), new Item("just another item"), new Item(555, "item3", "a third item"), new Item(), new Item());
        list.add(a5);
        return list;
    }
    private static void alterThirdItem(AggregateInterface aggregate, ItemInterface item){
        ListIterator<ItemInterface> iterator = aggregate.getIterator();
        while(iterator.nextIndex()<=2){
            iterator.next();
        }
        iterator.set(item);
    }
}