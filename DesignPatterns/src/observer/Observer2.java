package observer;

public class Observer2 implements Observer,Display{
    private double temperatureInCelsius;
    private double humidityInPercent;
    Observable observable;
    public Observer2(Observable observable) {
        this.observable=observable;
        observable.registerObserver(this);
    }
    @Override
    public void update(Observable observable, DataObject data) {
        if(data!=null){ //PUSH
            temperatureInCelsius=data.getTemperatureInCelcius();
            humidityInPercent=data.getHumidityInPercent();
        } else if(observable!=null){ //PULL
            temperatureInCelsius=observable.getTemperatureInCelcius();
            humidityInPercent=observable.getHumidityInPercent();
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
        return "Observer2 -> temperature: "+temperatureInCelsius+" humidity: "+humidityInPercent;
    }    
}
