package templateMethod3;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
public class MyJApplet extends JApplet {
    String msg;
    @Override
    public void init() {
        System.out.println("Initiated!");
        this.setForeground(Color.blue);
        this.setSize(800, 200);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyJApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @Override
    public void start() {
        System.out.println("Started!");
        msg="Hello World Applet!!";
        repaint();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyJApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void stop() {
        System.out.println("Stopped!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyJApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @Override
    public void destroy() {
        System.out.println("Destroyed!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyJApplet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        g.drawString(msg, 100, 100);
    }
}

/*
JApplet TemplateClass has a template method that uses the hook paint(Grahpics g)
implemention when repainting the components. It also calls the hook methods that
implement each lifecycle algorithm: init(), start(), stop() and destroy(), for 
example.
*/
