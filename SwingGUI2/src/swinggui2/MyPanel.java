/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggui2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyPanel extends JPanel{
    private String s;
    private final Font f1;
    private final Font f2;
    private int sInt;
    public MyPanel(String s) {
        f1=new Font(Font.MONOSPACED, Font.BOLD, 20);
        f2=new Font(Font.MONOSPACED, Font.BOLD, 40);
        this.s=s;
        this.sInt=1000;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img;
        URL imgUrl = getClass().getResource("image2.jpg");
        img = new ImageIcon(imgUrl).getImage();
        g.drawImage(img, 0, 0, this);
        g.drawImage(img, 214, 0, this);
        imgUrl = getClass().getResource("image1.jpg");
        img = new ImageIcon(imgUrl).getImage();
        g.drawImage(img, 0, 120, this);
        g.setFont(f1);
        g.drawString("Color changes every", 150, 200);
        g.setColor(Color.BLUE);
        g.setFont(f2);
        if(sInt<10){
            g.drawString(s, 255, 250);
        } else if (sInt>9&&sInt<100){
            g.drawString(s, 245, 250);
        } else if(sInt>99&&sInt<1000){
            g.drawString(s, 230, 250);
        } else{
            g.drawString(s, 219, 250);
        }
        g.setFont(f1);
        g.setColor(Color.BLACK);
        g.drawString("miliseconds", 200, 290);
        g.drawRect(130, 170, 265, 150);
    }
    
    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    public void setTimerText(String s,int sInt) {
        this.s = s;
        this.sInt = sInt;
        repaint();
    }
}
