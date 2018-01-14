package compound;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.*;

public class ViewComponentConcreteFactory implements ViewComponentAbstractFactoryInterface{
    private final int LABEL_PANEL_NUMBER; //any number greater than 0;
    private final int BUTTON_NUMBER=1;
    private final JLabel[] jLabel;
    private final JPanel[] jPanel;
    private final JButton[] jButton;
    private final StrategyInterface controller;
    private JPanel lastPanelClickedByThisPlayer;
    private final String playerName;
    public ViewComponentConcreteFactory(StrategyInterface controller, String playerName, int labelPanelNumber) {
        LABEL_PANEL_NUMBER=labelPanelNumber;
        jLabel = new JLabel[LABEL_PANEL_NUMBER];
        jPanel = new JPanel[LABEL_PANEL_NUMBER];
        jButton = new JButton[BUTTON_NUMBER];
        this.controller=controller;
        this.playerName=playerName;
    }
    private JLabel[] createJLabel() {
        for (int i=0; i<LABEL_PANEL_NUMBER; i++){
            JLabel tempLabel = new JLabel("label_"+i);
            tempLabel.setForeground(Color.WHITE);
            jLabel[i] = tempLabel;
        }
        Arrays.stream(jLabel).forEach(x->x.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 30)));
        return jLabel;
    }
    private JPanel[] createJPanelWithLabel() {
        if(jLabel[LABEL_PANEL_NUMBER-1]==null){
            createJLabel();
        }
        for (int i=0; i<LABEL_PANEL_NUMBER; i++){
            JPanel tempPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            tempPanel.add(jLabel[i]);
            tempPanel.setBackground(Color.BLACK);
            tempPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(((JPanel)e.getSource()).getBackground()!=Color.BLACK){
                        ((JPanel)e.getSource()).setBackground(Color.BLACK);
                        ((JPanel)e.getSource()).getComponent(0).setForeground(Color.WHITE);
                        lastPanelClickedByThisPlayer = null;
                    } else{
                        ((JPanel)e.getSource()).setBackground(Color.GREEN);
                        ((JPanel)e.getSource()).getComponent(0).setForeground(Color.BLACK);
                        if(lastPanelClickedByThisPlayer!=null){
                            lastPanelClickedByThisPlayer.setBackground(Color.BLACK);
                            lastPanelClickedByThisPlayer.getComponent(0).setForeground(Color.WHITE);
                        }
                        lastPanelClickedByThisPlayer = (JPanel)e.getSource();
                    }
                }
            });
            jPanel[i]=tempPanel;
        }
        return jPanel;
    }
    private JButton[] createJButton() {
        for (int i=0; i<BUTTON_NUMBER; i++){
            JButton tempButton = new JButton("Button_"+i);
            tempButton.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 30));
            tempButton.setMargin(new Insets(10, 20, 10, 20));
            tempButton.setBackground(Color.WHITE);
            tempButton.setFocusPainted(false);
            tempButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((JButton)e.getSource()).setBackground(Color.GREEN);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    ((JButton)e.getSource()).setBackground(Color.WHITE);
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(lastPanelClickedByThisPlayer!=null){
                        controller.aButtonInThisControllerViewWasClicked(lastPanelClickedByThisPlayer);    
                    }
                }
            });
            jButton[i]=tempButton;
        }
        return jButton;
    }
    @Override
    public JFrame createJFrameWithLabelAndPanelAndButton() {
        JFrame tempFrame = new JFrame("MVC_VIEW_FRAME - "+playerName);
        tempFrame.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        tempFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(jLabel[LABEL_PANEL_NUMBER-1]==null){
            createJLabel();
        }
        if(jPanel[LABEL_PANEL_NUMBER-1]==null){
            createJPanelWithLabel();
        }
        JPanel panelsPanel = new JPanel(new GridLayout(0, 5, 20, 20));
        Arrays.stream(jPanel).forEach(x -> panelsPanel.add(x));
        panelsPanel.setBackground(Color.LIGHT_GRAY);
        panelsPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(lastPanelClickedByThisPlayer!=null&&lastPanelClickedByThisPlayer.getBackground()!=Color.BLACK){
                    lastPanelClickedByThisPlayer.setBackground(Color.BLACK);
                    lastPanelClickedByThisPlayer.getComponent(0).setForeground(Color.WHITE);
                }
                lastPanelClickedByThisPlayer=null;
            }
        });
        JScrollPane scrollPane = new JScrollPane(panelsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tempFrame.add(scrollPane, BorderLayout.CENTER);
        if(jButton[BUTTON_NUMBER-1]==null){
            createJButton();
        }
        JPanel buttonPanel = new MyButtonJPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        buttonPanel.setBackground(Color.BLACK);
        Arrays.stream(jButton).forEach(x->buttonPanel.add(x));
        tempFrame.add(buttonPanel, BorderLayout.SOUTH);
        tempFrame.setSize(new Dimension(910, 600));
        tempFrame.setLocationRelativeTo(null);
        return tempFrame;
    }
    public static JWindow createJWindowIntro() {
        JWindow introWindow = new JWindow();
        JLabel numberLabel = new JLabel(new ImageIcon(ViewComponentConcreteFactory.class.getResource("intro.png")));
        introWindow.add(numberLabel,BorderLayout.CENTER);
        JLabel textLabel1 = new JLabel("WELCOME TO THE ***NUMBER GAME*** !!",JLabel.CENTER);
        textLabel1.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 30));
        textLabel1.setPreferredSize(new Dimension(0, 50));
        addMouseListenerToComponentsToDisposeWindow(textLabel1, introWindow);
        introWindow.add(textLabel1,BorderLayout.NORTH);
        JLabel textLabel2 = new JLabel("You must select any number and press the button",JLabel.CENTER);
        textLabel2.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 30));
        addMouseListenerToComponentsToDisposeWindow(textLabel2, introWindow);
        JLabel textLabel3 = new JLabel("until you achieve your MAX_CLICK_COUNT.",JLabel.CENTER);
        textLabel3.setFont(new Font(Font.MONOSPACED, Font.BOLD+Font.ITALIC, 30));
        addMouseListenerToComponentsToDisposeWindow(textLabel3, introWindow);
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(0, 105));
        southPanel.add(textLabel2,BorderLayout.NORTH);
        southPanel.add(textLabel3,BorderLayout.SOUTH);
        introWindow.add(southPanel,BorderLayout.SOUTH);
        addMouseListenerToComponentsToDisposeWindow(numberLabel, introWindow);
        introWindow.setSize(new Dimension(910, 600));
        introWindow.setLocationRelativeTo(null);
        introWindow.setVisible(true);
        return introWindow;
    }
    @Override
    public void update(JFrame frame) {
        JPanel tempPanel = controller.getLastPanelClickedByThisPlayer();
        if(tempPanel!=null){
            tempPanel.setBackground(Color.BLUE);
            tempPanel.getComponent(0).setForeground(Color.WHITE);
            JWindow window = new JWindow(frame);
            window.getContentPane().add(tempPanel, BorderLayout.CENTER);
            JLabel timeLabel = new JLabel(controller.getTime(),JLabel.CENTER);
            timeLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            window.getContentPane().add(timeLabel, BorderLayout.SOUTH);
            JLabel messageLabel = new JLabel("You've selected:");
            messageLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            window.getContentPane().add(messageLabel, BorderLayout.NORTH);
            window.pack();
            window.setLocationRelativeTo(frame);
            window.setVisible(true);
            addMouseListenerToComponentsToDisposeWindow(tempPanel, window);
            addMouseListenerToComponentsToDisposeWindow(timeLabel, window);
            addMouseListenerToComponentsToDisposeWindow(messageLabel, window);
            controller.setLastPanelClickedByThisPlayer(null);
            frame.setVisible(true);
        }
        frame.update(frame.getGraphics());
    }
    private static void addMouseListenerToComponentsToDisposeWindow(JComponent component, JWindow window){
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
            }
        });
    }
    @Override
    public void endView(JFrame frame) {
        String allLabelPanelClickedByThisPlayerListString = getListString(controller.getAllLabelPanelClickedByThisPlayerList());
        String allLabelPanelClickedByEachPlayerMapString = getMapOrderedString(controller.getAllLabelPanelClickedByEachPlayerMap());
        JOptionPane.showMessageDialog(frame, "GAME OVER for "+playerName+"!\nClicked by this Player:\n"+allLabelPanelClickedByThisPlayerListString);
        System.out.println("GAME OVER for "+playerName+"!\nClicked by this Player:\n"+allLabelPanelClickedByThisPlayerListString+"\nClicked by all Players (until now):\n"+allLabelPanelClickedByEachPlayerMapString);
        frame.dispose();
    }
    private String getListString(List<String> list){
        return list.stream().reduce("",(x,y)->x+y+" ");
    }
    private String getMapOrderedString(Map<Player,List<String>> map){
        List<String> tempList = map.keySet().stream().sorted(Comparator.comparing(x->x.getPlayerName())).map(x->x.getPlayerName()+": "+getListString(map.get(x))).collect(Collectors.toList());
        String result = tempList.stream().reduce("",(x,y)->x+y+"\n");
        if(result.length()>=2){
            return result.substring(0, result.length()-2);
        }
        return "";
    }
}
