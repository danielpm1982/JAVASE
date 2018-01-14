/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads3;

import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyJPanel extends JPanel{
    
    private final ImageIcon imageIcon;
    public MyJPanel() {
        this(null);
    }
    
    public MyJPanel(LayoutManager layout) {
        super.setLayout(layout);
        imageIcon = new ImageIcon(getClass().getResource("fibonacci.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, this);
    }
}
