/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class GridBagFrame extends JFrame{
    private GridBagConstraints c;
    private final JPanel panel;
    private JLabel display;
    private String displayCumulatedText="";
    public GridBagFrame(){
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        createAndSetDisplay("Calculator", 0, 0);
        createAndSetButton("7", 0, 2);
        createAndSetButton("8", 1, 2);
        createAndSetButton("9", 2, 2);
        createAndSetButton("x", 3, 2);
        createAndSetButton("4", 0, 3);
        createAndSetButton("5", 1, 3);
        createAndSetButton("6", 2, 3);
        createAndSetButton("-", 3, 3);
        createAndSetButton("1", 0, 4);
        createAndSetButton("2", 1, 4);
        createAndSetButton("3", 2, 4);
        createAndSetButton("+", 3, 4);
        createAndSetButton("0", 0, 5);
        createAndSetButton(",", 1, 5);
        createAndSetButton("/", 2, 5);
        createAndSetButton("=", 3, 5);
        createAndSetButton("Reset", 0, 6);
        createAndSetButton("(", 2, 6);
        createAndSetButton(")", 3, 6);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0, 50));
        panel.setPreferredSize(new Dimension(250, 380));
        this.getContentPane().add(panel);
    }
    
    public void createAndSetButton(String nameButton, int gridX, int gridY){
        c=new GridBagConstraints();
        JButton button = new JButton(nameButton);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        c.gridx=gridX;c.gridy=gridY;
        c.gridheight=1; c.gridwidth=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipadx=5;c.ipady=5;c.insets=new Insets(2, 2, 2, 2);
        if((nameButton.compareTo("=")!=0)&&(nameButton.compareTo("Reset")!=0)){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayCumulatedText+=" "+((JButton)e.getSource()).getText();
                    display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                    display.setHorizontalAlignment(JLabel.RIGHT);
                    display.setText(displayCumulatedText);
                }
            });
        } else if(nameButton=="Reset"){
            c.gridwidth=2;
            c.fill=GridBagConstraints.HORIZONTAL;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayCumulatedText="";
                    display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
                    display.setHorizontalAlignment(JLabel.CENTER);
                    display.setText("Calculator");
                }
            });
        } else if(nameButton.compareTo("=")==0){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String result = calculateExpression(displayCumulatedText);
                    displayCumulatedText="";
                    display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                    display.setHorizontalAlignment(JLabel.RIGHT);
                    display.setText(result);
                }
            });
        }
        panel.add(button,c);
    }
    public void createAndSetDisplay(String s,int gridX, int gridY){
        c=new GridBagConstraints();
        c.gridx=gridX; c.gridy=gridY;
        c.gridwidth=4; c.gridheight=2;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(0, 2, 5, 2);
        display = new JLabel(s,JLabel.CENTER);
        display.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        display.setForeground(Color.BLACK);
        display.setBackground(Color.WHITE);
        display.setOpaque(true);
        display.setPreferredSize(new Dimension(0,100));
        panel.add(display,c);
    }
    public String calculateExpression(String expression){
        return "Result.";
    }
}