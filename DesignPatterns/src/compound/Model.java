package compound;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements SubjectInterface{
    private final List<ObserverInterface> observerList;
    private final Map<Player, List<String>> allLabelPanelClickedByEachPlayerMap;
    public Model() {
        observerList = new ArrayList<>();
        allLabelPanelClickedByEachPlayerMap = new HashMap<>();
    }
    @Override
    public void registerObserver(ObserverInterface o) {
        if(!observerList.contains(o)){
            observerList.add(o);
        }
    }
    @Override
    public void unregisterObserver(ObserverInterface o) {
        if(observerList.contains(o)){
            observerList.remove(o);
        }
    }
    @Override
    public void notifyObserver() {
        observerList.forEach(x->x.update());
    }
    @Override
    public void buttonClicked(Player player) {
        List<String> tempList = new ArrayList<>();
        tempList.addAll(player.getAllLabelPanelClickedByThisPlayerStringList());
        this.allLabelPanelClickedByEachPlayerMap.put(player, tempList);
        System.out.println(player.getPlayerName()+": "+tempList.get(tempList.size()-1)+" clicked! ("+this.getTime()+")");
        notifyObserver();
        if(player.getClickCount()==player.getMaxClickCount()){
            player.setOver(true);
        }
    }
    @Override
    public Map<Player, List<String>> getAllLabelPanelClickedByEachPlayerMap() {
        return allLabelPanelClickedByEachPlayerMap;
    }
    @Override
    public String getTime(){
        return LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}
