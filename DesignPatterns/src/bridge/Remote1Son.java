package bridge;
public class Remote1Son extends Remote1{
    public Remote1Son(TVInterface tv) {
        super(tv);
    }
    public void nextChannelMulti() {
        int current = tv.getCurrentChannelNumber();
        setChannel(current+10);
    }
}
