/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class MyJTextClass{

    private final JTextField textField1;
    private final JTextField textField2;
    private final JPasswordField textField3;
    private final JPanel jPanel1;
    private final String userName;
    private final String text1;
    private final String text2;
    private final String text3;
    
    public MyJTextClass(String userName) {
        this.userName=userName;
        
        text1 = userName+", type your text1 here!";
        text2 = userName+", type your text2 here!";
        text3 = userName+", enter your password!";
        
        textField1 = new JTextField(text1, 50);
        textField2 = new JTextField(text2, 50);
        textField3 = new JPasswordField(text3, 6);
        
        MyMouseNestedEventClass mouseHandler = new MyMouseNestedEventClass();
        textField1.addMouseListener(mouseHandler);
        textField2.addMouseListener(mouseHandler);
        textField3.addMouseListener(mouseHandler);
        
        MyFocusNestedEventClass focusHandler = new MyFocusNestedEventClass();
        textField1.addFocusListener(focusHandler);
        textField2.addFocusListener(focusHandler);
        textField3.addFocusListener(focusHandler);
        
        MyActionNestedEventClass actionHandler = new MyActionNestedEventClass();
        textField1.addActionListener(actionHandler);
        textField2.addActionListener(actionHandler);
        textField3.addActionListener(actionHandler);
        
        jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 25));
        
        jPanel1.add(textField1);
        jPanel1.add(textField2);
        jPanel1.add(textField3);
    }
    
    public JPanel[] getJPanels(){
        JPanel[] jPanelsArray = {jPanel1};
        return jPanelsArray;
    }
    
    private class MyMouseNestedEventClass extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() instanceof JTextField){
                ((JTextField)e.getSource()).setText("");
            }
        }
    }
    
    private class MyFocusNestedEventClass extends FocusAdapter{

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() instanceof JTextField){
                ((JTextField)e.getSource()).setText("");
            }
        }
        
        @Override
        public void focusLost(FocusEvent e) {
            Object o = e.getSource();
            if (o instanceof JTextField){
                if (o.equals(textField1)){
                    ((JTextField)e.getSource()).setText(text1);
                } else if (o.equals(textField2)){
                    ((JTextField)e.getSource()).setText(text2);
                } else if (o.equals(textField3)){
                    ((JTextField)e.getSource()).setText(text3);
                }
            }
        }
    }
    
    private class MyActionNestedEventClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, userName+", you typed: "+e.getActionCommand()+".");
        }
    }
}

