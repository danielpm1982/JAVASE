package command;
public class Light {
    private boolean lightIsOn;
    public Light() {
        lightIsOn=false;
    }
    public void turnOn(){
        lightIsOn=true;
    }
    public void turnOff(){
        lightIsOn=false;
    }
    public String getState(){
        if(lightIsOn){
            return "ON";
        }
        return "OFF";
    }
}
