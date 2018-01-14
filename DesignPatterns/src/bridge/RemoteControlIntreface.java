package bridge;
public interface RemoteControlIntreface {
    public abstract void on();
    public abstract void off();
    public abstract void setChannel(int requestedChannelNumber);
    public abstract void nextChannel();
    public abstract void previousChannel();
}
