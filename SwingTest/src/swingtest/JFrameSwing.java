package swingtest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameSwing extends JFrame{
    public JFrameSwing(){
        String s="";
        while (s.compareTo("Daniel")!=0){
            try{
                s = obtainString();
            }
            catch(ObtainStringException e){
                JOptionPane.showMessageDialog(null, "Nome: "+e.getString()+" inválido! DIGITE 'Daniel' !!!!");
            }
        }
        final JPanel panel1 = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());
        final JPanel panel3 = new JPanel(new BorderLayout());
        final JLabel label = new JLabel(s, JLabel.CENTER);
        Font font = new Font("fontD", Font.BOLD, 30);
        label.setFont(font);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "You've Clicked at x="+e.getX()+" and y="+e.getY()+" !");
            }
        });
        panel1.add(new JLabel("1"),BorderLayout.LINE_START);
        panel1.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel1.setBackground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e) {
                panel1.setBackground(Color.RED);
            }
            
        });
        panel2.add(label,BorderLayout.CENTER);
        label.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel2.setBackground(Color.BLACK);
                label.setForeground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                panel2.setBackground(Color.WHITE);
                label.setForeground(Color.BLACK);
            }
        });
        panel3.add(new JLabel("3"),BorderLayout.LINE_END);
        panel3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel3.setBackground(Color.MAGENTA);
            }
            public void mouseExited(MouseEvent e) {
                panel3.setBackground(Color.GREEN);
            }
        });
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.green);
        add(panel1,BorderLayout.PAGE_START);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.PAGE_END);
        panel1.setPreferredSize(new Dimension(400,50));
        panel2.setPreferredSize(new Dimension(400,50));
        panel3.setPreferredSize(new Dimension(400,50));
    }
    
    private String obtainString() throws ObtainStringException{
        String s = JOptionPane.showInputDialog(null,"Olá!");
        if (s.compareTo("Daniel")!=0){
            throw new ObtainStringException(s);
        }
        return s;
    }
}
