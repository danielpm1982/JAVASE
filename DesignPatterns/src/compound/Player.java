package compound;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Player {
    private boolean over;
    private final String playerName;
    private JPanel lastPanelClicked;
    private int clickCount;
    private final int MAX_CLICK_COUNT;
    private final int LABEL_PANEL_NUMBER;
    private final List<String> allLabelPanelClickedByThisPlayerStringList;
    public Player(String playerName, int maxClickCount, int labelPanelNumber) {
        this.playerName=playerName;
        clickCount=0;
        this.MAX_CLICK_COUNT=maxClickCount;
        this.LABEL_PANEL_NUMBER=labelPanelNumber;
        allLabelPanelClickedByThisPlayerStringList=new ArrayList<>();
    }
    public String getPlayerName() {
        return playerName;
    }
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public void setLastPanelClicked(JPanel lastPanelClicked) {
        this.lastPanelClicked = lastPanelClicked;
    }
    public JPanel getLastPanelClicked() {
        return lastPanelClicked;
    }
    public int getClickCount() {
        return clickCount;
    }
    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }
    public int getMaxClickCount() {
        return MAX_CLICK_COUNT;
    }
    public int getLabelPanelNumber() {
        return LABEL_PANEL_NUMBER;
    }
    public void addLastPanelClicked(String lastPanelClickedString){
        allLabelPanelClickedByThisPlayerStringList.add(lastPanelClickedString);
    }
    public List<String> getAllLabelPanelClickedByThisPlayerStringList() {
        return allLabelPanelClickedByThisPlayerStringList;
    }
    @Override
    public String toString() {
        return playerName+" is: "+(over?"Over!":"On!");
    }
}
