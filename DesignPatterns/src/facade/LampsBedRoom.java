package facade;
public class LampsBedRoom {
    private boolean isOn;
    public LampsBedRoom() {
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
        return "Lamps in the bedrooms are "+(isOn?"ON!":"OFF!");
    }
}
