package proxy2;
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

public class Server extends UnicastRemoteObject implements ServerInterface{
    private static final String SERVER_STARTING_TIME = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    public Server() throws RemoteException{}
    @Override
    public EntitySampleObject getSampleObject() throws RemoteException{
        return EntitySampleObject.getInstance();
    }
    @Override
    public String getServerStartingTime() throws RemoteException {
        return SERVER_STARTING_TIME;
    }
    public static void main(String[] args) {
        try {
            System.out.println("Starting Server...");
            ServerInterface server = new Server();
            System.out.println("Server started! At: "+SERVER_STARTING_TIME);
            System.out.println("If a static Stub is found, it will be used. Otherwise, a dynamically created Stub will, instead.");
            System.out.println("Either way, the Stub is only a remote communication interface object. Any object returned by"
                    + " client calls will only be created as the calls are performed;");
            System.out.println("SampleObject DateTime will always be the"
                    + " time of the method call and not the DateTime of the Server starting or of the Stub creation or binding to the RMI registry!");
            System.out.println("Binding Stub to the RMI registry...");
            Naming.rebind("server", server);
            System.out.println("Stub bound! But no method called yet (and no objects created by any method)!");
            System.out.println("Keep this Server thread alive until Stub object is sucessfully obtained and used by the Client!");
            System.out.println("After closing this thread, no communication will be possible between the client Stub and the Server Skeleton or Server Object itself!");
            System.out.println("At the end, do not forget to close the rmiregistry thread, at the console, too.");
            System.out.println("If any code is changed at the Server class, the static Stub might have to be rebuilt and the Server must"
                    + " be restarted!");
            JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(server.getClass().getResource("img.png"))), "About Stub creation", JOptionPane.PLAIN_MESSAGE);
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
