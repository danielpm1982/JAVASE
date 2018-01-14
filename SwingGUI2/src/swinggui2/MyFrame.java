/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinggui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Daniel
 */
public class MyFrame extends JFrame{
    private JLabel label1;
    private JPanel panel1;
    Timer timerPanel1;
    Timer timerLabel1;
    JSlider slider;
    MyPanel myPanel;
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;
    JMenuItem menuItem1;
    JMenuItem menuItem2;
    JMenuItem menuItem3;
    JMenuItem menuItem4;
    JMenuItem menuItem5;
    JCheckBoxMenuItem[] menuItem6;
    JRadioButtonMenuItem[] menuItem7;
    JMenuItem menuItem8;
    
    public MyFrame() {
        createAndSetPanel1();
        createAndSetTimers();
        createAndSetSlider();
        createAndSetMyPanel();
        createAndSetMenu();
        createAndSetFrameIcon();
    }
    
    private <T extends JComponent> T changeForegroundColor (T jComponent){
        SecureRandom ramdom = new SecureRandom();
        int ramdomColorR=ramdom.nextInt(256);
        int ramdomColorG=ramdom.nextInt(256);
        int ramdomColorB=ramdom.nextInt(256);
        jComponent.setForeground(new Color(ramdomColorR, ramdomColorG, ramdomColorB));
        return jComponent;
    }
    
    private <T extends JComponent> T changeBackgroundColor (T jComponent){
        SecureRandom ramdom = new SecureRandom();
        int ramdomColorR=ramdom.nextInt(256);
        int ramdomColorG=ramdom.nextInt(256);
        int ramdomColorB=ramdom.nextInt(256);
        jComponent.setBackground(new Color(ramdomColorR, ramdomColorG, ramdomColorB));
        return jComponent;
    }
    
