package command;
public class LightOnCommand implements Command{
    private final Light light;
    private boolean lightOn;
    public LightOnCommand(Light light) {
        this.light=light;
        lightOn=false;
    }
    @Override
    public void execute() {
        light.turnOn();
        lightOn=true;
    }
    @Override
    public void undo() {
        if(lightOn){
            light.turnOff();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
