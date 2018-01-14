/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyJCheckBoxClass {
    
    private final JCheckBox jCheckBox1;
    private final JCheckBox jCheckBox2;
    private final JCheckBox jCheckBox3;
    private final JPanel jPanel1;
    private final Icon icon1, icon2;

    public MyJCheckBoxClass(Icon icon1, Icon icon2) {
        
        this.icon1=icon1;
        this.icon2=icon2;
        
        MyItemNestedEventClass itemListener = new MyItemNestedEventClass();
        jCheckBox1 = new JCheckBox("Don't show iconImage2", icon1);
        jCheckBox1.setToolTipText("jCheckBox1");
        jCheckBox1.addItemListener(itemListener);
        jCheckBox2 = new JCheckBox("Don't show iconImage1", icon2);
        jCheckBox2.setToolTipText("jCheckBox2");
        jCheckBox2.addItemListener(itemListener);
        jCheckBox3 = new JCheckBox("Show NO iconImages");
        jCheckBox3.setToolTipText("jCheckBox3");
        jCheckBox3.addItemListener(itemListener);
        
        jPanel1 = new JPanel();
        jPanel1.add(Box.createRigidArea(new Dimension(137, 100)));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
        jPanel1.add(jCheckBox1);
        jPanel1.add(Box.createRigidArea(new Dimension(185, 0)));
        jPanel1.add(jCheckBox2);
        jPanel1.add(Box.createRigidArea(new Dimension(210, 0)));
        jPanel1.add(jCheckBox3);
        jPanel1.setBackground(new Color(240, 240, 240));
        
    }
    
    public JPanel[] getJPanels(){
        JPanel[] jPanelsArray = {jPanel1};
        return jPanelsArray;
    }
    
    private class MyItemNestedEventClass implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox c = (JCheckBox)e.getSource();
            if (c.getText().compareTo("Don't show iconImage2")==0){
                if (c.isSelected())
                    jCheckBox2.setIcon(null);
                else{
                    if (!jCheckBox3.isSelected())
                        jCheckBox2.setIcon(icon2);
                }
            }
            else if(c.getText().compareTo("Don't show iconImage1")==0){
                if (c.isSelected())
                    jCheckBox1.setIcon(null);
                else{
                    if (!jCheckBox3.isSelected())
                        jCheckBox1.setIcon(icon1);
                }
            } else{
                if (c.isSelected()){
                    jCheckBox1.setIcon(null);
                    jCheckBox2.setIcon(null);
                } else{
                    if(jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
                    }
                    else if (jCheckBox1.isSelected()&&!jCheckBox2.isSelected())
                        jCheckBox1.setIcon(icon1);
                    else if (!jCheckBox1.isSelected()&&jCheckBox2.isSelected())
                        jCheckBox2.setIcon(icon2);
                    else if (!jCheckBox1.isSelected()&&!jCheckBox2.isSelected()){
                        jCheckBox1.setIcon(icon1);
                        jCheckBox2.setIcon(icon2);
                    }
                }
            }
        }
    }
    
}
