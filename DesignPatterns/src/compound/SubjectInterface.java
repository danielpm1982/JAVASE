package compound;
import java.util.List;
import java.util.Map;

public interface SubjectInterface {
    public abstract void registerObserver(ObserverInterface o);
    public abstract void unregisterObserver(ObserverInterface o);
    public abstract void notifyObserver();
    public abstract void buttonClicked(Player player);
    public Map<Player, List<String>> getAllLabelPanelClickedByEachPlayerMap();
    public String getTime();
}
