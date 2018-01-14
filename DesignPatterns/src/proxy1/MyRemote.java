package proxy1;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemote extends Remote{
    public List<String> getRemoteStringList() throws RemoteException;
}
