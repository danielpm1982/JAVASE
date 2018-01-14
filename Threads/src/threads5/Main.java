/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads5;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Main {
    
    Future future1, future2, future3;
    
    public static void main(String[] args) {
        
        //Using CompletableFuture.supplyAsync() or runAsync() to pass Supplier or Runnable objects as arguments in order to return Future objects
        //Using ExecutorService.submit() to pass Callable objects as arguments in order to return Future objects
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        //passing a Supplier<BigInteger> object to CompletableFuture.supplyAsync() and receiving a Future<BigInteger> result
        Fibonacci1 fiboCalc1 = new Fibonacci1(new BigInteger("30"));
        Future<BigInteger> future1 = CompletableFuture.supplyAsync(fiboCalc1);        
        //Future<BigInteger> future1 = CompletableFuture.supplyAsync(()->fiboCalc1.get());        
        
        //passing a Callable<BigInteger> object to ExecutorService.submit() and receiving a Future<BigInteger> result
        Fibonacci2 fiboCalc2 = new Fibonacci2(new BigInteger("30"));
        Future<BigInteger> future2 = executor.submit(fiboCalc2);
        //Future<BigInteger> future2 = executor.submit(()->fiboCalc2.call());
        
        //passing a Runnable object to ExecutorService.submit() and receiving a Future<> reference without result
        // or passing a Runnable object to CompletableFuture.runAsync() and receiving a Future<> reference without result
        Fibonacci3 fiboCalc3 = new Fibonacci3(new BigInteger("30"));
        //Future future3 = executor.submit(fiboCalc3);
        //Future future3 = executor.submit(()->fiboCalc3.run());
        Future future3 = CompletableFuture.runAsync(fiboCalc3);
        //Future future3 = CompletableFuture.runAsync(()->fiboCalc3.run());
        
        //Parallel asynchronous multithreading safe execution of the future objects
        //without the need of creating thread safe synchronized mutable shared objects at FiboCalc classes.
        long long1=0;
        try {
            long1 = new CalculateTimeAsync(future1,future2,future3).calculateTimeAsync();
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("The 3 asynchronous tasks took "+long1+" ms.");
        
        //synchronous same tasks to compare performance
        long long2 = calculateTimeSync();
        System.out.println("The 3 synchronous tasks took "+long2+" ms.");
        
        double d = (double)(long1)/long2;
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        System.out.println("Async multithreadened tasks took "+numberFormat.format(d)+" of Sync tasks execution time.");
        
        executor.shutdown();
    }
    
    public static long calculateTimeSync(){
        Instant instant1 = Instant.now();
        Fibonacci1.calculateRecursively(new BigInteger("30"));
        Fibonacci2.calculateRecursively(new BigInteger("30"));
        Fibonacci3.calculateRecursively(new BigInteger("30"));
        Instant instant2 = Instant.now();
        long duration = Duration.between(instant1, instant2).toMillis();
        return duration;
    }
}
