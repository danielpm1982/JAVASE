/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.math.BigInteger;

/**
 *
 * @author Daniel
 */
public class Fibonacci {
    private static final BigInteger TWO= new BigInteger("2");
    private static long recursiveCalls=0;
    private static long generalCalls=0;
    public static BigInteger calculateRecursively(BigInteger number){
        System.out.println("General cumulated calls: "+(++generalCalls));
        if (number.compareTo(BigInteger.ONE)==0||number.compareTo(BigInteger.ZERO)==0){
            return number;
        } else{
            System.out.println("Recursive cumulated calls: "+(++recursiveCalls));
            return calculateRecursively(number.subtract(BigInteger.ONE)).add(calculateRecursively(number.subtract(Fibonacci.TWO)));
        }
    }
}
