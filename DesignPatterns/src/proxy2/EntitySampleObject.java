package proxy2;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class EntitySampleObject implements Serializable{
    private final String creationDateTimeString;
    public static EntitySampleObject getInstance(){
        return new EntitySampleObject();
    }
    private EntitySampleObject() {
       creationDateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
    @Override
    public String toString() {
        return creationDateTimeString;
    }
}
