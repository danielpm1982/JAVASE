package state;
public class StateOff implements State{
    Context context;
    public StateOff(Context context) {
        this.context=context;
    }
    @Override
    public void actionTurnOn() {
        if(context.getState() instanceof StateOff){
            System.out.println("Turning ON... to state A!");
            context.setState(context.getStateA());
        } else{
            System.out.println("Error: no action performed!");
        }
    }
    @Override
    public void actionTurnOff() {
        System.out.println("Error: no action performed! Already turned Off!");
    }
    @Override
    public void actionChangeToNextState() {
        actionTurnOn();
    }
    @Override
    public String toString() {
        return "state Off";
    }
}
