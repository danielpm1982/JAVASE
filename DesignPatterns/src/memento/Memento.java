package memento;
public class Memento implements MementoInterface{
    private final State state;
    public Memento(State state) {
        this.state=state;
    }
    @Override
    public State getState() {
        return state;
    }
}
