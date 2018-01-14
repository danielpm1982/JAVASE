package GenericList;

/**
 *
 * @author Daniel
 * @param <T>
 */
public class LinkedListSingly <T>{
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    String nameList;
    
    public LinkedListSingly() {
        this("list");
    }

    public LinkedListSingly(String nameList) {
        this.nameList = nameList;
        firstNode=lastNode=null;
    }
    
    public void insertAtFront(T dataObject){
        if(isEmpty()){
            firstNode=lastNode=new ListNode<>(dataObject);
        } else{
            firstNode=new ListNode<>(dataObject, firstNode);
        }
    }
    
    public void insertAtBack(T dataObject){
        if(isEmpty()){
            firstNode=lastNode=new ListNode<>(dataObject);
        } else{
            ListNode<T> newNode = new ListNode<>(dataObject); 
            lastNode.setNextNode(newNode);
            lastNode=newNode;
        }
    }
    
    public T removeFromFront() throws Exception{
        if (isEmpty()){
            throw new Exception("ERROR: List Empty!");
        }
        T removedData = firstNode.getData();
        if(firstNode==lastNode){
            firstNode=lastNode=null;
        } else{
            firstNode=firstNode.getNextNode();
        }
        return removedData;
    }
    
    public T removeFromBack() throws Exception{
        if(isEmpty()){
            throw new Exception("ERROR: List Empty!");
        }
        T removedData = lastNode.getData();
        if(firstNode==lastNode){
            firstNode=lastNode=null;
        } else{
            ListNode<T> current = firstNode;
            while(current.getNextNode()!=lastNode){
                current=current.getNextNode();
            }
            current.setNextNode(null);
            lastNode=current;
        }
        return removedData;
    }
    
    public boolean isEmpty(){
        return firstNode==null;
        //return lastNode==null;
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("List "+nameList+":\nEmpty List!\n");
        } else{
            System.out.println("List "+nameList+":");
            ListNode<T> current = firstNode;
            while(current!=null){
                System.out.println(current.getData());
                current=current.getNextNode();
            }
        }
    }
}
