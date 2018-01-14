/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 *
 * @author Daniel
 */
public class Fibonacci2 implements Callable<BigInteger>{
    private static final BigInteger TWO = new BigInteger("2");
    private float progressFibo = 0;
    private final BigInteger number;
    private final List <BigInteger> intermediateResult;
    private BigInteger result;
    
    public Fibonacci2(BigInteger number) {
        this.number=number;
        intermediateResult=new ArrayList<>();
        if(number.compareTo(new BigInteger("0"))==0){
            intermediateResult.add(new BigInteger("0"));
        } else {
            intermediateResult.add(new BigInteger("0"));
            intermediateResult.add(new BigInteger("1"));
        }
    }
    
    public static BigInteger calculateRecursively(BigInteger number){
        if (number.compareTo(BigInteger.ONE)==0||number.compareTo(BigInteger.ZERO)==0){
            return number;
        } else{
            return calculateRecursively(number.subtract(BigInteger.ONE)).add(calculateRecursively(number.subtract(Fibonacci2.TWO)));
        }
    }
    
    public synchronized BigInteger calculateIterativelyInstance(){
        if(number.intValue()==0){
            return new BigInteger("0");
        }
        BigInteger i = new BigInteger("0");
        BigInteger j = new BigInteger("1");
        for (int k = 1; k < number.intValue(); k++)
        {	
              intermediateResult.add(i.add(j));
              i = j;
              j = intermediateResult.get(intermediateResult.size()-1);
              progressFibo=k/(number.intValue());
        }
        //progressFibo=1;
        return j;
    }
    
    @Override
    public BigInteger call() throws Exception {
        return calculateRecursively(number);
    }

    public synchronized int getProgress() {
        return (int)(progressFibo*100);
    }

    public synchronized BigInteger getResult() {
        return result;
    }

    public synchronized List<BigInteger> getIntermediateResult() {
        return intermediateResult;
    }
}
