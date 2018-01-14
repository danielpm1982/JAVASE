package MutableAndImutableReferenceTypesMethodChangeAttempt;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public final class JavaApplication44{
    public static void main(String[] args) {
        String s = "Original!";
        JavaApplication44 j = new JavaApplication44();
        j.changeString(s);
        System.out.println("From outside: "+s);
        Integer i = 1;
        j.changeInteger(i);
        System.out.println("From outside: "+i);
        Integer i2 = 100000024;
        j.changeInteger(i2);
        System.out.println("From outside: "+i2);
        java.time.LocalDate date = LocalDate.of(2016, Month.JUNE, 28);
        j.changeDate(date);
        System.out.println("From outside: "+date);
        java.util.Date date2 = new Date(2016, 06, 28);
        j.changeDateUtil(date2);
        System.out.println("From outside: "+date2);
    }
    private void changeString(String s){
        s="Changed!"; //implicit reassignment, Strings are imutable!
        System.out.println("From inside: "+s);
    }
    private void changeInteger(Integer i){
        i++; //implicit reassignment, Integers are imutable!
        System.out.println("From inside: "+i);
    }
    private void changeDate(LocalDate d){
        d=d.plusDays(3); //explicity reassignment, LocalDates are imutable, and return different references to different Objects!
        System.out.println("From inside: "+d);
    }
    private void changeDateUtil(Date d){
        d.setDate(1); //no reassignments, java.Util.Dates are MUTABLE, and the d variable refers to the same object as the original copied reference variable!
        System.out.println("From inside: "+d);
    }
}

/*When reference types that refer to the same Objects make any change on them the change is kept for
any variable with that same Object reference. Implicit reassignments, although, may occur, so that the
changed value is not kept, but that's because the second variable reference was appointed by the
compiler to some Object else, specially in the case of Strings, Integers, or any immutable Objects. In
the case of immutable Objects that inclusive demands an explicit reassignment, as with LocalDate, that is 
quite obvious also. Only in Object references of whose Object states are mutable, either directly or by 
some utility method, and when there is no implicit or explicit  reassignment, the new values are kept 
at the external scope, as expected to reference types, on the contrary of primitive types, variables.*/

