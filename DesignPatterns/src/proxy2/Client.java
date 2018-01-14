package proxy2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client dateTime is: "+getClientDateTime());
            ServerInterface server = (ServerInterface)Naming.lookup("server");
            System.out.println("Server starting and Stub binding dateTime is: "+server.getServerStartingTime());
            System.out.println("Waiting some time (5 seconds):");
            Thread.sleep(5000);
            System.out.println("Server SampleObject creation dateTime is: "+server.getSampleObject());
            System.out.println("Sequence of events in time: Server starting and Stub binding ==> Client starting ==> Server SampleObject creation by Client Stub call.");
        } catch (NotBoundException | MalformedURLException | RemoteException | InterruptedException ex) {
            ex.printStackTrace(System.out);
        }
    }
    private static String getClientDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}

/*
Similar to proxy1, in proxy2 we have a Sample and serializable object being used
as a return to the client when the client calls some method at the local Stub, which
delegates the call to the Server object (or its skeleton) at the server side.
DateTime String data was used at different moments to show the sequence of events
in time:
- 1st: the Server is started and the Stub dynamically created or obtained from a 
previously created static Stub, if the file exists;
- 2nd: the Client is started;
- 3rd: the Client calls a method on the local Stub, which delegates that call to
the Server object (or to its skeleton), and ONLY THEN the sample object is created
by the call of the client and returned to him, not before.
*/
