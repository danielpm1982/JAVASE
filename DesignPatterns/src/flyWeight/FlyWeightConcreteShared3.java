package flyWeight;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FlyWeightConcreteShared3 implements FlyWeight{
    Image image;
    Dimension dimension;
    JLabel label;
    public FlyWeightConcreteShared3() {
        dimension = new Dimension(150, 150);
        image = new ImageIcon(FlyWeightConcreteShared3.class.getResource("img3.png")).getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        label = new JLabel(new ImageIcon(image));
        label.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
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
