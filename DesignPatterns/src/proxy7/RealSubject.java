package proxy7;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RealSubject implements SubjectInterface{
    JFrame frame;
    ImageIcon imageIcon;
    JLabel label;
    public RealSubject(JFrame frame) {
        this.frame=frame;
        createLabel();
        setStateWindowListener();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public void doSomething() {
        updateContentPaneWithLabel();
    }
    private void createLabel(){
            imageIcon  = new ImageIcon(new ImageIcon(this.getClass().getResource("img.jpg")).getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), java.awt.Image.SCALE_SMOOTH));
            label = new JLabel(imageIcon);
            label.setBackground(Color.BLACK);
    }
    private void updateContentPaneWithLabel(){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.repaint();
        frame.setVisible(true);
    }
    private void setStateWindowListener(){
        frame.addWindowStateListener(e->{createLabel();updateContentPaneWithLabel();});
    }
}
