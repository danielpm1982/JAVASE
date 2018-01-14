package bookmovierental;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("titleBook1", "author1", 20.5);
        Book b2 = new Book("titleBook2", "author2", 32.5);
        Book b3 = new Book("titleBook3", "author3", 21.0);
        Movie m1 = new Movie("titleMovie1", 12, 15.5);
        Movie m2 = new Movie("titleMovie2", 14, 12.9);
        Movie m3 = new Movie("titleMovie3", 16, 34.5);
        
        System.out.println("\n*********FINED !!!!*******");
        ZonedDateTime rentalDateTime = ZonedDateTime.of(2017, 3, 1, 13, 30, 45, 0, ZoneId.of("America/Fortaleza"));
        ZonedDateTime dueDateTime = ZonedDateTime.of(2017, 3, 15, 13, 30, 45, 0, ZoneId.of("America/Fortaleza"));
        RentController controller = new RentController(rentalDateTime, dueDateTime, b1,b2,b3,m1,m2,m3);
        System.out.println(controller);
        System.out.println();
        System.out.println("\n*******NOT FINED !!!!******"); //test made before April 30th of 2017... if tested after that, adjust the dueDate for a later date, so that the fine won't be generated.
        ZonedDateTime rentalDateTime2 = ZonedDateTime.of(2017, 3, 1, 13, 30, 45, 0, ZoneId.of("America/Fortaleza"));
        ZonedDateTime dueDateTime2 = ZonedDateTime.of(2017, 4, 30, 13, 30, 45, 0, ZoneId.of("America/Fortaleza"));
        RentController controller2 = new RentController(rentalDateTime2, dueDateTime2, b1,b2,b3,m1,m2,m3);
        System.out.println(controller2);
    }
}
