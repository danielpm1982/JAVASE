package iterator4;
import java.util.Arrays;
import java.util.List;

public class AggregateIterator implements AggregateIteratorInterface{
    private final List<Item> itemList;
    public AggregateIterator(Item... itemArray) {
        this.itemList=Arrays.asList(itemArray);
    }
    @Override
    public void list() {
        itemList.stream().forEach(System.out::println);
    }
    @Override
    public void listOrdered() {
        itemList.stream().sorted().forEach(System.out::println);
    }
    @Override
    public void listReversed() {
        itemList.stream().sorted(ItemComparator.getInstance().reversed()).forEach(System.out::println);
    }
}
