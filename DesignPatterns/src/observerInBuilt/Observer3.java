package observerInBuilt;
import java.util.Observer;
import java.util.Observable;
public class Observer3 implements Observer,Display{
    private double temperatureInCelsius;
    public Observer3(Observable observable) {
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg!=null&&arg instanceof DataObject){ //PUSH
            DataObject data = (DataObject)arg;
            temperatureInCelsius=data.getTemperatureInCelcius();
        } else if(o!=null&&o instanceof MyObservable){ //PULL
            MyObservable ob = (MyObservable)o;
            temperatureInCelsius=ob.getTemperatureInCelcius();
        }
        display();
    }
    @Override
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Observer3 -> temperature: "+temperatureInCelsius;
    }    
}
