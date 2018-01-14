package strategy;
import java.time.LocalDate;

public class Cat extends Animal{
    public Cat() {
        super();
    }
    public Cat(LocalDate birthLocalDate, String name, String ownerName, String species, String breed, String color, String email, String phoneNumber) {
        super(birthLocalDate, name, ownerName, species, breed, color, email, phoneNumber);
    }
}
