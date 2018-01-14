/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class JavaApplication18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    String userName = JOptionPane.showInputDialog(null, "Type your name below:", "Hello Anonymous!", JOptionPane.INFORMATION_MESSAGE);
        MyJFrame myJFrame = new MyJFrame(userName);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setSize(1400, 930);
        //myJFrame.pack();
        myJFrame.setResizable(false);
        myJFrame.setLocationRelativeTo(null);
        myJFrame.setVisible(true);
    }
    
}
