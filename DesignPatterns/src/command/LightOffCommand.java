package command;
public class LightOffCommand implements Command{
    private final Light light;
    private boolean lightOff;
    public LightOffCommand(Light light) {
        this.light=light;
        lightOff=false;
    }
    @Override
    public void execute() {
        light.turnOff();
        lightOff=true;
    }
    @Override
    public void undo() {
        if(lightOff){
            light.turnOn();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
