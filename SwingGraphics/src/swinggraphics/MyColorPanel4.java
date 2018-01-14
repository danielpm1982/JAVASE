/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggraphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyColorPanel4 extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(5));
//        g.drawRect(0, 0, 279, 200);
//        g2d.draw(new RoundRectangle2D.Double(0, 0, 279, 200, 100, 90));
        
        BufferedImage bufferedImg = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBuff = bufferedImg.createGraphics();
        g2dBuff.setColor(Color.BLUE);
        g2dBuff.fillRect(0, 0, 10, 10);
        g2dBuff.setColor(Color.BLACK);
        g2dBuff.fillRect(1, 1, 6, 6);
        g2dBuff.setColor(Color.RED);
        g2dBuff.fillRect(1, 1, 3, 3);
        g2d.setPaint(new TexturePaint(bufferedImg,new Rectangle(10, 10)));
        g2d.fill(new RoundRectangle2D.Double(0, 0, 279, 200, 100, 90));
        
        float[] fractions = {0.15f,0.30f,0.45f,0.60f,0.85f,1.0f};
        Color[] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY,Color.GREEN,Color.YELLOW};
        g2d.setPaint(new RadialGradientPaint(138, 99, 130, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        
        g2d.fillOval(0, 0, 279, 200);
//        g.setColor(Color.BLUE);
//        g.fillOval(0, 0, 279, 200);
        
        g2d.setPaint(new GradientPaint(16, 15, Color.GREEN, 138, 92, Color.YELLOW,false));
//        g.setColor(Color.WHITE);
        g2d.draw(new Line2D.Double(18, 16, 262, 185));
//        g.drawLine(0, 0, 279, 200);
        g2d.setPaint(new GradientPaint(12, 182, Color.MAGENTA, 138, 92, Color.RED,false));
        g.drawLine(15, 184, 265, 18);
        
        g.setColor(Color.GREEN);
        g.fill3DRect(50, 50, 180, 100, true);
        g.setColor(Color.YELLOW);
        int[] x = {50,140,230,140}; int[] y = {100,145,100,50};
        g.fillPolygon(x, y, 4);
        g.setColor(Color.BLUE);
        g.fillOval(84, 68, 110, 60);
        g.setColor(Color.WHITE);
        g.fillArc(84, 84, 110, 30, -30, 245);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD+Font.HANGING_BASELINE,8));
        g.drawString("ORDEM E PROGRESSO", 94, 98);
    }
}
