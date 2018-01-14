package observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObserver();
    public void notifyObserver(Observable o, DataObject data);
}
