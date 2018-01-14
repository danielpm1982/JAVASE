package adapter2;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //getting an Iterator
        Iterator<String> iterator = getIterator();
        //adapting an Iterator interface to an Enumeration interface, through the IteratorEnumerationAdapter
        Enumeration<String> enumeration = new IteratorEnumerationAdapter<>(iterator);
        //testing the pseudo-Enumeration interface new object at some Client code
        displayEnumeration(enumeration); //
    }
    public static <T> void displayEnumeration(Enumeration<T> enumeration){
        while(enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+"\t");
        }
    }
    public static Iterator<String> getIterator(){
        String[] stringArray = new String[10];
        List list = Arrays.asList(stringArray).stream().map(x->getString()).collect(Collectors.toList());
        return list.iterator();
    }
    public static String getString(){
        return "Name"+RandomNumber.getNumber();
    }
}

/*
Only applying the Object Adapter Pattern to adapt an Iterator interface object to an Enumeration interface object,
which had to be used at some Client code that will never know the Enumeration object processed was, actually, an
incompatible Iterator one, or that any Adapter existed to viabilize the transformation of one interface into another.
*/
