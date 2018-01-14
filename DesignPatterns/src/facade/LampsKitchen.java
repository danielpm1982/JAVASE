package facade;
public class LampsKitchen {
    private boolean isOn;
    public LampsKitchen() {
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
        return "Lamps in the kitchen are "+(isOn?"ON!":"OFF!");
    }
}
