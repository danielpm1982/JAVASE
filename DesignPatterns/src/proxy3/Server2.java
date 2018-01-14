package proxy3;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Server2 extends UnicastRemoteObject implements ServerInterface{
    private static final String SERVER_STARTING_TIME = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    public Server2() throws RemoteException{}
    @Override
    public JOptionPaneArguments getJOptionPaneArguments() throws RemoteException {
        return new JOptionPaneArguments(null, new JLabel(new ImageIcon(getClass().getResource("img2.png"))), "Server2: "+SERVER_STARTING_TIME, JOptionPane.PLAIN_MESSAGE, null);
    }
    public static void main(String[] args) {
        try {
            System.out.println("Starting Server...");
            ServerInterface server = new Server2();
            System.out.println("Server started! At: "+SERVER_STARTING_TIME);
            System.out.println("Binding Stub to the RMI registry...");
            Naming.rebind("server2", server);
            System.out.println("Stub bound!");
            System.out.println("Keep this Server thread alive until Stub object is sucessfully obtained and used by the Client!");
            System.out.println("After closing this thread, no communication will be possible between the client Stub and the Server Skeleton or Server Object itself!");
            System.out.println("At the end, do not forget to close the rmiregistry thread, at the console, too.");
            System.out.println("If any code is changed at the Server class, the static Stub might have to be rebuilt and the Server must"
                    + " be restarted!");
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
