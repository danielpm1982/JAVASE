package compound;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class ControllerStrategy implements StrategyInterface{
    private final SubjectInterface model;
    private final Player player;
    private final View view;
    public ControllerStrategy(SubjectInterface model, Player player) {
        this.model=model;
        this.player=player;
        ViewComponentAbstractFactoryInterface viewFactory = new ViewComponentConcreteFactory(this, player.getPlayerName(), player.getLabelPanelNumber());
        view = new View(viewFactory);
        registerThisObserver();
    }
    @Override
    public void aButtonInThisControllerViewWasClicked(JPanel lastPanelClickedByThisPlayer){
        player.setLastPanelClicked(lastPanelClickedByThisPlayer);
        player.addLastPanelClicked(((JLabel)lastPanelClickedByThisPlayer.getComponent(0)).getText());
        player.setClickCount(player.getClickCount()+1);
        model.buttonClicked(player);
        if(player.isOver()){
            view.endView();
        }
    }
    @Override
    public void registerThisObserver(){
        model.registerObserver(view);
    }
    @Override
    public void unRegisterThisObserver(){
        model.unregisterObserver(view);
    }
    @Override
    public JPanel getLastPanelClickedByThisPlayer() {
        return player.getLastPanelClicked();
    }
    @Override
    public void setLastPanelClickedByThisPlayer(JPanel lastPanelClickedByThisPlayer) {
        player.setLastPanelClicked(lastPanelClickedByThisPlayer);
    }
    @Override
    public String getTime(){
        return model.getTime();
    }
    @Override
    public Map<Player, List<String>> getAllLabelPanelClickedByEachPlayerMap() {
        return model.getAllLabelPanelClickedByEachPlayerMap();
    }
    @Override
    public List<String> getAllLabelPanelClickedByThisPlayerList() {
        return player.getAllLabelPanelClickedByThisPlayerStringList();
    }
}
