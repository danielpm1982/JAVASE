package javaapplication66;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaApplication66 {
    static int size;
    public static void main(String[] args) {
        int[] intArray = {1,2,3,4,5};
        size=intArray.length;
        showIntArray(intArray);System.out.println("");
        
        Integer[] integerArray1 = getIntegerArray1(intArray);
        showArray(integerArray1);System.out.println("");
        
        Integer[] integerArray2 = getIntegerArray2(intArray);
        showArray(integerArray2);System.out.println("");
        
        Integer[] integerArray3 = getIntegerArray3(intArray);
        showArray(integerArray3);System.out.println("");
        
        intArray = getIntArray(integerArray1);
        showIntArray(intArray);System.out.println("");
        
        System.out.println("\nTesting other Number array types:");
        showArray(new Double[]{1.0,2.0,3.0,4.0,5.0});System.out.println("");
        showArray(new BigDecimal[]{new BigDecimal(1.0),new BigDecimal(2.0),new BigDecimal(3.0),new BigDecimal(4.0),new BigDecimal(5.0)});System.out.println("");
        showArray(new Byte[]{1,2,3,4,5});System.out.println("");
    }
    //Three ways of transforming from int primitive array to Integer array using Streams
    public static Integer[] getIntegerArray1(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[size];
            }
        });
    }
    public static Integer[] getIntegerArray2(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(x->new Integer[size]);
    }
    public static Integer[] getIntegerArray3(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }
    //Transforming back from Integer array to primitive array
    public static int[] getIntArray(Integer[] integerArray){
        return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
    }
    public static <T extends Number> void showArray(T[] o){
        Stream.of(o).forEach(x->System.out.print(x.getClass().getName()+": "+x+" "));
    }
    public static void showIntArray(int[] intArray){
        System.out.print("Array primitivo int[]: ");
        IntStream.of(intArray).forEach(x->System.out.print(x+" "));
    }
}
