package command;
public class GarageCloseCommand implements Command{
    private final GarageDoor garageDoor;
    private boolean isClosed;
    public GarageCloseCommand(GarageDoor garageDoor) {
        this.garageDoor=garageDoor;
        isClosed=false;
    }
    @Override
    public void execute() {
        garageDoor.close();
        isClosed=true;
    }
    @Override
    public void undo() {
        if(isClosed){
            garageDoor.open();
        }
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
