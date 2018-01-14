package swingsimpsonsmemorygame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Game extends JFrame{
    private static Game myFrame=null;
    private JPanel mainPanel;
    private JLabel img1LabelSmall;
    private JLabel img1LabelBig;
    private boolean started=false;
    private boolean isMaximized=false;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private int wrongSelections=0;
    private final List<String> imgSelectedList;
    private final int MAX_SIZE_SELECTED_LIST=20;
    private boolean ended=false;
    public static void start(){
        if(myFrame==null){
            myFrame = new Game();
        }
    }
    private Game(){
        imgSelectedList = new ArrayList<>();
        setSplashWindow();
        setFrameSettings();
        setFrameComponents();
        setFrameListeners();
    }
    private void setSplashWindow(){
        JWindow splashWindow = new JWindow();
        splashWindow.getContentPane().setBackground(Color.BLACK);
        splashWindow.getContentPane().add(new JLabel(new ImageIcon(getClass().getResource("img/img2.png"))));
        splashWindow.setSize(((Double)(getScreenSize().width/2.6d)).intValue(),(((Double)(getScreenSize().height/2d+100)).intValue()));
        splashWindow.setVisible(true);
        splashWindow.setLocationRelativeTo(null);
        splashWindow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                splashWindow.setVisible(false);
                splashWindow.dispose();
                Game.this.setVisible(true);
            }
        });
    }
    private void setFrameSettings(){
        this.setIconImage(new ImageIcon(getClass().getResource("img/img1.png")).getImage());
        this.setSize(((Double)(getScreenSize().width/1.5)).intValue(),(((Double)(getScreenSize().height/1.3)).intValue()));
        this.setTitle("Composite Pattern");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    private void setFrameComponents(){
        JLabel label1 = new JLabel("*** Memory Game ***",JLabel.CENTER);
        label1.setFont(new Font("Monospaced", Font.BOLD, 60));
        label1.setBackground(Color.BLACK);
        label1.setForeground(Color.WHITE);
        label1.setOpaque(true);
        JPanel panelLabel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, Double.valueOf(0.1*getScreenSize().height).intValue()));
        panelLabel1.setBackground(Color.BLACK);
        panelLabel1.add(label1);
        this.getContentPane().add(panelLabel1, BorderLayout.NORTH);
        JLabel label2 = new JLabel("Instructions: Select always different images!",JLabel.CENTER);
        label2.setFont(new Font("Monospaced", Font.BOLD, 30));
        label2.setBackground(Color.BLACK);
        label2.setForeground(Color.WHITE);
        label2.setOpaque(true);
        this.getContentPane().add(label2, BorderLayout.CENTER);
        JLabel label3 = new JLabel("Click to START! Keep Clicking to Play!",JLabel.CENTER);
        label3.setFont(new Font("Monospaced", Font.ITALIC, 30));
        label3.setBackground(Color.BLACK);
        label3.setForeground(Color.WHITE);
        label3.setOpaque(true);
        JPanel panelLabel3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, Double.valueOf(0.1*getScreenSize().height).intValue()));
        panelLabel3.setBackground(Color.BLACK);
        panelLabel3.add(label3);
        this.getContentPane().add(panelLabel3, BorderLayout.SOUTH);
        Image originalImage1 = new ImageIcon(getClass().getResource("img/img1.png")).getImage();
        Image resizedImage1Small = originalImage1.getScaledInstance(((Double)(0.18*getScreenSize().width)).intValue(), ((Double)(0.28*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        Image resizedImage1Big = originalImage1.getScaledInstance(((Double)(0.3*getScreenSize().width)).intValue(), ((Double)(0.4*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        img1LabelSmall = new JLabel(new ImageIcon(resizedImage1Small));
        img1LabelBig = new JLabel(new ImageIcon(resizedImage1Big));
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBorder(BorderFactory.createDashedBorder(Color.BLUE, 10f, 2f, 2f, true));
        northPanel=new JPanel();
        northPanel.setBackground(Color.BLACK);
        southPanel=new JPanel(new BorderLayout());
        southPanel.setBackground(Color.BLACK);
        westPanel=new JPanel();
        westPanel.setBackground(Color.BLACK);
        eastPanel=new JPanel();
        eastPanel.setBackground(Color.BLACK);
    }
    private void setFrameListeners(){
        this.addWindowStateListener(e->{
            if(e.getNewState()==Frame.MAXIMIZED_BOTH||e.getNewState()==Frame.MAXIMIZED_HORIZ||e.getNewState()==Frame.MAXIMIZED_VERT){
                isMaximized=true;
            } else if(e.getNewState()==Frame.NORMAL){
                isMaximized=false;
            }
            if(started){
                if(!ended){
                    mainPanel.removeAll();
                    setCentralPanelAtMainPanel();
                    Game.this.getContentPane().removeAll();
                    Game.this.getContentPane().add(mainPanel);
                    Game.this.setVisible(true);
                }
            }
        });
        MouseAdapter updateMainPanelListenerAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!ended){
                    mainPanel.removeAll();
                    setCentralPanelAtMainPanel();
                    if(started){
                        setWestPanelAtMainPanel();
                        setNorthPanelAtMainPanel();
                        setSouthPanelAtMainPanel();
                        setEastPanelAtMainPanel();
                    }
                    Game.this.getContentPane().removeAll();
                    Game.this.getContentPane().add(mainPanel);
                    Game.this.setVisible(true);
                    started=true;
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(!ended){
                    mainPanel.setBackground(Color.RED);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!ended){
                    mainPanel.setBackground(Color.BLACK);
                }
            }            
        };
        MouseAdapter selectImgListenerAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!ended){
                    String imgSelectedString;
                    if(((JPanel)e.getSource()).getComponent(0) instanceof JLabel){
                        imgSelectedString = ((ImageIcon)((JLabel)((JPanel)e.getSource()).getComponent(0)).getIcon()).getDescription();
                    } else{
                        imgSelectedString = ((ImageIcon)((JLabel)((JPanel)e.getSource()).getComponent(1)).getIcon()).getDescription();
                    }
                    addImgStringToList(imgSelectedString);
                    updateMainPanelListenerAdapter.mouseClicked(e);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if(!ended){
                    ((JPanel)e.getSource()).setBackground(Color.BLUE);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!ended){
                    ((JPanel)e.getSource()).setBackground(Color.BLACK);
                }
            }
        };
        this.getContentPane().addMouseListener(updateMainPanelListenerAdapter);
        northPanel.addMouseListener(selectImgListenerAdapter);
        southPanel.addMouseListener(selectImgListenerAdapter);
        westPanel.addMouseListener(selectImgListenerAdapter);
        eastPanel.addMouseListener(selectImgListenerAdapter);
    }
    private void setCentralPanelAtMainPanel(){
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.BLACK);
        if(isMaximized){
            centerPanel.add(img1LabelBig, BorderLayout.CENTER);
        }else{
            centerPanel.add(img1LabelSmall, BorderLayout.CENTER);
        }
        mainPanel.add(centerPanel,BorderLayout.CENTER);
    }
    private void setNorthPanelAtMainPanel(){
        northPanel.removeAll();
        if(isMaximized){
            northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 23));
            northPanel.add(getBigLabelRandomImage());
        }else{
            northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            northPanel.add(getSmallLabelRandomImage());
        }
        mainPanel.add(northPanel,BorderLayout.NORTH);
    }
    private void setSouthPanelAtMainPanel(){
        southPanel.removeAll();
        southPanel.setOpaque(true);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
        Font gameStatusFont;
        if(isMaximized){
            southPanel.add(Box.createRigidArea(new Dimension(662, 320)));
            southPanel.add(getBigLabelRandomImage());
            southPanel.add(Box.createHorizontalStrut(280));
            gameStatusFont = new Font("Monospaced", Font.BOLD, 40);
        }else{
            southPanel.add(Box.createRigidArea(new Dimension(450, 240)));
            southPanel.add(getSmallLabelRandomImage());
            southPanel.add(Box.createHorizontalStrut(150));
            gameStatusFont = new Font("Monospaced", Font.BOLD, 30);
        }
        JLabel gameStatus = new JLabel("Selected: "+imgSelectedList.size()+"/"+MAX_SIZE_SELECTED_LIST);
        gameStatus.setForeground(Color.WHITE);
        gameStatus.setFont(gameStatusFont);
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(gameStatus, BorderLayout.CENTER);
        statusPanel.setOpaque(false);
        southPanel.add(statusPanel);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
    }
    private void setSouthPanelAtMainPanelAfterEnding(){
        southPanel.removeAll();
        southPanel.setOpaque(true);
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
        Font gameStatusFont;
        if(isMaximized){
            southPanel.add(Box.createRigidArea(new Dimension(662, 320)));
            southPanel.add(getBigLabelImage(imgSelectedList.get(imgSelectedList.size()-1)));
            southPanel.add(Box.createHorizontalStrut(280));
            gameStatusFont = new Font("Monospaced", Font.BOLD, 40);
        }else{
            southPanel.add(Box.createRigidArea(new Dimension(450, 240)));
            southPanel.add(getSmallLabelImage(imgSelectedList.get(imgSelectedList.size()-1)));
            southPanel.add(Box.createHorizontalStrut(150));
            gameStatusFont = new Font("Monospaced", Font.BOLD, 30);
        }
        JLabel gameStatus = new JLabel("Selected: "+imgSelectedList.size()+"/"+MAX_SIZE_SELECTED_LIST);
        gameStatus.setForeground(Color.WHITE);
        gameStatus.setFont(gameStatusFont);
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(gameStatus, BorderLayout.CENTER);
        statusPanel.setOpaque(false);
        southPanel.add(statusPanel);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
    }
    private void setWestPanelAtMainPanel(){
        westPanel.removeAll();
        if(isMaximized){
            westPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 40, 40));
            westPanel.add(getBigLabelRandomImage());
        }else{
            westPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 45, 40));
            westPanel.add(getSmallLabelRandomImage());
        }
        mainPanel.add(westPanel,BorderLayout.WEST);
    }
    private void setEastPanelAtMainPanel(){
        eastPanel.removeAll();
        if(isMaximized){
            eastPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 40));
            eastPanel.add(getBigLabelRandomImage());
        }else{
            eastPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 45, 40));
            eastPanel.add(getSmallLabelRandomImage());
        }
        mainPanel.add(eastPanel,BorderLayout.EAST);
    }
    private JLabel getSmallLabelRandomImage(){
        String imgName = "img"+new SecureRandom().ints(1, 3, 31).findAny().getAsInt();
        String imgPath = "img/"+imgName+".png";
        Image originalImage = new ImageIcon(getClass().getResource(imgPath)).getImage();
        Image resizedImageSmall = originalImage.getScaledInstance(((Double)(0.18*getScreenSize().width)).intValue(), ((Double)(0.18*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImageSmall);
        imageIcon.setDescription(imgName);
        return new JLabel(imageIcon);
    }
    private JLabel getBigLabelRandomImage(){
        String imgName = "img"+new SecureRandom().ints(1, 3, 31).findAny().getAsInt();
        String imgPath = "img/"+imgName+".png";
        Image originalImage = new ImageIcon(getClass().getResource(imgPath)).getImage();
        Image resizedImageBig = originalImage.getScaledInstance(((Double)(0.3*getScreenSize().width)).intValue(), ((Double)(0.25*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImageBig);
        imageIcon.setDescription(imgName);
        return new JLabel(imageIcon);
    }
    private List<JLabel> getMiniLabelAllSelectedImages(){
        List<String> allSelectedImages = new ArrayList<>();
        allSelectedImages.addAll(imgSelectedList);
        return allSelectedImages.stream().map(x->getMiniLabelImage(x)).collect(Collectors.toList());
    }
    private JLabel getMiniLabelImage(String imgName){
        String imgPath = "img/"+imgName+".png";
        Image originalImage = new ImageIcon(getClass().getResource(imgPath)).getImage();
        Image resizedImageSmall = originalImage.getScaledInstance(((Double)(0.09*getScreenSize().width)).intValue(), ((Double)(0.09*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImageSmall);
        imageIcon.setDescription(imgName);
        return new JLabel(imageIcon);
    }
    private JLabel getBigLabelImage(String imgName){
        String imgPath = "img/"+imgName+".png";
        Image originalImage = new ImageIcon(getClass().getResource(imgPath)).getImage();
        Image resizedImageBig = originalImage.getScaledInstance(((Double)(0.3*getScreenSize().width)).intValue(), ((Double)(0.25*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImageBig);
        imageIcon.setDescription(imgName);
        return new JLabel(imageIcon);
    }
    private JLabel getSmallLabelImage(String imgName){
        String imgPath = "img/"+imgName+".png";
        Image originalImage = new ImageIcon(getClass().getResource(imgPath)).getImage();
        Image resizedImageSmall = originalImage.getScaledInstance(((Double)(0.18*getScreenSize().width)).intValue(), ((Double)(0.18*getScreenSize().height)).intValue(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(resizedImageSmall);
        imageIcon.setDescription(imgName);
        return new JLabel(imageIcon);
    }
    private Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    private void addImgStringToList(String imgName){
        boolean imgAlreadyAdded = imgSelectedList.stream().filter(x->x.equals(imgName)).findAny().isPresent();
        if(!imgAlreadyAdded){
            imgSelectedList.add(imgName);
            if(imgSelectedList.size()>=MAX_SIZE_SELECTED_LIST){
                endGame();
            }    
        } else{
            JOptionPane.showMessageDialog(null, "WRONG! Image already selected before! Choose another!!", "WRONG!", JOptionPane.ERROR_MESSAGE);
            wrongSelections++;
        }
    }
    private void createLastFrameWithSelectedImageLabels(){
        JFrame lastFrame = new JFrame();
        lastFrame.getContentPane().setLayout(new BorderLayout());
        JLabel finalLabel1 = new JLabel("ALL IMAGES SELECTED:");
        finalLabel1.setFont(new Font("Monospaced", Font.PLAIN, 60));
        finalLabel1.setForeground(Color.WHITE);
        JPanel panelFinalLabel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelFinalLabel1.setBackground(Color.BLACK);
        panelFinalLabel1.add(finalLabel1);
        lastFrame.getContentPane().add(panelFinalLabel1,BorderLayout.NORTH);
        JLabel finalLabel2 = new JLabel("Click to: EXIT THE GAME!");
        finalLabel2.setFont(new Font("Monospaced", Font.PLAIN, 60));
        finalLabel2.setForeground(Color.WHITE);
        JPanel panelFinalLabel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelFinalLabel2.setBackground(Color.BLACK);
        panelFinalLabel2.add(finalLabel2);
        lastFrame.getContentPane().add(panelFinalLabel2,BorderLayout.SOUTH);
        JPanel imgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 40));
        imgPanel.setBackground(Color.BLACK);
        getMiniLabelAllSelectedImages().forEach(x->imgPanel.add(x));
        lastFrame.getContentPane().add(imgPanel,BorderLayout.CENTER);
        lastFrame.setIconImage(new ImageIcon(getClass().getResource("img/img1.png")).getImage());
        lastFrame.setSize(((Double)(getScreenSize().width/1.5d)).intValue(),(((Double)(getScreenSize().height/1.3d)).intValue()));
        lastFrame.setTitle("Composite Pattern");
        lastFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lastFrame.setLocationRelativeTo(this);
        lastFrame.setVisible(true);
        lastFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastFrame.setVisible(false);
                lastFrame.dispose();
                System.exit(0);
            }
        });
    }
    private void endGame(){
        ended=true;
        setSouthPanelAtMainPanelAfterEnding();
        Game.this.getContentPane().removeAll();
        Game.this.getContentPane().add(mainPanel);
        Game.this.setVisible(true);
        JOptionPane.showMessageDialog(null, "GAME OVER!\n\nSCORE: "+(wrongSelections+MAX_SIZE_SELECTED_LIST)+" trials - "+wrongSelections+" WRONG and "+(MAX_SIZE_SELECTED_LIST)+" RIGHT.", "GAME OVER!", JOptionPane.INFORMATION_MESSAGE);
        createLastFrameWithSelectedImageLabels();
        this.setVisible(false);
        this.dispose();
    }
}
