package memento;

public class Originator implements OriginatorInterface{
    private State currentState; //stores only the current state, not previous states (these are stored at the Memento object and retrieved when needed)
    public Originator() {
    }
    @Override
    public void setStateFromUserInput(State state) {
        this.currentState = state;
    }
    @Override
    public void setStateFromMemento(MementoInterface memento) { //restoring old state from Memento object
        this.currentState=memento.getState();
    }
    @Override
    public MementoInterface createMemento() {
        return new Memento(currentState);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+currentState;
    }
}
