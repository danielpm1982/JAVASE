/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads3;

import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new MyJFrame();
        frame.setTitle("Swing Worker Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900);
        frame.setLocationRelativeTo(null);
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}
