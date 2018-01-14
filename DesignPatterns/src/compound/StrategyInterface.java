package compound;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public interface StrategyInterface {
    public void aButtonInThisControllerViewWasClicked(JPanel lastPanelClickedByThisPlayer);
    public void registerThisObserver();
    public void unRegisterThisObserver();
    public JPanel getLastPanelClickedByThisPlayer();
    public void setLastPanelClickedByThisPlayer(JPanel lastPanelClickedByThisPlayer);
    public String getTime();
    public Map<Player, List<String>> getAllLabelPanelClickedByEachPlayerMap();
    public List<String> getAllLabelPanelClickedByThisPlayerList();
}
