/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigInteger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class MyJFrame extends JFrame{
    private final MyJPanel panel1;
    private final JPanel panel2;
    private final JPanel panel3;
    private final JPanel panel4;
    private final JTextField field;
    private final JTextField field2;
    private final JLabel label1;
    private final JTextArea resultArea;
    private final JTextArea intermediateResultArea1;
    private final JTextArea intermediateResultArea2;
    private final JProgressBar progressBar1;
    private final JProgressBar progressBar2;
    public MyJFrame() {
        progressBar1= new JProgressBar();
        progressBar1.setPreferredSize(new Dimension(0, 20));
        progressBar2= new JProgressBar();
        progressBar2.setPreferredSize(new Dimension(0, 20));
        
        panel1 = new MyJPanel(new BorderLayout());
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING,30,20));
        panel3 = new JPanel(new BorderLayout());
        panel4 = new JPanel(new BorderLayout());
        
        label1 = new JLabel("Fibonacci Calculator",JLabel.LEADING);
        label1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setFocusable(true);
        label1.requestFocus();
        
        resultArea = new JTextArea("Results ", 10, 0);
        resultArea.setBackground(Color.BLACK);
        resultArea.setLineWrap(true);
        resultArea.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 20));
        resultArea.setForeground(Color.WHITE);
        resultArea.setFocusable(true);
        
        intermediateResultArea1 = new JTextArea("Intermediate Results", 10, 0);
        intermediateResultArea1.setBackground(Color.WHITE);
        intermediateResultArea1.setLineWrap(true);
        intermediateResultArea1.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 10));
        intermediateResultArea1.setForeground(Color.BLACK);
        intermediateResultArea1.setFocusable(true);
        
        intermediateResultArea2 = new JTextArea("Intermediate Results", 10, 0);
        intermediateResultArea2.setBackground(Color.WHITE);
        intermediateResultArea2.setLineWrap(true);
        intermediateResultArea2.setFont(new Font(Font.SANS_SERIF, Font.HANGING_BASELINE, 10));
        intermediateResultArea2.setForeground(Color.BLACK);
        intermediateResultArea2.setFocusable(true);
        
        field = new JTextField("Insert a number");
        field.setPreferredSize(new Dimension(150, 50));
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field.isEnabled())
                    field.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(((JTextField)e.getSource()).getText().compareTo("Calculating...")!=0){
                    field.setText(" Insert a number ");
                }
            }
        });
        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(field.isEnabled())
                    field.setText("");
            }
        });
        field.addActionListener(e->
            {
                try{
                    intermediateResultArea1.setText("");
                    progressBar1.setValue(0);
                    MySwingWorker task = new MySwingWorker(new BigInteger(((JTextField)e.getSource()).getText()), field, resultArea, intermediateResultArea1);
                    task.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent e) {
                            if(e.getPropertyName().equals("progress")){
                                progressBar1.setValue((int)e.getNewValue());
                            }
                        }
                    });
                    task.execute();
                    field.setText("Calculating...");
                    field.setEnabled(false);
                    label1.requestFocus();
                } catch (Exception actionException){
                    actionException.printStackTrace();
                }
            }
        );
        
        field2 = new JTextField("Insert a number");
        field2.setPreferredSize(new Dimension(150, 50));
        field2.setHorizontalAlignment(JTextField.CENTER);
        field2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        field2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field2.isEnabled())
                    field2.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(((JTextField)e.getSource()).getText().compareTo("Calculating...")!=0){
                    field2.setText(" Insert a number ");
                }
            }
        });
        field2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(field.isEnabled())
                    field2.setText("");
            }
        });
        field2.addActionListener(e->
            {
                try{
                    intermediateResultArea2.setText("");
                    progressBar2.setValue(0);
                    MySwingWorker task2 = new MySwingWorker(new BigInteger(((JTextField)e.getSource()).getText()), field2, resultArea, intermediateResultArea2);
                    task2.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent e) {
                            if(e.getPropertyName().equals("progress")){
                                progressBar2.setValue((int)e.getNewValue());
                            }
                        }
                    });
                    task2.execute();
                    field2.setText("Calculating...");
                    field2.setEnabled(false);
                    label1.requestFocus();
                } catch (Exception actionException){
                    actionException.printStackTrace();
                }
            }
        );
        
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1.requestFocus();
            }
        });
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1.requestFocus();
            }
        });
        panel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1.requestFocus();
            }
        });
        panel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label1.requestFocus();
            }
        });
        
        panel2.setBackground(Color.BLACK);
        panel2.add(label1);
        panel2.add(field);
        panel2.add(field2);
        panel3.add(new JScrollPane(resultArea),BorderLayout.CENTER);
        JButton clearResultArea = new JButton("CLEAR RESULTS");
        clearResultArea.addActionListener(x->resultArea.setText("Results "));
        panel3.add(clearResultArea,BorderLayout.SOUTH);
        //JPanel progressPanel = new JPanel(new GridLayout(2, 1));
        JPanel progressPanel=new JPanel(new BorderLayout());
        progressPanel.add(progressBar1,BorderLayout.NORTH);
        ImageIcon icon = new ImageIcon(getClass().getResource("fibo.gif"));
        JLabel label = new JLabel(icon);
        label.setPreferredSize(new Dimension(100, 300));
        progressPanel.add(label,BorderLayout.CENTER);
        progressPanel.add(progressBar2,BorderLayout.SOUTH);
        panel4.add(progressPanel,BorderLayout.CENTER);
        panel4.add(new JScrollPane(intermediateResultArea1),BorderLayout.NORTH);
        panel4.add(new JScrollPane(intermediateResultArea2),BorderLayout.SOUTH);
        panel1.add(panel2,BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.SOUTH);
        panel1.add(panel4, BorderLayout.WEST);
        this.getContentPane().add(panel1);
    }
}
