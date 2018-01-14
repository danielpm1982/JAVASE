package flyWeight;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FlyWeightConcreteShared1 implements FlyWeight{
    Image image;
    Dimension dimension;
    JLabel label;
    public FlyWeightConcreteShared1() {
        dimension = new Dimension(100, 100);
        image = new ImageIcon(FlyWeightConcreteShared1.class.getResource("img1.png")).getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        label = new JLabel(new ImageIcon(image));
        label.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
    }
    @Override
    public void display(MyFrameInterface frame) {
        frame.addLabelInPanelInViewportInScrollPaneInContentPaneInFrame(label);
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" "+this.getClass().hashCode();
    }
}
