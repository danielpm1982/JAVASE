package observerInBuilt;
import java.util.Observer;
import java.util.Observable;
public class Observer2 implements Observer,Display{
    private double temperatureInCelsius;
    private String forecast;
    public Observer2(Observable observable) {
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg!=null&&arg instanceof DataObject){ //PUSH
            DataObject data = (DataObject)arg;
            temperatureInCelsius=data.getTemperatureInCelcius();
            forecast=data.getForecast();
        } else if(o!=null&&o instanceof MyObservable){ //PULL
            MyObservable ob = (MyObservable)o;
            temperatureInCelsius=ob.getTemperatureInCelcius();
            forecast=ob.getForecast();
        }
        display();
    }
    @Override
    public void display() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Observer2 -> temperature: "+temperatureInCelsius+" forecast: "+forecast;
    }    
}
