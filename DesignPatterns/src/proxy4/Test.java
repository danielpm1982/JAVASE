package proxy4;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        final String URL_STRING1 = "rmi://127.0.0.1:1099/";
        final String URL_STRING2 = "rmi//192.168.25.23/";
        final String URL_STRING3 = "//localhost/";
        Arrays.asList(URL_STRING1, URL_STRING2, URL_STRING3).forEach(x->MonitorExecutor.executeMonitorForThisURL(x));
    }
}

/*
Basically a union of State Pattern with Proxy Pattern, in which two interfaces had to be
used for the remote concrete objects: one for being used at the server side (with the
State classes, for reusing them with all Server classes, and make all methods available...) 
and another for rebinding the remote objects Stubs to the registry (with that type) and being 
used by the client, as a client simpler view, with fewer visible methods.
A better encapsulation of this facade interface was not possible because only interfaces
de facto could be used, not abstract classes, as there's no multiple inheritance for classes 
in JAVA and the concrete remote classes had already to extend UnicastRemoteObject concrete class, 
besides implementing both service interfaces. If the client uses the Stub oriented to the
client interface, only the methods he should view will appear... although he can, otherwise,
downcast the Remote Stub object to the lower level interface (server view) and have access to 
the methods that only the servers would have interest in. A better design could maybe be proposed 
for avoiding that and for guaranteeing a better encapsulation of the methods the client should not 
view.
Different URL_Strings (here, 3!) could be used along with the Monitor object in order to 
print and change the state of all servers of each URL_String at a time.
Here, the same localhost was used with three equivalent URL_Strings only to simulate the three 
or more eventual different URLs (domains) that could be monitored by this program. Each URL_String 
would have a different registry, configured with its own domain, on its own JVM, from which registry 
the client Monitor would look up for the Stubs (and manipulate them) for each serverName registered 
at that URL JVM registry. Then for another URL JVM registry, and another, and so on. For each URL_String, 
a set of the Stubs of all serverNames would be got, and processed, at a time.
Even if the server rebinds only the serverName, for each Stub, what the JVM actually registers is
the whole URL+ServerName for that URL (e.g. "rmi://127.0.0.1:1099/ServerA") associated with the Stub.
At the Naming.list() method, the argument can be only the URL, and the result will be all complete URL
names (URL+serverName) for every bound Stub... and that is what is looked up, later, with Naming.lookup() method.
*/
