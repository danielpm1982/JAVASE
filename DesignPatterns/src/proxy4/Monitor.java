package proxy4;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class Monitor {
    private final List<ServerInterfaceClientFacade> serverStubList;
    public Monitor(ServerInterfaceClientFacade... serverStubArray) {
        serverStubList = Arrays.asList(serverStubArray);
    }
    public void printAllServersWithStates(){
        serverStubList.forEach(x->{
            try {
                System.out.println(x.getServerName()+": "+x.getCurrentState());
            } catch (RemoteException ex) {
                ex.printStackTrace(System.out);
            }
        });
    }
    public void changeAllServersStates(){
        serverStubList.forEach(x->{
            try {
                x.changeState();
            } catch (RemoteException ex) {
                ex.printStackTrace(System.out);
            }
        });
    }
}
