package facade;
public class TV {
    private boolean isOn;
    public TV() {
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
        return "TV is "+(isOn?"ON!":"OFF!");
    }
}
