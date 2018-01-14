package proxy5;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxySingleton {
    private static SubjectInterface proxy;
    private ProxySingleton() {
    }
    public static SubjectInterface getInstance(String URLString){
        if(proxy==null){
            synchronized(SubjectInterface.class){
                try {
                    if (proxy == null) {
                        proxy = (SubjectInterface) Naming.lookup(URLString);                        
                    }
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return proxy;
    }
}
