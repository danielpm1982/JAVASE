package facade;
public class VideoGameConsole {
    private boolean isOn;
    public VideoGameConsole() {
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
        return "VideoGame console is "+(isOn?"ON!":"OFF!");
    }
}
