package bridge;
public class TVA implements TVInterface{
    private int currentChannelNumber;
    private final int MAX_CHANNEL_NUMBER;
    private boolean on;
    public TVA() {
        currentChannelNumber=0;
        on=false;
        MAX_CHANNEL_NUMBER=100;
    }
    @Override
    public void on() {
        setOn(true);
    }
    @Override
    public void off() {
        setOn(false);
    }
    @Override
    public void tuneChannel(int requestedChannelNumber) {
        setCurrentChannelNumber(requestedChannelNumber);
    }
    @Override
    public int getCurrentChannelNumber() {
        return currentChannelNumber;
    }
    public void setCurrentChannelNumber(int requestedChannelNumber) {
        this.currentChannelNumber = requestedChannelNumber;
    }
    public void setOn(boolean on) {
        this.on = on;
    }
    public boolean isOn() {
        return on;
    }
    @Override
    public int getMaxChannelNumber(){
        return MAX_CHANNEL_NUMBER;
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
