/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Daniel
 */
public class MyJRadioButtonClass {
    private final JRadioButton radio1;
    private final JRadioButton radio2;
    private final JRadioButton radio3;
    private final JRadioButton radio4;
    private final ButtonGroup group;
    private final Icon icon1;
    private final Icon icon2;
    private final String userName;
    private final JPanel panel;
    private final Enumeration<AbstractButton> groupEnum;
    private final String text1;
    private final String text2;
    private final String text3;
    private final String text4;
    private final Font originalFont;

    public MyJRadioButtonClass(Icon icon1, Icon icon2, String userName) {
        this.icon1=icon1;
        this.icon2=icon2;
        this.userName=userName;
        text1="radio1";
        text2="radio2";
        text3="radio3";
        text4="UNSELECT ALL";
        
        MyItemNestedEventClass itemHandler = new MyItemNestedEventClass(new Font(Font.SERIF,Font.ITALIC,20));
        group = new ButtonGroup();
        radio1 = new JRadioButton(text1);
        originalFont=radio1.getFont();
        radio1.addItemListener(itemHandler);
        radio2 = new JRadioButton(text2);
        radio2.addItemListener(itemHandler);
        radio3 = new JRadioButton(text3);
        radio3.addItemListener(itemHandler);
        radio4 = new JRadioButton(text4);
        radio4.addItemListener(itemHandler);
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);
        
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        panel.setBackground(new Color(240, 240, 240));
        groupEnum = group.getElements();
        while(groupEnum.hasMoreElements()){
            panel.add(groupEnum.nextElement());
        }
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    private class MyItemNestedEventClass implements ItemListener{

        Font f;
        public MyItemNestedEventClass(Font f) {
            this.f=f;
        }
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            JRadioButton j = ((JRadioButton)e.getSource());
            if (j.isSelected()){
                if (j.getText().compareTo(text1)==0){
                    j.setText("YOU'VE JUST SELECTED: "+text1);
                    j.setFont(f);
                } else if(j.getText().compareTo(text2)==0){
                    j.setText("YOU'VE JUST SELECTED: "+text2);
                    j.setFont(f);
                } else if(j.getText().compareTo(text3)==0){
                    j.setText("YOU'VE JUST SELECTED: "+text3);
                    j.setFont(f);
                } else {
                    if (j.getText().compareTo(text4)==0){
                        radio1.setText(text1);
                        radio2.setText(text2);
                        radio3.setText(text3);
                        radio1.setFont(originalFont);
                        radio2.setFont(originalFont);
                        radio3.setFont(originalFont);
                        radio4.setText("UNSELECTED!");
                        radio4.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
                    }
                }
            } else{
                if (j.getText().compareTo("YOU'VE JUST SELECTED: "+text1)==0){
                    j.setText(text1);
                    j.setFont(originalFont);
                } else if(j.getText().compareTo("YOU'VE JUST SELECTED: "+text2)==0){
                    j.setText(text2);
                    j.setFont(originalFont);
                } else if (j.getText().compareTo("YOU'VE JUST SELECTED: "+text3)==0){
                    j.setText(text3);
                    j.setFont(originalFont);
                } else {
                    j.setText(text4);
                    j.setFont(originalFont);
                }
            }
        }
    }
}
