package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Main {

    public Main(String a, String b) {
        JFrame f = new JFrame("UNICODE");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 665);
        f.setLocationRelativeTo(null);
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 27);
        JLabel label1 = new JLabel(a, JLabel.CENTER);
        JLabel label2 = new JLabel(b, JLabel.CENTER);
        label1.setFont(font);
        label1.setForeground(Color.BLACK);
        label2.setFont(font);
        label2.setForeground(Color.WHITE);
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                char myChar = requestCharUserInput();
                String[] msgArray = showCharUnicodeDescription(myChar);
                label1.setText(msgArray[0]);
                label2.setText(msgArray[1]);
            }
        });
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                char myChar = requestCharUserInput();
                String[] msgArray = showCharUnicodeDescription(myChar);
                label1.setText(msgArray[0]);
                label2.setText(msgArray[1]);
            }
        });
        label1.setOpaque(true);
        label2.setOpaque(true);
        label1.setBackground(new Color(255, 230, 41));
        label2.setBackground(new Color(0, 168, 89));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel1.add(label1);
        panel2.add(label2);
        panel1.setBackground(new Color(62, 64, 149));
        panel2.setBackground(new Color(62, 64, 149));
        setToolTipRecursively(panel1, "Click to search for another char literal!");
        setToolTipRecursively(panel2, "Click to search for another char literal!");
        f.getContentPane().add(panel1,BorderLayout.NORTH);
        f.getContentPane().add(panel2,BorderLayout.CENTER);
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel(new ImageIcon(this.getClass().getResource("bandeira.jpg")));
        panel3.add(label3);
        panel3.setBackground(Color.BLACK);
        f.getContentPane().add(panel3,BorderLayout.SOUTH);
        f.setIconImage(new ImageIcon(this.getClass().getResource("bandeira.png")).getImage());
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        char myChar = requestCharUserInput();
        String[] msgArray = showCharUnicodeDescription(myChar);
        new Main(msgArray[0], msgArray[1]);
    }
    
    public static final char requestCharUserInput(){
        String result=null;
        do{
            result = JOptionPane.showInputDialog("Type a char literal and press <ENTER>");
        } while(result==null||result.equals(""));
        return result.charAt(0);
    }
    
    public static final String[] showCharUnicodeDescription(char myChar){
        int codePoint = Character.codePointBefore(String.valueOf(myChar), String.valueOf(myChar).length());
        String msgA = "CodePoint decimal representation of \t\'"+myChar+"\' = "+codePoint;
        System.out.println(msgA);
        String unicodeString = String.format("\\u%04x", codePoint);
        String msgB = "Unicode hexadecimal representation of \t\'"+myChar+"\' = "+unicodeString;
        System.out.println(msgB);
        return new String[]{msgA, msgB};
    }
    
    public final void setToolTipRecursively(JComponent panel, String tip){
        for (Component component:panel.getComponents()){
            if(component instanceof JComponent){
                ((JComponent)component).setToolTipText(tip);
            }
        }
    }
}
