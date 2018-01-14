package mediator;
public class Colleague3 implements ColleagueInterface{
    private final MediatorInterface mediator;
    public Colleague3(MediatorInterface mediator) {
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
