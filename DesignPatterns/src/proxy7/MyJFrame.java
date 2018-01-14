package proxy7;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MyJFrame extends JFrame{
    private static final Dimension SCREEN_DEFAULT_DIMENSION = new Dimension(1000, 600);
    private MyJFrame(String title){
        setJFrame(title);
    }
    private void setJFrame(String title){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setSize(SCREEN_DEFAULT_DIMENSION);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==1){
                    System.exit(0);
                }
            }
        });
    }
    public static JFrame getInstance(String title){
        return new MyJFrame(title);
    }
}
