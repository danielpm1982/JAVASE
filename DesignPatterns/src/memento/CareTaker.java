package memento;
public class CareTaker {
    private MementoInterface memento;
    public CareTaker() {
    }
    public void saveStateInMementoFromOriginator(OriginatorInterface originator){
        this.memento=originator.createMemento();
    }
    public void loadStateInOriginatorFromMemento(OriginatorInterface originator){
        originator.setStateFromMemento(memento);
    }
}
