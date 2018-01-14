package proxy4;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterfaceClientFacade extends Remote{
    public abstract State getCurrentState() throws RemoteException;
    public abstract String getServerName() throws RemoteException;
    public abstract void changeState() throws RemoteException;
}
