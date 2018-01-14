package proxy5;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class RegistryServicer {
    public static List<String> getBoundedStubNameList(String URLString){
        List<String> tempList = null; 
        try {
            tempList = (List<String>) Arrays.asList(Naming.list(URLString));
        } catch (RemoteException | MalformedURLException ex) {
            ex.printStackTrace(System.out);
        }
        return tempList;
    }
}
