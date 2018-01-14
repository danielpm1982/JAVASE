package proxy8;

public class Main {
    public static void main(String[] args) {
        proceed(new RealSubject("client123Subject",true));
        proceed(new RealSubject("highLevelManagerSubject",false));
        proceed(new RealSubject("client456Subject",true));
        proceed(new RealSubject("lowLevelManagerSubject",true));
    }
    public static void proceed(SubjectInterface realSubject){
        System.out.println(realSubject+":");
        SubjectInterface proxy = DynamicProxyGenerator.getDynamicProxy(realSubject);
        proxy.proceedLowCriticalProcess();
        proxy.proceedHighCriticalProcess();
        System.out.println("");
    }
}

/*
In a protectionProxy, the Proxy can be generated dynamically, using the reflection API. 
Other than the Proxy, the second class that collaborates with the proxy is the InvocationHandler
class, where decisions can be made, using the method String name, for instance, so that the proxy
can control the invocation only in certain circumstances... after authorization, e.g. The Proxy
generating class (and method) then uses that invocationHandler instance as an argument to create the
dynamic proxy instance, which can be used to call any Subject interface method. These calls,
in this case, are directed to the InvocationHandler controlling object before being sent to
the RealSubject object, which is, this way, protected.
In this example, before calling the RealSubject, the call to the proxy passes to the InvocationHandler
object that checks the method name and the realSubject boolean status... if the method is a low privilege
call, then it can be called on every subject (subjects could be clients, for instance). If, on the other
hand, the method is a high privilege call, it can be called only on high privilege subjects.
There are other Proxy types as: Firewall, SmartReference, Caching, Synchronization, ComplexicityHiding,
and Copy-on-write.
*/
