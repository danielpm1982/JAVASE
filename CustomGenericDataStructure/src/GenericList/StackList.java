package GenericList;
 /*
 * @author Daniel
 * @param <T>
 */
public class StackList <T>{
    private final LinkedListSingly<T> stackList;
    public StackList() {
        stackList=new LinkedListSingly<>("stack");
    }
    public void push (T dataObject){
        stackList.insertAtFront(dataObject);
    }
    public T pop ()throws Exception{
        return stackList.removeFromFront();
    }
    public boolean isEmpty(){
        return stackList.isEmpty();
    }
    public void print(){
        stackList.print();
    }
}
