/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class MyJListClass {
    
    private final JPanel panel;
    private final JList<String> list1;
    
    public MyJListClass() {
        list1=new JList<>();
        list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list1.setVisibleRowCount(4);
        String[] vectorList1 = {"<Select>","Homer","Bart","Liza","Meg","Marge"};
        list1.setListData(vectorList1);
        JButton button = new JButton("Click here");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You've selected: "+list1.getSelectedValuesList().toString());
            }
        });
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0,100)));
        panel.add(new JScrollPane (list1));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0,250)));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 40));
        panel.setBackground(Color.WHITE);
        
    }
    
    public JPanel getPanel(){
        return panel;
    } 
}
