package proxy4;
import java.rmi.RemoteException;

public class StateOn implements State{
    transient private final ServerInterface server;
    public StateOn(ServerInterface server) {
        this.server=server;
    }
    @Override
    public void changeState() {
        try {
            server.setCurrentState(server.getStateOff());
        } catch (RemoteException ex) {
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public String toString() {
        return "State ON!";
    }
}
