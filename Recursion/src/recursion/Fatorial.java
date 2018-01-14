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
public class Fatorial {
    
    public static BigInteger calculateIteratively(BigInteger number) throws Exception{
        if(number.compareTo(BigInteger.ZERO)<0)
            throw new Exception("Number must be a non-negative Integer!!!");
        BigInteger result=BigInteger.ONE;
        for (BigInteger i=number;i.compareTo(BigInteger.ONE)>=0;i=i.subtract(BigInteger.ONE)){
            result=result.multiply(i);
        }
        return result;
    }
    
    public static BigInteger calculateRecursively(BigInteger number) throws Exception{
        if(number.compareTo(BigInteger.ZERO)<0)
            throw new Exception("Number must be a non-negative Integer!!!");
        if(number.compareTo(BigInteger.ONE)<=0){
            return BigInteger.ONE;
        }
        return number.multiply(calculateRecursively(number.subtract(BigInteger.ONE)));
    }
}
