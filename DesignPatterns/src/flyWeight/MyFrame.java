package flyWeight;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public final class MyFrame extends JFrame implements MyFrameInterface{
    private final JPanel panel;
    public MyFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setTitle("FlyWeight GOF Design Pattern");
        JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setPreferredSize(new Dimension(700, 23000));
        panel.setBackground(Color.BLACK);
        scrollPane.getViewport().add(panel);
        getContentPane().add(scrollPane);
//        setVisible(true);
    }
    @Override
    public void addLabelInPanelInViewportInScrollPaneInContentPaneInFrame(JLabel label){
        addLabelAction(label);
        ((JPanel)((JViewport)((JScrollPane)(this.getContentPane().getComponent(0))).getComponent(0)).getComponent(0)).add(label);
//        this.repaint();
//        this.setVisible(true);
    }
    private void addLabelAction(JLabel label){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((JPanel)((JViewport)((JScrollPane)(MyFrame.this.getContentPane().getComponent(0))).getComponent(0)).getComponent(0)).remove(label);
                MyFrame.this.repaint();
                MyFrame.this.setVisible(true);
            }
        });
    }
}
