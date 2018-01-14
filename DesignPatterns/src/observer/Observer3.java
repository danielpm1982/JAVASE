package observer;

public class Observer3 implements Observer,Display{
    private String forecast;
    Observable observable;
    public Observer3(Observable observable) {
        this.observable=observable;
        observable.registerObserver(this);
    }
    @Override
    public void update(Observable observable, DataObject data) {
        if(data!=null){ //PUSH
            forecast=data.getForecast();
        } else if(observable!=null){ //PULL
            forecast=observable.getForecast();
        }
        display();
    }
    @Override
    public void update() {
        update(observable, null);
    }
    @Override
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Observer3 -> forecast: "+forecast;
    }    
}
