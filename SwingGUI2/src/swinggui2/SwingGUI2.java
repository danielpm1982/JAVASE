package swinggui2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Daniel
 */
public class SwingGUI2 {
    public static void main(String[] args) {
        String programChosen="";
        boolean notChosen = true;
        while(notChosen){
            switch(programChosen){
                case "1":
                    notChosen=false;
                    MyFrame frame1 = new MyFrame();
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setSize(570, 600);
                    frame1.setLocationRelativeTo(null);
                    frame1.setResizable(false);
                    frame1.setVisible(true);
                    break;
                case "2":
                    notChosen=false;
                    MyFrame2 frame2 = new MyFrame2();
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(570, 600);
                    frame2.setLocationRelativeTo(null);
                    frame2.setResizable(false);
                    frame2.setVisible(true);
                    break;
                case "3":
                    notChosen=false;
                    GridBagFrame frame3 = new GridBagFrame();
                    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame3.setSize(570, 600);
                    frame3.setLocationRelativeTo(null);
                    frame3.setResizable(false);
                    frame3.setVisible(true);
                    break;
                default:
                    programChosen=JOptionPane.showInputDialog("Choose Program - 1, 2 or 3","");
                    break;
            }
        }
    }
}
