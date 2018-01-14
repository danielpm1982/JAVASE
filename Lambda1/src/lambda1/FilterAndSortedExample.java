/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda1;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class FilterAndSortedExample {
    
    public static void execute(){
        int[] intArray = {2,5,10,25,4,8};
        int[] intArray2 = IntStream.of(intArray)
                .filter(new IntPredicate() {
                    @Override
                    public boolean test(int value) {
                        return value%2==0;
                    }
                }
                .and(new IntPredicate() {
                    @Override
                    public boolean test(int value) {
                        return value>2;
                    }
                })
                )
                .toArray();
        System.out.print("[ ");
        IntStream.of(intArray2).sorted().forEach(x->System.out.print(x+" "));
        System.out.println("]");
        
        //or
        
        //intArray2 = IntStream.of(intArray).filter(x->x%2==0).filter(x->x>2).toArray();
        // or
        IntPredicate p1 = x->x%2==0;
        IntPredicate p2 = x->x>2;
        System.out.print("[ ");
        IntStream.of(intArray).filter(p1.and(p2)).sorted().forEach(x->System.out.print(x+" "));
        System.out.println("]");
        
    }
}
