package singleton;
public class SingletonClassEager {
    private final static SingletonClassEager uniqueInstance=new SingletonClassEager();
    private SingletonClassEager() {
    }
    public static SingletonClassEager getInstance(){
        return uniqueInstance;
    }
    @Override
    public String toString() {
        return "This is an unique and thread-safe SingletonClass eager instance!";
    }
}
