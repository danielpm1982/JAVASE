package proxy2;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{
    public EntitySampleObject getSampleObject() throws RemoteException;
    public String getServerStartingTime() throws RemoteException;
}
