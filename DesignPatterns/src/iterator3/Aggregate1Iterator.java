package iterator3;
import java.util.ListIterator;

public class Aggregate1Iterator implements ListIterator<ItemInterface>{
    private int position;
    private final ItemInterface[] itemArray;
    public Aggregate1Iterator(ItemInterface[] itemArray) {
        this.position=-1;
        this.itemArray=itemArray;
    }
    @Override
    public boolean hasNext() {
        if(position>=itemArray.length-1||(position>-1&&itemArray[position]==null)){
            return false;
        } else{
            return true;
        }
    }
    @Override
    public ItemInterface next() {
        return itemArray[++position];
    }
    @Override
    public void remove() {
        if(position<=0){
            throw new IllegalStateException("Position cannot be 0. At least one next() must be done!");
        }
        if (itemArray[position-1] != null) { 
            for (int i = position-1; i < (itemArray.length-1); i++) { 
                itemArray[i] = itemArray[i+1];
            } 
            itemArray[itemArray.length-1] = null;
        }
    }
    @Override
    public void add(ItemInterface i) {
        throw new UnsupportedOperationException("Not supported yet. Cannot increase this Aggregate's size for the new item! Item NOT added!");
    }
    @Override
    public boolean hasPrevious() {
        if((position)<0){
            return false;
        } else{
            return true;
        }
    }
    @Override
    public int nextIndex() {
        return position+1;
    }
    @Override
    public ItemInterface previous() {
        return itemArray[position--];
    }
    @Override
    public int previousIndex() {
        return (position);
    }
    @Override
    public void set(ItemInterface i) {
        itemArray[position]=i;
    }    
}
