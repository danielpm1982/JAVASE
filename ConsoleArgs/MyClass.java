package myPackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyClass {
    public static void main(String[] args) {
        MyFrame frame=null;
        try {
            frame = new MyFrame(args);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error Message",JOptionPane.ERROR_MESSAGE);
            frame = new MyFrame();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 410);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
