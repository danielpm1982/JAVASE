package proxy1;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class Client{
    public static void main(String[] args) {
        try {
            System.out.println("Stub names bound in the registry:");
            Arrays.asList(Naming.list("rmi://127.0.0.1/MyRemote")).forEach(System.out::println);
            System.out.println("Getting Stub for name "+"\"MyRemote\" and treating it as the original and remote MyRemote concrete object:");
            MyRemote service = (MyRemote)Naming.lookup("rmi://127.0.0.1/MyRemote");
            if(service!=null){
                System.out.println("Got it!");
                System.out.println("Working with the Stub as if it was the remote MyRemote concrete object placed locally:");
                List<String> list = service.getRemoteStringList();
                list.forEach(System.out::print);
            }
            System.out.println("");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

/*
On the server side, besides the creation of the interface and concrete service class, there 
is no need to call java rmic to create static stubs or skeletons anymore, nor it is needed 
to have a copy of the stub class on the client side (these demands are deprecated). The
creation of the stub and skeleton is done dynamically, by the JVM, and the archives are not 
visible at the build/classes directory of the project (as when created manually with rmic).
There is the need, however, to initiate java rmiregistry (through the console) before running
the server service class (here, MyRemoteService), in order to let it bind the service's stub 
with the service name in the common registry that the client will access to get the stub. 
The command rmiregistry must be called inside the build/classes directory, just outside the 
package name for that specific .class classes (here, just outside proxy1).
After starting the rmiregistry, starting the server service (here, MyRemoteService class) and 
biding its stub (created by the JVM) to a registry name, the only thing left is for the client 
to look up for that name, at the client side, and get the corresponding stub. The Remote stub 
object is casted and associated with a variable of that service interface (here, MyRemote), and 
treated as if it really was a local service, and not a stub (proxy) for a remote skeleton of
a remote service object, over the internet. In respect of the service method provided by the
service object at the server side, it must return to the client (service object -> skeleton -> 
client stub -> client object) only primitive or serializable objects, including String or some
native java objects that are by default serializable (Collections, for instance). If the object
returned is a customized object, and not serializable by default, it must implement serializable 
interface before being sent back as a response for a client stub call over the internet.
The service interface (here, MyRemote) extends Remote, and must declare every method signature
throwing a RemoteException, as must all implemented methods at its concrete classes, which, 
in turn, extend a RemoteServer class (UnicastRemoteObject, e.g.) and implement the service
interface(s).
*/
