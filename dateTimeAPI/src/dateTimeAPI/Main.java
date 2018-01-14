package dateTimeAPI;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        
        //LocalDate
        LocalDate localDate = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("LocalDate = "+localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("300th day of 2016: "+LocalDate.ofYearDay(2016, 300).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        
        //LocalTime
        LocalTime localTime = LocalTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("LocalTime = "+localTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println("LocalTimeBySecondOfDay: "+LocalTime.ofSecondOfDay(24*60*60-1));
        
        //ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("ZonedDateTime = "+zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));

        //Changing ZonedDateTime hour/time and time-zone
        zonedDateTime=ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET")));
        //zonedDateTime = zonedDateTime.withZoneSameLocal(ZoneId.of(ZoneId.SHORT_IDS.get("BET")));
        System.out.println("ZonedDateTime = "+zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        
        //Using Parse to sendo the text and formatter to the ZoneDateTime factory... the text and formatter must match when parsing!
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse(ZonedDateTime.of(1982, 04, 22, 14, 30, 00, 00, ZoneId.of(ZoneId.SHORT_IDS.get("BET"))).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)), DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        //differently from parsing, after the zonedDateTime is created, any formatter can then be used to show the text.
        System.out.println(zonedDateTime2.format(DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy hh'h':mm'm':ss's' a G VV z O.")));
        
        //Instant and Duration (time-based)
        Instant instant1 = Instant.now();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println("Duration ("+instant2.toEpochMilli()/1000+"-"+instant1.toEpochMilli()/1000+"): "+duration.getSeconds()+"s.");
        
        Duration duration2 = Duration.of(50, ChronoUnit.DAYS);
        Duration duration3 = ChronoUnit.DAYS.getDuration().multipliedBy(50);
        System.out.println(duration2.compareTo(duration3)==0?"duration2 = duration3 ("+duration2.getSeconds()+"s)":"duration2 != duration3");
        
        //Period (date-based)
        Period period = Period.between(LocalDate.of(1982, Month.APRIL, 22), LocalDate.now());
        System.out.println("Daniel's age is: "+period.getYears()+" year(s) "+period.getMonths()+" month(s) and "+period.getDays()+" days of living!");
        
        //Example of flight travel considering different ZoneIDs (Time-Zones)
        System.out.println("\nTravelling to Paris from São Paulo:");
        ZonedDateTime departureTime = ZonedDateTime.of(2016, 06, 18, 14, 00, 00, 00, ZoneId.of(ZoneId.SHORT_IDS.get("BET")));
        Duration flightDuration = Duration.ofMinutes(60*11+15);
        ZonedDateTime arrivalTime = departureTime.plusMinutes(flightDuration.toMinutes()).plusHours(5).withZoneSameLocal(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
        System.out.println("Departure time: "+departureTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL))+"\nArrival time: "+arrivalTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println("Hours of flight: "+flightDuration.getSeconds()/3600+" hours and "+flightDuration.getSeconds()%3600/60+" minutes. Plus 5h for the local Paris time ahead of Brazil's time.");
        int hoursDifference = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT"))).getHour()-ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("BET"))).getHour();
        System.out.println("Paris time - Brazil time = "+hoursDifference+" hours.");
        System.out.println("");
        
        //ZoneID SHORT_IDS Map
        System.out.println("--------------------------------");
        ZoneId.SHORT_IDS.forEach((x,y)->System.out.println(x+" "+y));
        
    }
}
