package proxy7;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Proxy implements SubjectInterface{
    JFrame frame;
    SubjectInterface subject;
    public Proxy(JFrame frame) {
        this.frame=frame;
    }
    @Override
    public void doSomething() {
        if(subject!=null){
            subject.doSomething();
        } else{
            setAndShowTempPanels();
            subject = new RealSubject(frame);
            this.doSomething();
        }
    }
    private void setAndShowTempPanels(){
        JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));
        panelNorth.setBackground(Color.BLACK);
        JLabel labelNorth = new JLabel("Waiting expensive resource to be created and loaded...",JLabel.CENTER);
        labelNorth.setFont(new Font(Font.MONOSPACED, Font.ITALIC+Font.BOLD, 20));
        labelNorth.setForeground(Color.WHITE);
        labelNorth.setBackground(Color.BLACK);
        panelNorth.add(labelNorth);
        frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));
        panelSouth.setBackground(Color.BLACK);
        JLabel labelSouth = new JLabel(new ImageIcon(this.getClass().getResource("loading.gif")));
        labelSouth.setBackground(Color.BLACK);
        panelSouth.add(labelSouth);
        frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
