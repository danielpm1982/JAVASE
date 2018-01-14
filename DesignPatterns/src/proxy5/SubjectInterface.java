package proxy5;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SubjectInterface extends Remote{
    public List<String> getRemoteStringList() throws RemoteException;
}
