package proxy8;
import java.lang.reflect.Proxy;
public class DynamicProxyGenerator {
    public static SubjectInterface getDynamicProxy(SubjectInterface realSubject){
        return (SubjectInterface)Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(), 
                realSubject.getClass().getInterfaces(), 
                new InvocationHandlerProxy(realSubject));
    }
}
