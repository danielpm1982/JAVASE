package observer;

public class Observer1 implements Observer,Display{
    private double temperatureInCelsius;
    private double altitudeInMeters;
    private double humidityInPercent;
    private String wind;
    private String forecast;
    Observable observable;
    public Observer1(Observable observable) {
        this.observable=observable;
        observable.registerObserver(this);
    }
    @Override
    public void update(Observable observable, DataObject data) {
        if(data!=null){ //PUSH
            temperatureInCelsius=data.getTemperatureInCelcius();
            altitudeInMeters=data.getAltitudeInMeters();
            humidityInPercent=data.getHumidityInPercent();
            wind=data.getWind();
            forecast=data.getForecast();
        } else if(observable!=null){ //PULL
            temperatureInCelsius=observable.getTemperatureInCelcius();
            altitudeInMeters=observable.getAltitudeInMeters();
            humidityInPercent=observable.getHumidityInPercent();
            wind=observable.getWind();
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
        return "Observer1 -> temperature: "+temperatureInCelsius+" altitude: "+altitudeInMeters+" humidity: "+humidityInPercent+" wind: "+wind+" forecast: "+forecast;
    }    
}
