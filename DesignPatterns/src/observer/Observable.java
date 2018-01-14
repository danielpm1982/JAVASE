package observer;
import java.util.ArrayList;
public class Observable implements Subject{
    private double temperatureInCelsius;
    private double altitudeInMeters;
    private double humidityInPercent;
    private String wind;
    private String forecast;
    private final ArrayList<Observer> observerList;
    public Observable() {
        observerList=new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        if(!observerList.contains(o)){
            observerList.add(o);
        }
    }
    @Override
    public void unregisterObserver(Observer o) { //PULL
        if(observerList.contains(o)){
            observerList.remove(o);
        }
    }
    @Override
    public void notifyObserver(Observable o,DataObject data) { //PUSH
        observerList.forEach(x->x.update(o,data));
    }
    @Override
    public void notifyObserver() {
        observerList.forEach(x->x.update(this,null));
    }
    public double getTemperatureInCelcius() {
        return temperatureInCelsius;
    }
    public double getAltitudeInMeters() {
        return altitudeInMeters;
    }
    public double getHumidityInPercent() {
        return humidityInPercent;
    }
    public String getWind() {
        return wind;
    }
    public String getForecast() {
        return forecast;
    }
    public void setData(double temperatureInCelsius, double altitudeInMeters, double humidityInPercent, String wind, String forecast){
        this.temperatureInCelsius=temperatureInCelsius;
        this.altitudeInMeters=altitudeInMeters;
        this.humidityInPercent=humidityInPercent;
        this.wind=wind;
        this.forecast=forecast;
        notifyObserver();
//        notifyObserver(this, new DataObject(temperatureInCelsius,altitudeInMeters,humidityInPercent,wind,forecast));
    }
}
