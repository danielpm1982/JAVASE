/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggraphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyColorPanel3 extends JPanel{
    
    String text;
    Color c=null;
    public MyColorPanel3(String text) {
        this.text=text;
    }
    public MyColorPanel3(String text, Color c) {
        this(text);
        this.c=c;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font f = new Font(Font.SANS_SERIF, Font.HANGING_BASELINE+Font.BOLD, 20);
        g.setFont(f);
        if (c==null)
            g.setColor(Color.WHITE);
        else
            g.setColor(c);
        g.drawString(text, 60, 100);
    }
}
