/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggraphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyColorPanel2 extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        ImageIcon icon = new ImageIcon(getClass().getResource("simpsonsBackGround.jpg"));
        g.drawImage(icon.getImage(), 0, -20, this);
        g.setColor(Color.BLACK);
        g.fillOval(50, 20, 240, 185);
    }
}
