package command;
public class GarageOpenCommand implements Command{
    private final GarageDoor garageDoor;
    private boolean isOpen;
    public GarageOpenCommand(GarageDoor garageDoor) {
        this.garageDoor=garageDoor;
        isOpen=false;
    }
    @Override
    public void execute() {
        garageDoor.open();
        isOpen=true;
    }
    @Override
    public void undo() {
        if(isOpen){
            garageDoor.close();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
