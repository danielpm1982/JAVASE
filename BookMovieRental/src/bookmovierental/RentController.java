package bookmovierental;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.stream.Stream;

public class RentController {
    private final ZonedDateTime RENTAL_DATE_TIME;
    private final ZonedDateTime DUE_DATE_TIME;
    private final ZonedDateTime PAY_DATE_TIME;
    private final double RENTAL_FEE;
    private final double RENTAL_FINE;
    private final Item[] items;
    public RentController(ZonedDateTime rentalDateTime, ZonedDateTime dueDateTime, Item... items) {
        this.RENTAL_DATE_TIME=rentalDateTime;
        this.DUE_DATE_TIME=dueDateTime;
        this.PAY_DATE_TIME=ZonedDateTime.now(ZoneId.of("America/Fortaleza"));
        this.items=items;
        RENTAL_FEE=calculateRentalFee(this.items);
        RENTAL_FINE=calculateRentalFine(this.items);
    }
    private double calculateRentalFee(Item[] items){
        return Stream.of(items).map(x->x.rentalPrice).mapToDouble(Double::doubleValue).sum();
    }
    private boolean isOverdue(){
        return DUE_DATE_TIME.isBefore(PAY_DATE_TIME);
    }
    private double calculateRentalFine(Item[] items){
        return isOverdue() ? getTotalFine(items) : 0;
    }
    private double getTotalFine(Item[] items){
        return Stream.of(items).map(x->x.getFineTax()*x.rentalPrice).mapToDouble(Double::doubleValue).reduce(0, (a,b)->a+b); //getFineTax() is polymorphic and dynamic bound to each respective Item concrete object
    }
    public double getTotalFee(){
        return RENTAL_FEE+RENTAL_FINE;
    }
    @Override
    public String toString() {
        return "RentalDateTime: "+RENTAL_DATE_TIME.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))+"\nDueDateTime: "+DUE_DATE_TIME.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))+"\nPayDateTime: "+PAY_DATE_TIME.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))+"\nItems: "+Arrays.toString(items)+"\nRentalFee: "+RENTAL_FEE+(isOverdue()?"\nRentalFine: "+RENTAL_FINE:"")+"\nTotalFee: "+getTotalFee();
    }
}
