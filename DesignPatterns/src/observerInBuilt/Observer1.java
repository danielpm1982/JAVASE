package observerInBuilt;
import java.util.Observer;
import java.util.Observable;
public class Observer1 implements Observer,Display{
    private double temperatureInCelsius;
    private double altitudeInMeters;
    private double humidityInPercent;
    private String wind;
    private String forecast;
    public Observer1(Observable observable) {
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(arg!=null&&arg instanceof DataObject){ //PUSH
            DataObject data = (DataObject)arg;
            temperatureInCelsius=data.getTemperatureInCelcius();
            altitudeInMeters=data.getAltitudeInMeters();
            humidityInPercent=data.getHumidityInPercent();
            wind=data.getWind();
            forecast=data.getForecast();
        } else if(o!=null&&o instanceof MyObservable){ //PULL
            MyObservable ob = (MyObservable)o;
            temperatureInCelsius=ob.getTemperatureInCelcius();
            altitudeInMeters=ob.getAltitudeInMeters();
            humidityInPercent=ob.getHumidityInPercent();
            wind=ob.getWind();
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
        return "Observer1 -> temperature: "+temperatureInCelsius+" altitude: "+altitudeInMeters+" humidity: "+humidityInPercent+" wind: "+wind+" forecast: "+forecast;
    }    
}
