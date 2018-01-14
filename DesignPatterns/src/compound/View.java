package compound;
import javax.swing.JFrame;

public final class View implements ObserverInterface{
    JFrame frame;
    ViewComponentAbstractFactoryInterface viewFactory;
    public View(ViewComponentAbstractFactoryInterface viewFactory) {
        this.viewFactory=viewFactory;
        frame = this.viewFactory.createJFrameWithLabelAndPanelAndButton();
        frame.setVisible(true);
    }
    @Override
    public void update() {
        viewFactory.update(frame);
    }
    @Override
    public void endView(){
        viewFactory.endView(frame);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
