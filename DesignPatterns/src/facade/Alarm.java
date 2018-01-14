package facade;
public class Alarm {
    private boolean isOn;
    public Alarm() {
        isOn=false;
    }
    public void turnOn(){
        if(!isOn){
            isOn=true;
        }
    }
    public void turnOff(){
        if(isOn){
            isOn=false;
        }
    }
    @Override
    public String toString() {
        return "Alarms are "+(isOn?"ON!":"OFF!");
    }
}
