package state;
public class Context {
    private final State stateA;
    private final State stateB;
    private final State stateC;
    private final State stateOff;
    private State state;
    private Context() {
        stateA = new StateA(this);
        stateB = new StateB(this);
        stateC = new StateC(this);
        stateOff = new StateOff(this);
        state=stateOff;
    }
    public static Context getInstance(){
        return new Context();
    }
    public void actionTurnOn(){
        state.actionTurnOn();
    }
    public void actionTurnOff(){
        state.actionTurnOff();
    }
    public void actionChangeToNextState(){
        state.actionChangeToNextState();
    }
    public void printCurrentState(){
        System.out.println("Current state is: "+state);
    }
    State getStateOff() {
        return stateOff;
    }
    State getStateA() {
        return stateA;
    }
    State getStateB() {
        return stateB;
    }
    State getStateC() {
        return stateC;
    }
    State getState() {
        return state;
    }
    void setState(State state) {
        this.state = state;
    }
}
