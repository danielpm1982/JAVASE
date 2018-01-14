package observerInBuilt;
import java.util.Observable;
public class MyObservable extends Observable{
    private double temperatureInCelsius;
    private double altitudeInMeters;
    private double humidityInPercent;
    private String wind;
    private String forecast;
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
        setChanged();
//        notifyObservers();
        notifyObservers(new DataObject(temperatureInCelsius,altitudeInMeters,humidityInPercent,wind,forecast));
    }
}
