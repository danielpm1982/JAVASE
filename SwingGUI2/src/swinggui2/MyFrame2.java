/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author Daniel
 */
public class MyFrame2 extends JFrame{
    JDesktopPane desktopPanel;
    JInternalFrame internalFrame1;
    JInternalFrame internalFrame2;
    
    public MyFrame2() {
        createAndSetDesktopFrame();
        createAndSetMenu2();
    }

    private void createAndSetMenu2(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("InternalFrames");
        JMenuItem menuItem1 = new JMenuItem("Show Frame1");
        JMenuItem menuItem2 = new JMenuItem("Show Frame2");
        menuItem1.addActionListener(x->
            {
                createAndSetInternalFrame1();
            }
        );
        menuItem2.addActionListener(x->
            {
                createAndSetInternalFrame2();
            }
        );
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }
    
    private void createAndSetDesktopFrame(){
        desktopPanel = new JDesktopPane();
        this.getContentPane().add(desktopPanel);
    }
    
    private void createAndSetInternalFrame1(){
        internalFrame1 = new JInternalFrame("InternalFrame1", true, true, true, true);
        JPanel panel1Frame1 = new JPanel();
        panel1Frame1.add(new JLabel(new ImageIcon(getClass().getResource("image1.jpg"))));
        JPanel panel2Frame1 = new JPanel();
        panel2Frame1.add(new JLabel(new ImageIcon(getClass().getResource("image2.jpg"))));
        JPanel panel3Frame1 = new JPanel(new BorderLayout());
        createAndSetStrut(panel3Frame1);
        createAndSetRigidArea(panel3Frame1);
        createAndSetGlue(panel3Frame1);
        JPanel panel4Frame1 = new JPanel();
        JLabel labelFrame1Panel4 = new JLabel(new ImageIcon(getClass().getResource("image3.jpg")));
        panel4Frame1.add(labelFrame1Panel4);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab1", new ImageIcon(getClass().getResource("image5.png")), panel1Frame1, "Tab1");
        tabbedPane.addTab("Tab2", new ImageIcon(getClass().getResource("image5.png")), panel2Frame1, "Tab2");
        tabbedPane.addTab("Tab3", new ImageIcon(getClass().getResource("image5.png")), panel3Frame1, "Tab3");
        tabbedPane.addTab("Tab4", new ImageIcon(getClass().getResource("image5.png")), panel4Frame1, "Tab4");
        internalFrame1.add(tabbedPane);
        internalFrame1.pack();
        internalFrame1.setLocation(10, 50);
        desktopPanel.add(internalFrame1);
        internalFrame1.setVisible(true);
    }
    
    private void createAndSetStrut(JPanel panel){
        Box box = new Box(BoxLayout.X_AXIS);
        box.setBackground(Color.BLACK);
        box.setOpaque(true);
        box.add(Box.createGlue());
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createHorizontalStrut(20));
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createHorizontalStrut(20));
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createGlue());
        panel.add(box,BorderLayout.SOUTH);
    }
    
    private void createAndSetRigidArea(JPanel panel){
        Box box = new Box(BoxLayout.X_AXIS);
        box.setBackground(Color.BLACK);
        box.setOpaque(true);
        box.add(Box.createGlue());
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createRigidArea(new Dimension(20, 150)));
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createRigidArea(new Dimension(20, 150)));
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createGlue());
        panel.add(box,BorderLayout.NORTH);
    }
    
    private void createAndSetGlue(JPanel panel){
        Box box = new Box(BoxLayout.X_AXIS);
        box.setBackground(Color.BLACK);
        box.setOpaque(true);
        box.add(Box.createGlue());
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createHorizontalGlue());
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createHorizontalGlue());
        box.add(new JLabel(new ImageIcon(getClass().getResource("image4.png"))));
        box.add(Box.createHorizontalGlue());
        panel.add(box,BorderLayout.CENTER);
    }
    
    private void createAndSetInternalFrame2(){
        internalFrame2 = new JInternalFrame("InternalFrame2", true, true, true, true);
        JPanel panelFrame2 = new JPanel();
        panelFrame2.add(new JLabel(new ImageIcon(getClass().getResource("image2.jpg"))));
        internalFrame2.add(panelFrame2);
        internalFrame2.pack();
        internalFrame2.setLocation(120, 150);        
        desktopPanel.add(internalFrame2);
        internalFrame2.setVisible(true);
    }
}
