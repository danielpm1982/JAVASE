package strategy;
public class NoEatDrink implements EatDrink{
    @Override
    public void now() {
        System.out.println("No eat or drink!");
    }
}
