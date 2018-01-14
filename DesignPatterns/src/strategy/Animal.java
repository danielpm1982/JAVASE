package strategy;
import java.time.LocalDate;

public class Animal {
    private LocalDate birthLocalDate;
    private String name;
    private String ownerName;
    private String species;
    private String breed;
    private String color;
    private String email;
    private String phoneNumber;
    private Communicate communicate;
    private Move move;
    private EatDrink eatDrink;

    public Animal() {
        this(null, null, null, null, null, null, null, null);
    }

    public Animal(LocalDate birthLocalDate, String name, String ownerName, String species, String breed, String color, String email, String phoneNumber) {
        this.birthLocalDate = birthLocalDate;
        this.name = name;
        this.ownerName = ownerName;
        this.species = species;
        this.breed = breed;
        this.color = color;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.communicate=new NoCommunication();
        this.move=new NoMove();
        this.eatDrink = new NoEatDrink();
    }

    public LocalDate getBirthLocalDate() {
        return birthLocalDate;
    }

    public void setBirthLocalDate(LocalDate birthLocalDate) {
        this.birthLocalDate = birthLocalDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCommunicate(Communicate communicate) {
        this.communicate = communicate;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public void setEatDrink(EatDrink eatDrink) {
        this.eatDrink = eatDrink;
    }
    
    public void communicateGeneric(){
        System.out.print(this+": ");
        communicate.now();
    }
    
    public void moveGeneric(){
        System.out.print(this+": ");
        move.now();
    }
    
    public void eatDrinkGeneric(){
        System.out.print(this+": ");
        eatDrink.now();
    }

    @Override
    public String toString() {
        return "Name/Owner: "+name+" "+ownerName;
    }
}
