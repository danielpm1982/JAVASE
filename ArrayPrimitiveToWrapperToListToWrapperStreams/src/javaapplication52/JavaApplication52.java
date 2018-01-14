package javaapplication52;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaApplication52 {
    
    public static void main(String[] args) {
        //primitive int array
        int[] arrayInt = {1,2,3,4,5};
        IntStream.of(arrayInt).forEach(System.out::print);
        System.out.println("");
        //boxed to Wrap Integer array
        Integer[] arrayInteger = IntStream.of(arrayInt).boxed().toArray(Integer[]::new);
        //Integer[] arrayInteger = IntStream.of(arrayInt).boxed().toArray(value -> new Integer[arrayInt.length]);
//        Integer[] arrayInteger = IntStream.of(arrayInt).boxed().toArray(new IntFunction<Integer[]>() {
//            @Override
//            public Integer[] apply(int value) {
//                return new Integer[5];
//            }
//        });
        //converted to Integer immutable list
        List<Integer> l = Arrays.asList(arrayInteger);
        l.forEach(System.out::print);
        System.out.println("");
        //converted again to Integer array
        Integer[] i = l.toArray(new Integer[0]);
        Stream.of(i).forEach(System.out::print);
        System.out.println("");
    }
}
