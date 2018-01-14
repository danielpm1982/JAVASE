package proxy8;
public interface SubjectInterface {
    public abstract boolean isLowPrivilege();
    public abstract void proceedLowCriticalProcess();
    public abstract void proceedHighCriticalProcess();
}
