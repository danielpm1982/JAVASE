package javaapplication48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        
        //with lambda expressions substituting Predicate Interface expressions
//        List<String> result1 = doSomething(new String[]{"Cat","Dog","bear","lion"}, t->t.startsWith((t.toUpperCase()).substring(0, 1)));
        List<String> result1 = doSomething(new String[]{"Cat","Dog","bear","lion"}, (String t)->{return t.startsWith((t.toUpperCase()).substring(0, 1));});
        
        //anonymous classes expressions that implement Predicate Interface expressions
        List<String> result2 = doSomething(new String[]{"Cat","Dog","bear","lion"}, new Predicate<String>() {
            @Override
            public boolean test(String t) {
                return t.startsWith((t.toUpperCase()).substring(0, 1));
            }
        });
        
        //with local class expressions substituting Predicate Interface expressions
        class PredicateImpLocal implements Predicate<String>{
            @Override
            public boolean test(String t) {
                return t.startsWith((t.toUpperCase()).substring(0, 1));
            }
        }
        List<String> result3 = doSomething(new String[]{"Cat","Dog","bear","lion"}, new PredicateImpLocal());
        
        //with static nested class expressions substituting Predicate Interface expressions
        List<String> result4 = doSomething(new String[]{"Cat","Dog","bear","lion"}, new PredicateImpNested());
        
        //with instance expressions of external classes substituting Predicate Interface expressions
        List<String> result5 = doSomething(new String[]{"Cat","Dog","bear","lion"}, new PredicateImpExt());
        
        //with Streams and lambda expressions substituting Predicate Interface expressions
        List<String> result6 = Arrays.stream(new String[]{"Cat","Dog","bear","lion"}).filter(t->t.startsWith((t.toUpperCase()).substring(0, 1))).collect(Collectors.toList());
        
        //Results:
        System.out.println("Using Predicate Interface with different implementation approaches (see code documentation for description):");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
    // for Streams, the "doSomething" method would be the filter intermediate operation, totally encapsulated within the API.
    private static List<String> doSomething(String[] array,Predicate<String> p){
        List<String> l = new ArrayList<>();
        for (String t:array){
            if(p.test(t)){
                l.add(t);
            }
        }
        return l;
    }
    private static class PredicateImpNested implements Predicate<String>{
        @Override
        public boolean test(String t) {
            return t.startsWith((t.toUpperCase()).substring(0, 1));
        }
    }
}


//PS.: there is no inner class (a non-static nested class) in the example.

