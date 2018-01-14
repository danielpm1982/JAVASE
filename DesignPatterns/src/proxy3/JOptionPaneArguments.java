package proxy3;
import java.awt.Component;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.JLabel;

public class JOptionPaneArguments implements Serializable{
    private final Component arg1;
    private final JLabel arg2;
    private final String arg3;
    private final int arg4;
    private final Icon arg5;
    public JOptionPaneArguments(Component parentComponent, JLabel jLable, String title, int messageType, Icon icon) {
        arg1 = parentComponent;
        arg2 = jLable;
        arg3 = title;
        arg4 = messageType;
        arg5 = icon;
    }
    public Component getArg1() {
        return arg1;
    }
    public JLabel getArg2() {
        return arg2;
    }
    public String getArg3() {
        return arg3;
    }
    public int getArg4() {
        return arg4;
    }
    public Icon getArg5() {
        return arg5;
    }
}
