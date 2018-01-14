/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyJButtonClass {
    
    private final JPanel jpanel1;
    private final JPanel jpanel2;
    private final JPanel jpanel3;
    private final JButton jButton1;
    private final JButton jButton2;
    private final JButton jButton3;
    private final String userName;
    
    public MyJButtonClass(Icon icon1, Icon icon2, Icon icon3, String userName) {
        
        this.userName=userName;
        
        jButton1 = new JButton("Button1", icon1);
        jButton2 = new JButton("Button2", icon3);
        jButton3 = new JButton("Button3", icon1);
        
        MyButtonNestedEventClass buttonHandler = new MyButtonNestedEventClass();
        jButton1.setPressedIcon(icon3);
        jButton1.addActionListener(buttonHandler);
        jButton2.setRolloverIcon(icon1);
        jButton2.addActionListener(buttonHandler);
        jButton3.setRolloverIcon(icon2);
        jButton3.addActionListener(buttonHandler);
        
        jpanel1 = new JPanel(new FlowLayout());
        jpanel1.add(jButton1);
        jpanel1.setBackground(Color.LIGHT_GRAY);
        Dimension d = jpanel1.getPreferredSize();
        jpanel2 = new JPanel(new FlowLayout());
        jpanel2.add(jButton2);
        jpanel2.setBackground(Color.GRAY);
        jpanel2.setPreferredSize(d);
        jpanel3 = new JPanel(new FlowLayout());
        jpanel3.add(jButton3);
        jpanel3.setBackground(Color.DARK_GRAY);
        jpanel3.setPreferredSize(d);
    }
    
    public JPanel[] getJPanels(){
        JPanel[] jPanelsArray = {jpanel1, jpanel2, jpanel3};
        return jPanelsArray;
    }
    
    private class MyButtonNestedEventClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, userName+", you clicked on the JButton of label: "+e.getActionCommand()+"!");
        }
        
    }
}
