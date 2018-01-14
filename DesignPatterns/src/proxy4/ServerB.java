package proxy4;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerB extends UnicastRemoteObject implements ServerInterface, ServerInterfaceClientFacade{
    private final State stateOn;
    private final State stateOff;
    private State currentState;
    public ServerB() throws RemoteException{
        stateOn=new StateOn(this);
        stateOff=new StateOff(this);
        currentState=stateOff;
    }
    @Override
    public void setCurrentState(State state) throws RemoteException{
        currentState=state;
    }
    @Override
    public State getCurrentState() throws RemoteException{
        return currentState;
    }
    @Override
    public State getStateOn() throws RemoteException{
        return stateOn;
    }
    @Override
    public State getStateOff() throws RemoteException{
        return stateOff;
    }
    @Override
    public void changeState() throws RemoteException{
        currentState.changeState();
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    @Override
    public String getServerName() throws RemoteException {
        return this.toString();
    }
    public static void main(String[] args) {
        try {
            ServerInterfaceClientFacade server = new ServerB();
            Naming.rebind(server.toString(), server);
            System.out.println(server.toString()+" up and Stub bound to registry!");
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
