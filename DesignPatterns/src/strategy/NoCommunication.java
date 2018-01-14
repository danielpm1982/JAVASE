package strategy;
public class NoCommunication implements Communicate{
    @Override
    public void now() {
        System.out.println("No communication!");
    }
}
