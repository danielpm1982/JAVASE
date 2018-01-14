package iterator2;
import java.util.Iterator;

public class Aggregate1Iterator implements Iterator<Object>{
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
//    @Override
//    public void remove() {
//        if(position<=0){
//            throw new IllegalStateException("Position cannot be 0. At least one next() must be done!");
//        }
//        if (itemArray[position-1] != null) { 
//            for (int i = position-1; i < (itemArray.length-1); i++) { 
//                itemArray[i] = itemArray[i+1];
//            } 
//            itemArray[itemArray.length-1] = null;
//        }
//    }
}
