package observer;

public interface Observer {
    public void update();
    public void update(Observable o,DataObject data);
}
