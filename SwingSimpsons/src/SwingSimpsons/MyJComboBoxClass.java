/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyJComboBoxClass {
    
    private final JPanel panel;
    
    public MyJComboBoxClass(Icon icon1, Icon icon2) {
        JComboBox <String> combo = new JComboBox<>();
        combo.addItem("<SELECT_ITEM>");
        combo.addItem("Homer");
        combo.addItem("TheSimpsons");
        combo.setMaximumRowCount(3);
        JLabel label = new JLabel();
        combo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()== ItemEvent.SELECTED){
                    String s = (String)(((JComboBox<String>)e.getSource()).getSelectedItem());
                    if(s.compareTo("Homer")==0){
                        label.setIcon(icon1);
                    } else if(s.compareTo("TheSimpsons")==0){
                        label.setIcon(icon2);
                    } else{
                        label.setIcon(null);
                    }
                }
            }
        });
        panel=new JPanel(new BorderLayout());
        panel.add(combo,BorderLayout.SOUTH);
        panel.add(label,BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
    }
    
    public JPanel getJPanel(){
        return panel;
    }
}
