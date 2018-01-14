package javaapplication50;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class JavaApplication50 {
    public static void main(String[] args) {
        
        /* To get an instance of LocalDateTime it can be used static factory methods as "now",
        "of" (date and time literals, parameter by parameter),"parse" (String value of a DateTime) 
        or "from" (another DateTime object). */
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2016, 06, 05, 00, 52, 00);
        LocalDateTime ldt3 = LocalDateTime.parse("2016-07-05T02:25:00");
        LocalDateTime ldt4 = LocalDateTime.from(ldt1);
        
        /* To get an instance of DateTimeFormatter it can be used static factory methods as "ofPattern"
        (with a String representing a pattern according to the documentation), "ofLocalizedDateTime" 
        (with a FormatStyle according to local language) or a constant variable assigned to a 
        DateTimeFormatterBuilder predefined instance. */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yy hh:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter formatter3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        
        /* DateTimeFormatter objects main instance method is the "format", which receives a date
        and returns a String representing the DateTime according to the formatter pattern. */
        System.out.println(formatter.format(ldt1));
        System.out.println(formatter2.format(ldt2));
        System.out.println(formatter3.format(ldt3));
        System.out.println(formatter.format(ldt4));
        
        /* instance methods of DateTime class: "format" (with a formatter) returns the same as
        formatter (with a DateTime), that is, a string representing the DateTime according to the
        formatter; "get" (with the temporalField, representing a composition of TemporalUnits) to get
        a value of the TemporalField of the DateTime; "with" (with a TemporalAdjusters or 
        a TemporalField and a value amount) to return a modified DateTime;and "plus" or "minus"
        (with an amount value and a TemporalUnit) to increment or decrement the DateTime.*/
        System.out.println(ldt1.format(formatter));
        System.out.println(ldt1.get(ChronoField.ALIGNED_WEEK_OF_YEAR)+"th week of the year.");
        System.out.println(ldt1.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(ldt1.with(ChronoField.DAY_OF_MONTH, 1));
        System.out.println(ldt1.plus(1, ChronoUnit.YEARS));
        System.out.println(ldt1.minus(2, ChronoUnit.HOURS));
        
        /* To get an instance of Period it can be used static factory methods as between (two dates),
        "from" (another date-based or a time-based TemporalAmount - Period or Duration, e.g.),
        "parse" (from a String representation of a Period) or "of" (years, months, days and/or weeks).
        For Period Objects, the TemporalUnits years, months, days and weeks are considered separately
        and not coupled with one another. There are: the amount of years (Y), the amount of months (M),
        the amount of days (D) and the amount of weeks (W), all not interconvertable to eachother.*/
        Period period2 = Period.between(LocalDate.of(1982, Month.APRIL, 22), LocalDate.now());
        System.out.println("My age Period: "+period2.getYears()+" years "+period2.getMonths()+" months "+period2.getDays()+" days.");
        Period period3 = Period.from(period2);
        System.out.println(period3);
        Period period4 = Period.parse("P34Y2M13D");
        System.out.println(period4);
        Period period = Period.ofMonths(3);
        System.out.println(ldt1.minus(period));
        period = Period.of(1, 3, 4);
        System.out.println(ldt1.minus(period));
        
        /*instance methods of Period are similar to those from Date,
        most of them with only TemporalUnits or TemporalAmount parameters.*/
        System.out.println(period.get(ChronoUnit.MONTHS)+" month(s) Period.");
        System.out.println(period2.minus(Period.ofMonths(1)));
        System.out.println(period2.plus(Period.ofYears(10)));
        System.out.println(period.withYears(1).withMonths(1).withDays(1));
    }
}
