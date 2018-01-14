/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggraphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel
 */
public class MyFrame extends JFrame{

    private final ImageIcon icon;
    public MyFrame() {
        icon = new ImageIcon(this.getClass().getResource("simpsonsMini.png"));
        this.setIconImage(icon.getImage());
        this.setLayout(new BorderLayout());
        
        MyColorPanel2 panel1 = new MyColorPanel2();
        panel1.add(Box.createRigidArea(new Dimension(93, 0)));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.add(new JLabel(icon));
        panel1.add(Box.createRigidArea(new Dimension(245, 0)));
        panel1.setBackground(Color.BLACK);
        MyColorPanel4 panel4 = new MyColorPanel4();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        JLabel cursorLabel = new JLabel("CursorPosition X:Y");
        cursorLabel.setBackground(Color.WHITE);
        panel4.add(cursorLabel);
        panel4.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cursorLabel.setText("x="+e.getX()+" : y="+e.getY());
            }
        });
        panel4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e) {
                cursorLabel.setText("CursorPosition X:Y");
            }
        });
        panel4.setPreferredSize(new Dimension(280, 210));
        panel4.setBackground(Color.BLACK);
        panel1.add(panel4);
        
        this.add(panel1,BorderLayout.NORTH);
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 20));
        Color color = Color.YELLOW;
        panel2.setBackground(color);
        Font font = new Font("Serif", Font.HANGING_BASELINE, 30);
        JLabel label = new JLabel("HI EVERYONE!");
        label.setFont(font);
        panel2.add(label);
        panel2.addMouseListener(new myMouseAdapter(color,panel2,label));
        this.add(panel2,BorderLayout.SOUTH);
        
        MyColorPanel myColorPanel = new MyColorPanel();
        myColorPanel.setLayout(new BorderLayout());
        JTextArea tarea = new JTextArea(1, 1);
        String s = "Pac-Man (Japanese: パックマン Hepburn: Pakkuman?) is an arcade game developed by Namco and first released in Japan on May 22, 1980.[1][2] It was created by Japanese video game designer Toru Iwatani. It was licensed for distribution in the United States by Midway and released in October 1980. Immensely popular from its original release to the present day, Pac-Man is considered one of the classics of the medium, virtually synonymous with video games, and an icon of 1980s popular culture.";
        tarea.setText(s);
        tarea.setWrapStyleWord(true);
        tarea.setOpaque(false);
        tarea.setLineWrap(true);
        tarea.setForeground(Color.WHITE);
        Font font2 = new Font("Serif", Font.BOLD, 18);
        tarea.setFont(font2);
        myColorPanel.add(Box.createRigidArea(new Dimension(0, 20)),BorderLayout.NORTH);
        myColorPanel.add(Box.createRigidArea(new Dimension(20, 0)),BorderLayout.WEST);
        myColorPanel.add(Box.createRigidArea(new Dimension(20, 0)),BorderLayout.EAST);
        myColorPanel.add(Box.createRigidArea(new Dimension(0, 20)),BorderLayout.SOUTH);
        myColorPanel.add(tarea,BorderLayout.CENTER);
        this.add(myColorPanel,BorderLayout.CENTER);
        
        String textPanel3="My Name is DANIEL!";
        MyColorPanel3 panel3 = new MyColorPanel3(textPanel3);
        panel3.setBackground(Color.BLACK);
        panel3.setPreferredSize(new Dimension(320, 50));
        panel3.addMouseListener(new myMouseAdapter(panel3,null));
        this.add(panel3,BorderLayout.EAST);
    }
    
    private class myMouseAdapter extends MouseAdapter{
        private JPanel panel=null;
        private JLabel label=null;
        private Color color=null;
        
        public myMouseAdapter(JPanel panel, JLabel label) {
            this.panel=panel;
            this.label=label;
        }
        
        public myMouseAdapter(Color color, JPanel panel, JLabel label) {
            this.panel=panel;
            this.label=label;
            this.color=color;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            Color colorUserDefined = new JColorChooser().showDialog(MyFrame.this, "Choose Background Color", null);
            panel.setBackground(colorUserDefined);
            if(label!=null){
                Color colorUserDefined2 = new JColorChooser().showDialog(MyFrame.this, "Choose Foreground Color", null);
                label.setForeground(colorUserDefined2);
            }
            panel.repaint();
        }
    }
}
