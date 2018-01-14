package observerInBuilt;
public class DataObject {
    private double temperatureInCelsius;
    private double altitudeInMeters;
    private double humidityInPercent;
    private String wind;
    private String forecast;
    public DataObject(double temperatureInCelsius, double altitudeInMeters, double humidityInPercent, String wind, String forecast) {
        this.temperatureInCelsius=temperatureInCelsius;
        this.altitudeInMeters=altitudeInMeters;
        this.humidityInPercent=humidityInPercent;
        this.wind=wind;
        this.forecast=forecast;
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
    public void setTemperatureInCelcius(double temperatureInCelcius) {
        this.temperatureInCelsius = temperatureInCelcius;
    }
    public void setAltitudeInMeters(double altitudeInMeters) {
        this.altitudeInMeters = altitudeInMeters;
    }
    public void setHumidityInPercent(double humidityInPercent) {
        this.humidityInPercent = humidityInPercent;
    }
    public void setWind(String wind) {
        this.wind = wind;
    }
    public void setForecast(String forecast) {
        this.forecast = forecast;
    }    
}
