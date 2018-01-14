package state;
public class StateC implements State{
    private final Context context;
    public StateC(Context context) {
        this.context=context;
    }
    @Override
    public void actionTurnOn() {
        System.out.println("Error: no action performed! Already turned ON!");
    }
    @Override
    public void actionTurnOff() {
        if(context.getState() instanceof StateC){
            System.out.println("Turning OFF... from state C!");
            context.setState(context.getStateOff());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public void actionChangeToNextState() {
        if(context.getState() instanceof StateC){
            System.out.println("Changing from state C to state A!");
            context.setState(context.getStateA());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public String toString() {
        return "state C";
    }
}
