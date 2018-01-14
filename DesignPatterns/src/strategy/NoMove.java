package strategy;
public class NoMove implements Move{
    @Override
    public void now() {
        System.out.println("No move!");
    }
}
