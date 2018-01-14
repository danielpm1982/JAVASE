/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class StreamIntegerType {
    public static void execute(){
        int[] intArray = {1,5,13,2,43,54,0,65,99};
        Integer[] integerArray = {1,5,13,2,43,54,0,65,99};
        
        //using InstStream interface to get an intStream (primitive) stream (needs to map to Object stream before collect use)
        List<Integer> listInteger1 = IntStream.of(intArray).sorted().mapToObj(x->(Integer)x).collect(Collectors.toList());
        System.out.println(listInteger1);
        
        //using Stream<Integer> interface to get an IntegerStream (reference) stream (already an Object stream before collect use)
        List<Integer> listInteger2 = Arrays.stream(integerArray).sorted().collect(Collectors.toList());
        System.out.println(listInteger2);
        
        System.out.printf("listInteger1 %s content of listInteger2.%n", (listInteger1.equals(listInteger2)) ? "has the same" : "has not the same");
        System.out.printf("%s listInteger1's referenced object %s the same object referenced by listInteger2.%n", (listInteger1==listInteger2) ? "And" : "But", (listInteger1==listInteger2) ? "is" : "is not");
    }
}
