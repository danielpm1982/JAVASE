package facade;
public class AllObjectsFacade {
    IlluminationAlarmFacade illuminationAlarmFacade;
    AudioVisualFacade audioVisualFacade;
    public AllObjectsFacade(IlluminationAlarmFacade illuminationAlarmFacade, AudioVisualFacade audioVisualFacade) {
        this.illuminationAlarmFacade = illuminationAlarmFacade;
        this.audioVisualFacade = audioVisualFacade;
    }

    public AllObjectsFacade() {
        illuminationAlarmFacade=new IlluminationAlarmFacade();
        audioVisualFacade=new AudioVisualFacade();
    }
    
    public void turnOn(){
        illuminationAlarmFacade.turnOn();
        audioVisualFacade.turnOn();
    }
    public void turnOff(){
        illuminationAlarmFacade.turnOff();
        audioVisualFacade.turnOff();
    }
    @Override
    public String toString() {
        return illuminationAlarmFacade+" "+audioVisualFacade;
    }
}
