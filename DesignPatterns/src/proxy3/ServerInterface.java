package proxy3;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{
    public JOptionPaneArguments getJOptionPaneArguments() throws RemoteException;
}
