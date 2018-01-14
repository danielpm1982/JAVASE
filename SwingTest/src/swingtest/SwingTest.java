package swingtest;
public class SwingTest {
    public static void main(String[] args) {
        JFrameSwing jframe = new JFrameSwing();
        jframe.setDefaultCloseOperation(JFrameSwing.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
