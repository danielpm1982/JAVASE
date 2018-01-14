package GenericList;

/**
 * @author Daniel
 * @param <T>
 */
public class QueueList <T>{
    private final LinkedListSingly<T> queueList;
    public QueueList() {
        queueList=new LinkedListSingly<>("queue");
    }
    public void enqueue (T dataObject){
        queueList.insertAtBack(dataObject);
    }
    public T dequeue() throws Exception{
        return queueList.removeFromFront();
    }
    public boolean isEmpty(){
        return queueList.isEmpty();
    }
    public void print(){
        queueList.print();
    }
}
