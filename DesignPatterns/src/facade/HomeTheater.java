package facade;
public class HomeTheater {
    private boolean isOn;
    public HomeTheater() {
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
        return "HomeTheater is "+(isOn?"ON!":"OFF!");
    }
}
