package compound;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyButtonJPanel extends JPanel{
    public MyButtonJPanel() {
    }
    public MyButtonJPanel(LayoutManager layout) {
        super(layout);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(getClass().getResource("buttonPanel.png")).getImage();
        g.drawImage(image, 0, 0, this);
    }
}
