package proxy8;
public class RealSubject implements SubjectInterface{
    private final String name;
    private final boolean isLowPrivilege;
    public RealSubject(String name, boolean isLowPrivilege) {
        this.name=name;
        this.isLowPrivilege=isLowPrivilege;
    }
    @Override
    public boolean isLowPrivilege() {
        return isLowPrivilege;
    }
    @Override
    public void proceedLowCriticalProcess() {
        System.out.println("Low critical process successfully completed!");
    }
    @Override
    public void proceedHighCriticalProcess() {
        System.out.println("High critical process successfully completed!");
    }
    @Override
    public String toString() {
        return name;
    }
}
