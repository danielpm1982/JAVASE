package facade;
public class BlueRay {
    private boolean isOn;
    public BlueRay() {
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
        return "BlueRay is "+(isOn?"ON!":"OFF!");
    }
}
