package proxy4;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonitorExecutor {
    public static void executeMonitorForThisURL(String URL_String){
        System.out.println("URL: "+URL_String+" :");
        Monitor monitor = new Monitor(getAllServerStubArrayForThisURL(URL_String));
        monitor.printAllServersWithStates();
        monitor.changeAllServersStates();
        monitor.printAllServersWithStates();
        System.out.println("");
    }
    private static ServerInterfaceClientFacade[] getAllServerStubArrayForThisURL(String URL_String){
        final List<ServerInterfaceClientFacade> serverStubList = new ArrayList<>(); //list of stubs of each server running and registered with this specific URL_String.
        List<String> tempServerNameList = null; //list of all complete URL Strings (URL+serverName) registered from this URL_String at its rmiregistry, to be looked up.
        try {    
            tempServerNameList = Arrays.asList(Naming.list(URL_String));
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
        if(tempServerNameList!=null){
            tempServerNameList.forEach(x->{
                try {
                    serverStubList.add((ServerInterfaceClientFacade)Naming.lookup(x));
                } catch (RemoteException | MalformedURLException |  NotBoundException ex) {
                    ex.printStackTrace(System.out);
                }
            });
        }
        return serverStubList.toArray(new ServerInterfaceClientFacade[0]);
    }
}
