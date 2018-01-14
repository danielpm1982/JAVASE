/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingSimpsons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class MyJFrame extends JFrame{
    
    public MyJFrame(String userName) {
        super("MyFrame");
        
        Icon homer1Icon = new ImageIcon(getClass().getResource("homer1.gif"));
        Icon homer1IconMini = new ImageIcon(getClass().getResource("homer1mini.gif"));
        Icon homer1IconMiniContrast = new ImageIcon(getClass().getResource("homer1miniContrast.png"));
        Image homer2Image = new ImageIcon(getClass().getResource("homer2.png")).getImage();
        Icon homer2Icon = new ImageIcon(getClass().getResource("homer2.png"));
        Icon homer2IconMini = new ImageIcon(getClass().getResource("homer2mini.png"));
        
        this.setIconImage(homer2Image);
        setLayout(new BorderLayout());
        
        MyJLabelClass labels = new MyJLabelClass(homer1Icon, homer2Icon, userName);
        JPanel myLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 80));
        myLabelPanel.setBackground(Color.WHITE);
        for (JPanel j : labels.getJPanels()){
            myLabelPanel.add(j);
        }
        MyJComboBoxClass combo = new MyJComboBoxClass(homer1IconMini, homer2IconMini);
        JPanel myComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,100));
        myComboPanel.add(combo.getJPanel());
        myComboPanel.setBackground(Color.WHITE);
        MyJListClass myJListClass = new MyJListClass();
        JPanel myNorthPanel = new JPanel(new BorderLayout());
        myNorthPanel.add(myLabelPanel,BorderLayout.WEST);
        myNorthPanel.add(myComboPanel,BorderLayout.CENTER);
        myNorthPanel.add(myJListClass.getPanel(),BorderLayout.EAST);
        this.add(myNorthPanel,BorderLayout.NORTH);
        
        MyJTextClass texts = new MyJTextClass(userName);
        JPanel myTextPanel = new JPanel(new BorderLayout());
        myTextPanel.setBackground(Color.BLACK);
        for (JPanel j : texts.getJPanels()){
            myTextPanel.add(j,BorderLayout.CENTER);
        }
        MyJRadioButtonClass radioButtons = new MyJRadioButtonClass(homer2Icon, homer2Icon, userName);
        JPanel myCenterPanel = new JPanel(new BorderLayout());
        myCenterPanel.add(myTextPanel,BorderLayout.NORTH);
        myCenterPanel.add(radioButtons.getPanel(),BorderLayout.CENTER);
        this.add(myCenterPanel,BorderLayout.CENTER);
        
        
        MyJButtonClass buttons = new MyJButtonClass(homer1IconMini, homer1IconMiniContrast, homer2IconMini, userName);
        JPanel myButtonPanel = new JPanel(new GridLayout(1, 3));
        for (JPanel j : buttons.getJPanels()){
            myButtonPanel.add(j);
        }
        
        MyJCheckBoxClass checkBoxes = new MyJCheckBoxClass(homer1IconMini, homer2IconMini);
        JPanel myCheckBoxPanel = new JPanel(new BorderLayout());
        for (JPanel j : checkBoxes.getJPanels()){
            myCheckBoxPanel.add(j);
        }
        
        JPanel mySouthPanel = new JPanel(new BorderLayout());
        mySouthPanel.add(myButtonPanel,BorderLayout.NORTH);
        mySouthPanel.add(myCheckBoxPanel,BorderLayout.SOUTH);
        this.add(mySouthPanel,BorderLayout.SOUTH);
        
        JOptionPane.showMessageDialog(null, "Welcome "+userName+" !!", "Good Evening!", JOptionPane.PLAIN_MESSAGE, homer1Icon);
        //new MyMusicPlayer("Simpsons.wav");
    }
}
