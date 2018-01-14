package GenericList;
/**
 *
 * @author Daniel
 * @param <T>
 */
public class ListNode <T>{
    private T data;
    private ListNode<T> nextNode;
    
    public ListNode(T data) {
        this(data,null);
    }
    
    public ListNode(T data,ListNode<T> nextNode){
        this.data=data;
        this.nextNode=nextNode;
    }
    
    public T getData() {
        return data;
    }

    public ListNode<T> getNextNode() {
        return nextNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    
}
