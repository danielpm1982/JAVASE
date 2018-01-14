package proxy5;
import java.rmi.RemoteException;
import java.util.List;

public class Main{
    private static final String URL_STRING_PARTIAL = "rmi://127.0.0.1/";
    private static final String URL_STRING_COMPLETE = "rmi://127.0.0.1/RealSubject";
    public static void main(String[] args) throws RemoteException {
        List<String> stubNameList = RegistryServicer.getBoundedStubNameList(URL_STRING_PARTIAL);
        System.out.println(stubNameList.size()+" Stub name registered at this URL (IP) RMI Registry:");
        stubNameList.forEach(System.out::println);
        System.out.println("Getting Stub for Stub name "+"\"RealSubject\" and treating it as the original and remote RealSubject concrete object:");
        SubjectInterface proxy = ProxySingleton.getInstance(URL_STRING_COMPLETE);
        if(proxy!=null){
            System.out.println("Got it!");
            System.out.println("Working with the Stub as if it was the remote RealSubject concrete object placed locally:");
            List<String> list = proxy.getRemoteStringList();
            list.forEach(System.out::print);
        }
        System.out.println("");
    }
}

/*
The same as proxy1 package, but with the UML names for the Proxy Pattern (Remote Proxy Pattern, here):
- Proxy;
- RealSubject;
- Subject (interface).
Besides this, there are actually 3 main types of Proxy implementations, based on the type of access control
of the proxy regarding the realsubject it represents and controls access to:
- Remote Proxy;
- Virtual Proxy;
- Protection/Security Proxy.

Also, two classes were added for getting the Stub (looking up) and for getting the Stub list associated to the 
partial URL (IP)... encapsulating, thus, the Registry access for both responsabilities and decoupling them from 
the Main.

"The Proxy Pattern provides a surrogate or placeholder for another object to control access to it."
"Use the Proxy Pattern to create a representative object that controls access to another object, which 
may be remote, expensive to create or in need of securing."
(Head First, Design Patterns, 2004)
*/
