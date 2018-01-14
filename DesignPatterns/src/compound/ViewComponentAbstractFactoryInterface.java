package compound;
import javax.swing.*;

public interface ViewComponentAbstractFactoryInterface {
    public JFrame createJFrameWithLabelAndPanelAndButton();
    public void update(JFrame frame);
    public void endView(JFrame frame);
}
