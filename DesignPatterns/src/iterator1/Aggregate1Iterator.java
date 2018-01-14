package iterator1;
public class Aggregate1Iterator implements IteratorInterface{
    private int position;
    private final ItemInterface[] itemArray;
    public Aggregate1Iterator(ItemInterface[] itemArray) {
        this.position=0;
        this.itemArray=itemArray;
    }
    @Override
    public boolean hasNext() {
        if(position>=itemArray.length||itemArray[position]==null){
            return false;
        } else{
            return true;
        }
    }
    @Override
    public Object next() {
        return itemArray[position++];
    }
}
