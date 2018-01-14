package proxy4;
import java.rmi.RemoteException;

public interface ServerInterface extends ServerInterfaceClientFacade{
    public abstract void setCurrentState(State state) throws RemoteException;
//    public abstract State getCurrentState() throws RemoteException;
    public abstract State getStateOn() throws RemoteException;
    public abstract State getStateOff() throws RemoteException;
//    public abstract void changeState() throws RemoteException;
//    public abstract String getServerName() throws RemoteException;
}
