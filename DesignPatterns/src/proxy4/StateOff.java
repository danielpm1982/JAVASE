package proxy4;
import java.rmi.RemoteException;

public class StateOff implements State{
    transient private final ServerInterface server;
    public StateOff(ServerInterface server) {
        this.server=server;
    }
    @Override
    public void changeState() {
        try {
            server.setCurrentState(server.getStateOn());
        } catch (RemoteException ex) {
            ex.printStackTrace(System.out);
        }
    }
    @Override
    public String toString() {
        return "State OFF!";
    }
}
