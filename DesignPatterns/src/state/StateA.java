package state;
public class StateA implements State{
    private final Context context;
    public StateA(Context context) {
        this.context=context;
    }
    @Override
    public void actionTurnOn() {
        System.out.println("Error: no action performed! Already turned ON!");
    }
    @Override
    public void actionTurnOff() {
        if(context.getState() instanceof StateA){
            System.out.println("Turning OFF... from state A!");
            context.setState(context.getStateOff());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public void actionChangeToNextState() {
        if(context.getState() instanceof StateA){
            System.out.println("Changing from state A to state B!");
            context.setState(context.getStateB());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public String toString() {
        return "state A";
    }
}
