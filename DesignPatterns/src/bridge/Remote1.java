package bridge;
public class Remote1 implements RemoteControlIntreface{
    TVInterface tv;
    public Remote1(TVInterface tv) {
        this.tv=tv;
    }
    @Override
    public void on() {
        System.out.println("Turning "+tv+" on from "+this.getClass().getSimpleName());
        tv.on();
        System.out.println("Turned on!");
    }
    @Override
    public void off() {
        System.out.println("Turning "+tv+" off from "+this.getClass().getSimpleName());
        tv.off();
        System.out.println("Turned off!");
    }
    @Override
    public void setChannel(int requestedChannelNumber) {
        if(requestedChannelNumber>=0&&requestedChannelNumber<=tv.getMaxChannelNumber()){
            System.out.println("Setting channel "+requestedChannelNumber+" at "+tv+" with "+this.getClass().getSimpleName());
            tv.tuneChannel(requestedChannelNumber);
            System.out.println("Channel set!");
        } else{
            System.out.println("Channel number out of bounds! (0-"+tv.getMaxChannelNumber()+") Channel number NOT set!");
        }
    }
    @Override
    public void nextChannel() {
        int current = tv.getCurrentChannelNumber();
        setChannel(current+1);
    }
    @Override
    public void previousChannel() {
        int current = tv.getCurrentChannelNumber();
        setChannel(current-1);
    }
}
