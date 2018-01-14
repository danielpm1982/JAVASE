package memento;
public interface OriginatorInterface {
    public void setStateFromUserInput(State state);
    public abstract void setStateFromMemento(MementoInterface memento);
    public abstract MementoInterface createMemento();
}
