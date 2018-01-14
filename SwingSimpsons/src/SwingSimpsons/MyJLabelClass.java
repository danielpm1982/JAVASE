/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Daniel
 */
public class MyJLabelClass {
    
    private final JLabel jLabel1;
    private final JLabel jLabel2;
    private final JLabel jLabel3;
    private final JPanel jPanel1;
    private final JPanel jPanel2;
    private final JPanel jPanel3;
    private final String userName;
    private final Icon icon1, icon2;
    
    public MyJLabelClass(Icon icon1, Icon icon2, String userName) {
        
        this.icon1=icon1;
        this.icon2=icon2;
        this.userName=userName;
        
        jLabel1 = new JLabel("Only text label1");
        jLabel1.setToolTipText("JLabel1");
        jLabel1.setForeground(Color.WHITE);
        jLabel1.addMouseListener(new MyMouseNestedEventClass());
        jPanel1 = new JPanel(new BorderLayout());
        jPanel1.add(jLabel1);
        jPanel1.setBackground(Color.BLACK);
        jPanel1.addMouseListener(new MyMouseNestedEventClass());
        
        jLabel2 = new JLabel("Icon and text label2",icon1,SwingConstants.CENTER);
        jLabel2.setHorizontalTextPosition(SwingConstants.LEADING);
        jLabel2.setVerticalTextPosition(SwingConstants.TOP);
        jLabel2.setToolTipText("JLabel2");
        jLabel2.addMouseListener(new MyMouseNestedEventClass());
        jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBackground(Color.GRAY);
        jPanel2.add(jLabel2);
        
        jLabel3 = new JLabel("Icon and text label3",icon2,SwingConstants.CENTER);
        jLabel3.setHorizontalTextPosition(SwingConstants.TRAILING);
        jLabel3.setVerticalTextPosition(SwingConstants.BOTTOM);
        jLabel3.setToolTipText("JLabel3");
        jLabel3.addMouseListener(new MyMouseNestedEventClass());
        jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBackground(Color.lightGray);
        jPanel3.add(jLabel3);
        
    }
    
    public JPanel[] getJPanels(){
        JPanel[] jPanelsArray = {jPanel1, jPanel2,jPanel3};
        return jPanelsArray;
    }
    
    private class MyMouseNestedEventClass implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
            String s = userName+", you clicked at point: x="+e.getLocationOnScreen().x+" y="+e.getLocationOnScreen().y+"!";
            JOptionPane.showConfirmDialog(null, s,"Point Detected",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,icon2);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }
    
}
