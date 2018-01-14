package proxy8;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandlerProxy implements InvocationHandler{
    SubjectInterface realSubject;
    public InvocationHandlerProxy(SubjectInterface realSubject) {
        this.realSubject=realSubject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        try {
            if(method.getName().equals("proceedLowCriticalProcess")){
                System.out.println("Proceeding low critical process...");
                method.invoke(realSubject, args);
            } else if(method.getName().equals("proceedHighCriticalProcess")){
                System.out.println("Proceeding high critical process...");
                if(!realSubject.isLowPrivilege()){
                    method.invoke(realSubject, args);
                } else{
                    throw new IllegalAccessException("ERROR: Illegal access for this type of user! Access NOT granted!");
                }
            }
        } catch (IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace(System.out);
        } catch (IllegalAccessException ex2){
            System.out.println(ex2.getMessage());
        }
        return null;
    }
}
