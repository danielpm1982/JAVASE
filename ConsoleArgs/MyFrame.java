package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame extends JFrame{

    public MyFrame(){
            JTextArea textArea;
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,30));
            textArea = new JTextArea();
            textArea.setText("Empty args!!!\nEmpty args!!!\nEmpty args!!!\n");
            textArea.setSize(new Dimension(300, 1));
            textArea.setLineWrap(true);
            textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD&Font.ITALIC, 30));
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(Color.BLACK);
            panel.add(textArea);
            JScrollPane scrollPane = new JScrollPane(panel);
            this.getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
    
    public MyFrame(String[] args) throws Exception{
            JTextArea textArea;
            if(args.length==0){
                throw new Exception("You didn't write any params at the console!");
            }
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,30));
            textArea = new JTextArea();
            textArea.setSize(new Dimension(300, 1));
            textArea.setLineWrap(true);
            Arrays.stream(args).forEach(x->textArea.append(x+" "));
            textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD&Font.ITALIC, 30));
            textArea.setForeground(Color.WHITE);
            textArea.setBackground(Color.BLACK);
            panel.add(textArea);
            JScrollPane scrollPane = new JScrollPane(panel);
            this.getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
}
