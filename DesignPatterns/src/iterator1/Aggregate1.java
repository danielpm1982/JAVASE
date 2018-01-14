package iterator1;
public class Aggregate1 implements AggregateInterface{
    private final ItemInterface[] itemArray;
    public Aggregate1(ItemInterface... itemArray) {
        this.itemArray = itemArray;
    }
//    public ItemInterface[] getItemArray(){
//        return itemArray;
//    }
    @Override
    public IteratorInterface getIterator(){
        return new Aggregate1Iterator(itemArray);
    }
    @Override
    public int getSize(){
        return itemArray.length;
    }
    @Override
    public String toString() {
        return "Aggregate1";
    }
}
