/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggraphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyColorPanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        setBackground(Color.BLACK);
        g.setColor(Color.BLUE);
        g.fillRect(145, 20, 200, 200);
        g.setColor(Color.RED);
        g.fillOval(280, 105, 40, 40);
        g.setColor(Color.YELLOW);
        g.fillArc(170, 60, 160, 120, 50, 250);
        g.setColor(Color.BLACK);
        g.fillOval(260, 70, 15, 15);
    }
}
