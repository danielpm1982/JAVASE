package mediator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Mediator implements MediatorInterface{
    List<ColleagueInterface> colleagueList;
    public Mediator() {
        this.colleagueList = new ArrayList<>();
    }
    @Override
    public void addColleagueArray(ColleagueInterface... colleagueArray) {
        colleagueList.addAll(Arrays.asList(colleagueArray));
    }
    @Override
    public void showAllColleagueInAscOrdered() {
        colleagueList.stream().sorted(Comparator.comparing(x->x.getClass().getSimpleName())).forEach(System.out::println);
    }
}
