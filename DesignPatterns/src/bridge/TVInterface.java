package bridge;
public interface TVInterface {
    public abstract void on();
    public abstract void off();
    public abstract void tuneChannel(int requestedChannelNumber);
    public int getCurrentChannelNumber();
    public int getMaxChannelNumber();
}
