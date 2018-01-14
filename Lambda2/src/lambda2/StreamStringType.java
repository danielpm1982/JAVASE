/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class StreamStringType {
    public static void execute(){
        String[] stringValues = {"Daniel","Juliana","Tina","Bosco","luke","viludo","apollo"};
        StringBuilder[] stringBuilderValues = new StringBuilder[stringValues.length];
        for (int i=0; i<stringValues.length;i++){
            stringBuilderValues[i]=new StringBuilder(stringValues[i]);
        }
        
        System.out.print("[ ");
        for (String s:stringValues){
            System.out.print(s+" ");
        }
        System.out.println("]");
        
        //Arrays.stream(stringValues).filter(x->x.startsWith(x.substring(0, 1).toUpperCase())).sorted(String.CASE_INSENSITIVE_ORDER).map(String::toUpperCase).forEach(System.out::println);
        Predicate<String> startsWithUpperCase = x->x.startsWith(x.substring(0, 1).toUpperCase());
        Arrays.stream(stringValues).filter(startsWithUpperCase).sorted(String.CASE_INSENSITIVE_ORDER).map(String::toUpperCase).forEach(System.out::println);
        
        ComparatorStringBuilderIgnoreCase comparator = new ComparatorStringBuilderIgnoreCase();
        List<StringBuilder> list = Arrays.stream(stringBuilderValues).sorted(comparator.reversed()).map(x->x.replace(0, 1, x.substring(0, 1).toUpperCase())).collect(Collectors.toList());
        System.out.println(list);
        System.out.println("");
        
//        list = list.stream().sorted(comparator).map(x->x.replace(0,x.capacity(),x.toString().toUpperCase())).collect(Collectors.toList());
//        System.out.println(list);
        
        list.add(new StringBuilder("Daniel"));
        list.add(new StringBuilder("Tina"));
        list.add(new StringBuilder("Tina"));
        list.add(new StringBuilder("Bosco"));
        Function<StringBuilder,String> functionComparator = StringBuilder::toString;
        Function<StringBuilder,Integer> functionComparator2 = StringBuilder::hashCode;
        Comparator<StringBuilder> comparator2 = Comparator.comparing(functionComparator).thenComparing(functionComparator2);
        Map<String,List<StringBuilder>> map = list.stream().sorted(comparator2).map(x->x.replace(0,x.capacity(),x.toString().toUpperCase())).collect(Collectors.groupingBy(StringBuilder::toString));
        map.forEach((x,y)->{
            System.out.println(" Group "+x+" ");
            y.forEach(z->System.out.println("  ->"+z.toString()+"("+z.hashCode()+")"));
        });
    }
}
