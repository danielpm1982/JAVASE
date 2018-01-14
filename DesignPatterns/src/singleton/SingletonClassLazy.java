package singleton;
public class SingletonClassLazy {
    private static SingletonClassLazy uniqueInstance;
    private SingletonClassLazy() {
    }
//    public static synchronized SingletonClass getInstance(){
//        if(uniqueInstance==null){
//            uniqueInstance=new SingletonClass();
//        }
//        return uniqueInstance;
//    }
    public static SingletonClassLazy getInstance(){
        if(uniqueInstance==null){
            synchronized(SingletonClassLazy.class){
                if(uniqueInstance==null){
                    uniqueInstance=new SingletonClassLazy();
                }
            }
        }
        return uniqueInstance;
    }
    
    @Override
    public String toString() {
        return "This is an unique and thread-safe SingletonClass lazy instance!";
    }
}
