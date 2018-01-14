package state;
public class StateB implements State{
    private final Context context;
    public StateB(Context context) {
        this.context=context;
    }
    @Override
    public void actionTurnOn() {
        System.out.println("Error: no action performed! Already turned ON!");
    }
    @Override
    public void actionTurnOff() {
        if(context.getState() instanceof StateB){
            System.out.println("Turning OFF... from state B!");
            context.setState(context.getStateOff());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public void actionChangeToNextState() {
        if(context.getState() instanceof StateB){
            System.out.println("Changing from state B to state C!");
            context.setState(context.getStateC());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public String toString() {
        return "state B";
    }
}
