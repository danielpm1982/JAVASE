/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda1;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class ReduceExample {
    
    public static void execute(){
        
        int[] intArray = {2,5,10,25,4,8};
        
        int result = IntStream.of(intArray).reduce(0, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left+right;
            }
        });
        System.out.println("Result: "+result);
        
        result = IntStream.of(intArray).reduce(0,(x,y)->{return x+y;});
        //or        
        //result = IntStream.of(intArray).reduce(0,(x,y)->x+y);
        System.out.println("Result: "+result);
        
        result = IntStream.of(intArray).sum();
        System.out.println("Result: "+result);
        
        result = IntStream.of(intArray).reduce(4, (x,y)->(int)Math.subtractExact(x, y));
        System.out.println("Result: "+result);
        
        result = IntStream.of(intArray).reduce(1, (x,y)->x*y);
        System.out.println("Result: "+result);
    }
}
