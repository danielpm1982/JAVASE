package proxy3;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client dateTime is: "+getClientDateTime());
            System.out.println("Servers bound to registry name URL //127.0.0.1/ :");
            Arrays.asList(Naming.list("//127.0.0.1/")).forEach(System.out::println);
            ServerInterface server1 = (ServerInterface)Naming.lookup("server1");
            ServerInterface server2 = (ServerInterface)Naming.lookup("server2");
            ServerInterface server3 = (ServerInterface)Naming.lookup("server3");
            ServerInterface server4 = (ServerInterface)Naming.lookup("server4");
            ServerInterface server5 = (ServerInterface)Naming.lookup("server5");
            System.out.println("Creating and showing respective JOptionPanes for each Server JOptionPaneArguments:");
            createAndShowJOptionPane(server1.getJOptionPaneArguments());
            createAndShowJOptionPane(server2.getJOptionPaneArguments());
            createAndShowJOptionPane(server3.getJOptionPaneArguments());
            createAndShowJOptionPane(server4.getJOptionPaneArguments());
            createAndShowJOptionPane(server5.getJOptionPaneArguments());
            System.out.println("Client program sucessfully executed!");
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    private static String getClientDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
    private static void createAndShowJOptionPane(JOptionPaneArguments jOptionPaneArguments){
        JOptionPane.showMessageDialog(jOptionPaneArguments.getArg1(), jOptionPaneArguments.getArg2(), jOptionPaneArguments.getArg3(), jOptionPaneArguments.getArg4(), jOptionPaneArguments.getArg5());
    }
}

/*
Similar to proxy2 but with JOptionPane arguments in 5 different servers.
*/
