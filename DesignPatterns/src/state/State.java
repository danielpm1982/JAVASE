package state;
public interface State {
    public abstract void actionTurnOn();
    public abstract void actionTurnOff();
    public abstract void actionChangeToNextState();
}