    private void createAndSetMenu(){
        JMenuBar menuBar = new JMenuBar();
        
        menu1 = new JMenu("Help");
        menu1.setMnemonic('H');
        menuItem1 = new JMenuItem("About",'A');
        String about = "Created by: \nDaniel Pinheiro\n® 2016 DPM Corporation. All Rights reserved.";
        ImageIcon iconAbout = new ImageIcon(getClass().getResource("image4.png"));
        menuItem1.addActionListener(e->JOptionPane.showMessageDialog(this, about, "About MenuItem", JOptionPane.OK_OPTION, iconAbout));
        menu1.add(menuItem1);
        menuItem2 = new JMenuItem("Contact",'C');
        String contact = "DPM Corporation.\nContact at: 1-800-DPM-CORP\nEmail: customersupport@dpmcorporation.com";
        menuItem2.addActionListener(e->JOptionPane.showMessageDialog(this, contact, "Contact MenuItem", JOptionPane.OK_OPTION, iconAbout));
        menu1.add(menuItem2);
        menuBar.add(menu1);
        
        menu2 = new JMenu("Format");
        menu2.setMnemonic('F');
        menuItem3 = new JMenuItem("ColorForegroundMenu",'F');
        menu2.add(menuItem3);
        menuItem4 = new JMenuItem("ColorMenuBar", 'B');
        menu2.add(menuItem4);
        menuItem5 = new JMenuItem("ColorMenuItem", 'M');
        menu2.add(menuItem5);
        menuItem3.addActionListener(e->
            {
                Color color = JColorChooser.showDialog(null, "Choose new Color for Menu and MenuItem Foreground", menu2.getForeground());
                menu1.setForeground(color);
                menu2.setForeground(color);
                menu3.setForeground(color);
                menuItem1.setForeground(color);
                menuItem2.setForeground(color);
                menuItem3.setForeground(color);
                menuItem4.setForeground(color);
                menuItem5.setForeground(color);
                Arrays.stream(menuItem6).forEach(x->x.setForeground(color));
                Arrays.stream(menuItem7).forEach(x->x.setForeground(color));
                menuItem8.setForeground(color);
            }
        );
        menuItem4.addActionListener(e->menuBar.setBackground(JColorChooser.showDialog(menuBar, "Choose new Color for MenuBar Background", menuBar.getBackground())));
        menuItem5.addActionListener(e->
            {
                Color color = JColorChooser.showDialog(null, "Choose new Color for MenuItem Background", menu2.getBackground());
                menuItem1.setBackground(color);
                menuItem2.setBackground(color);
                menuItem3.setBackground(color);
                menuItem4.setBackground(color);
                menuItem5.setBackground(color);
                Arrays.stream(menuItem6).forEach(x->x.setBackground(color));
                Arrays.stream(menuItem7).forEach(x->x.setBackground(color));
                menuItem8.setBackground(color);
            }
        );
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
        JMenu menu4 = new JMenu("Look and Feel");
        menu4.setMnemonic('L');
        JMenuItem menuItem9 = new JMenuItem(looks[0].getName());
        JMenuItem menuItem10 = new JMenuItem(looks[1].getName());
        JMenuItem menuItem11 = new JMenuItem(looks[2].getName());
        JMenuItem menuItem12 = new JMenuItem(looks[3].getName());
        JMenuItem menuItem13 = new JMenuItem(looks[4].getName());
        menuItem9.addActionListener(x->
            {
                try {
                    UIManager.setLookAndFeel(looks[0].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }
            }
        );
        menuItem10.addActionListener(x->
            {
                try {
                    UIManager.setLookAndFeel(looks[1].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }
            }
        );
        menuItem11.addActionListener(x->
            {
                try {
                    UIManager.setLookAndFeel(looks[2].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }
            }
        );
        menuItem12.addActionListener(x->
            {
                try {
                    UIManager.setLookAndFeel(looks[3].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }
            }
        );
        menuItem13.addActionListener(x->
            {
                try {
                    UIManager.setLookAndFeel(looks[4].getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }
            }
        );
        menu4.add(menuItem9);
        menu4.add(menuItem10);
        menu4.add(menuItem11);
        menu4.add(menuItem12);
        menu4.add(menuItem13);
        menu2.add(menu4);
        menuBar.add(menu2);
        
        menu3 = new JMenu("Other");
        menu3.setMnemonic('O');
        Color[] basicColors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
        menuItem6 = new JCheckBoxMenuItem[basicColors.length];
        menuItem7 = new JRadioButtonMenuItem[basicColors.length];
        ButtonGroup basicColorsGroup = new ButtonGroup();
        for (int i=0;i<basicColors.length;i++){
            menuItem6[i] = new JCheckBoxMenuItem("Red: "+basicColors[i].getRed()+" Green: "+basicColors[i].getGreen()+" Blue: "+basicColors[i].getBlue());
            basicColorsGroup.add(menuItem6[i]);
            menu3.add(menuItem6[i]);
            final int index = i;
            menuItem6[i].addActionListener(e->
                {
                    menuBar.setBackground(basicColors[index]);
                }
            );
        }
        menu3.addSeparator();
        for (int i=0;i<basicColors.length;i++){
            menuItem7[i] = new JRadioButtonMenuItem("Red: "+basicColors[i].getRed()+" Green: "+basicColors[i].getGreen()+" Blue: "+basicColors[i].getBlue());
            basicColorsGroup.add(menuItem7[i]);
            menu3.add(menuItem7[i]);
            final int index = i;
            menuItem7[i].addActionListener(e->menuBar.setBackground(basicColors[index]));
        }
        JRadioButtonMenuItem menuItemOcult = new JRadioButtonMenuItem();
        basicColorsGroup.add(menuItemOcult);
        menu3.addSeparator();
        menuItem8 = new JMenuItem("RESET",'R');
        Color originalBackgroundColor = menuBar.getBackground();
        Color originalForegroundColor = Color.BLACK;
        menuItem8.addActionListener(e->
            {
                menuBar.setBackground(originalBackgroundColor);
                menuItem1.setBackground(originalBackgroundColor);
                menuItem2.setBackground(originalBackgroundColor);
                menuItem3.setBackground(originalBackgroundColor);
                menuItem4.setBackground(originalBackgroundColor);
                menuItem5.setBackground(originalBackgroundColor);
                Arrays.stream(menuItem6).forEach(x->x.setBackground(originalBackgroundColor));
                Arrays.stream(menuItem7).forEach(x->x.setBackground(originalBackgroundColor));
                menuItem8.setBackground(originalBackgroundColor);
                menu1.setForeground(originalForegroundColor);
                menu2.setForeground(originalForegroundColor);
                menu3.setForeground(originalForegroundColor);
                menuItem1.setForeground(originalForegroundColor);
                menuItem2.setForeground(originalForegroundColor);
                menuItem3.setForeground(originalForegroundColor);
                menuItem4.setForeground(originalForegroundColor);
                menuItem5.setForeground(originalForegroundColor);
                Arrays.stream(menuItem6).forEach(x->x.setForeground(originalForegroundColor));
                Arrays.stream(menuItem7).forEach(x->x.setForeground(originalForegroundColor));
                menuItem8.setForeground(originalForegroundColor);
                //Arrays.stream(menuItem6).forEach(x->x.setSelected(false));
                //Arrays.stream(menuItem7).forEach(x->x.setSelected(false));
                menuItemOcult.setSelected(true);
//                If groupButton is used, menuItems will only be unselected if another menuItem of that buttonGroup is selected, that's why it's been used an occult button to be selected (although not visible) in order to the last one to be unselected.
//                If groupButton is NOT used, each menuItem, inclusive JCheckBoxMenuItem and JRadioButtonMenuItem, can be selected or unselected through selected(boolean b). In that case, the stream right above would work (to unselect each one). BUT NOT if a buttonGroup is used.
            }
        );
        menu3.add(menuItem8);
        menuBar.add(menu3);
        this.setJMenuBar(menuBar);
    }
    
    private void createAndSetPanel1(){
        panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        panel1.setBackground(Color.WHITE);
        label1 = new JLabel("Hello World!",JLabel.CENTER);
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        label1.setFont(f);
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(!timerPanel1.isRunning()){
                    timerPanel1.start();
                }
                timerLabel1.stop();
                label1=changeForegroundColor(label1);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                timerLabel1.stop();
                label1=changeForegroundColor(label1);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                timerLabel1.start();
            }
        });
        panel1.add(label1);
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                timerPanel1.stop();
                panel1=changeBackgroundColor(panel1);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                timerPanel1.stop();
                panel1=changeBackgroundColor(panel1);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                timerPanel1.start();
            }
        });
        this.getContentPane().setBackground(Color.BLACK);
        this.getContentPane().add(panel1,BorderLayout.SOUTH);
    }
    
    private void createAndSetTimers(){
        timerLabel1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1=changeForegroundColor(label1);
                slider.setBackground(label1.getForeground());
            }
        });
        timerLabel1.start();
        timerPanel1 = new Timer(1000, 
                e->{
                    panel1=changeBackgroundColor(panel1);
                    slider.setForeground(panel1.getBackground());
                }
        );
        timerPanel1.start();
    }
    
    private void createAndSetSlider(){
        slider = new JSlider(JSlider.VERTICAL, 0, 3000, 1000);
        slider.setSnapToTicks(true);
        slider.setInverted(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(250);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);
        slider.setBackground(Color.WHITE);
        slider.setForeground(Color.RED);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                timerLabel1.setDelay(((JSlider)e.getSource()).getValue());
                timerPanel1.setDelay(((JSlider)e.getSource()).getValue());
                myPanel.setTimerText(String.valueOf(((JSlider)e.getSource()).getValue()),((JSlider)e.getSource()).getValue());
            }
        });
        this.getContentPane().add(slider,BorderLayout.EAST);
    }
    
    private void createAndSetMyPanel(){
        myPanel = new MyPanel(String.valueOf(slider.getValue()));
        myPanel.setOpaque(true);
        myPanel.setBackground(Color.WHITE);
        this.getContentPane().add(myPanel,BorderLayout.CENTER);
    }
    
    private void createAndSetFrameIcon(){
        try {
            URL url = getClass().getResource("image4.png").toURI().toURL();
            ImageIcon img = new ImageIcon(url);
            this.setIconImage(img.getImage());
        } catch (URISyntaxException uRISyntaxException) {
        } catch (MalformedURLException malformedURLException) {
        }
    }
}
