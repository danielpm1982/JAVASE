package proxy1;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

public class MyRemoteService extends UnicastRemoteObject implements MyRemote{
    public MyRemoteService() throws RemoteException {}
    @Override
    public List<String> getRemoteStringList() throws RemoteException {
        return Arrays.asList("Hello, "+"I am "+"a remote service "+"String "+"accessed from a client"+" through a JAVA RMI(RPC) API!");
    }
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteService();
            Naming.rebind("MyRemote", service);
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
