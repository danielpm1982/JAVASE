package command;
public class GarageDoor{
    private boolean isOpen;
    private boolean isClosed;
    public GarageDoor() {
        this.isOpen = false;
        this.isClosed = true;
    }
    public synchronized void open(){
        if(!isOpen){
            isClosed = false;
            isOpen = true;
        }
    }
    public synchronized void close(){
        if(!isClosed){
            isOpen = false;
            isClosed = true;
        }
    }
    public String getState(){
        if(isOpen){
            return "OPEN";
        } else{
            return "CLOSED";
        }
    }
}
