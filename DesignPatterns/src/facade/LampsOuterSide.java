package facade;
public class LampsOuterSide {
    private boolean isOn;
    public LampsOuterSide() {
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
        return "Lamps in the outer side are "+(isOn?"ON!":"OFF!");
    }
}
