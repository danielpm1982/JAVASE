package mediator;
public class Colleague1 implements ColleagueInterface{
    private final MediatorInterface mediator;
    public Colleague1(MediatorInterface mediator) {
        this.mediator=mediator;
    }
    @Override
    public void showYourself() {
        mediator.showAllColleagueInAscOrdered();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
