package facade;
public class LampsLivingRoom {
    private boolean isOn;
    public LampsLivingRoom() {
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
        return "Lamps in the living room are "+(isOn?"ON!":"OFF!");
    }
}
