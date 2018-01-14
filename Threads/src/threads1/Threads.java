/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Daniel
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //example1(); //use of ExecutorService's method execute() on different Runnable objects that do not run() over Thread shared mutable object states (fields). No Synchronization needed.
        //example2(); //use of ExecutorService's method execute() on different Runnable objects that do run() over Thread shared mutable object states (fields). Synchronization needed.
        example3(); //use of ExecutorService's method execute() on different Runnable objects that do run() over Thread shared mutable object states (fields). Synchronization needed.
    }
    
    private static void example1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        RunnableExample r1 = new RunnableExample("Runnable1 Object");
        RunnableExample r2 = new RunnableExample("Runnable2 Object");
        RunnableExample r3 = new RunnableExample("Runnable3 Object");
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);
        executorService.shutdown();
        System.out.println("Doing other things at thread main: ");
        System.out.println("blahblahblahblahblahblah");
        System.out.println("blahblahblahblahblahblah".toUpperCase());
        System.out.println("blahblahblahblahblahblah");
        System.out.println("blahblahblahblahblahblah".toUpperCase());
//        try {
//            executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//            System.out.println("Main and all Threads terminated.");
//        }
        //System.out.println("Main and all Threads terminated.");
        System.out.println("Main terminated. Some threads may still be running...");
    }
    
    private static void example2(){
        System.out.println("Demanding ExecutorService to find threads to execute the created Runnables over NOT SYNC Calculations...");
        ExecutorService executorService = Executors.newCachedThreadPool();
        CalculateSumNOTSynchronized calaculatorNotSync=new CalculateSumNOTSynchronized();
        RunnableExample2 r1 = new RunnableExample2(calaculatorNotSync, 10, 10, "Expression1");
        RunnableExample2 r2 = new RunnableExample2(calaculatorNotSync, 30, 20, "Expression2");
        RunnableExample2 r3 = new RunnableExample2(calaculatorNotSync, 50, 30, "Expression3");
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //no re-interrupt needed as it is a Main and superior end-level thread. No eventual InterruptedException treatment above this thread level required.
        }
        System.out.println("Main finished, waiting up to 1 minute for threads to terminate...");
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            //no re-interrupt needed as it is a Main and superior end-level thread. No eventual InterruptedException treatment above this thread level required.
        }
        System.out.println("Main ends.");
    }
    
    private static void example3(){
        System.out.println("Demanding ExecutorService to find threads to execute the created Runnables over SYNC Calculations...");
        ExecutorService executorService = Executors.newCachedThreadPool();
        CalculateSumSynchronized calaculatorSync=new CalculateSumSynchronized();
        RunnableExample2 r1 = new RunnableExample2(calaculatorSync, 10, 10, "Expression1");
        RunnableExample2 r2 = new RunnableExample2(calaculatorSync, 30, 20, "Expression2");
        RunnableExample2 r3 = new RunnableExample2(calaculatorSync, 50, 30, "Expression3");
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            //no re-interrupt needed as it is a Main and superior end-level thread. No eventual InterruptedException treatment above this thread level required.
        }
        System.out.println("Main finished, waiting up to 1 minute for threads to terminate...");
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            //no re-interrupt needed as it is a Main and superior end-level thread. No eventual InterruptedException treatment above this thread level required.
        }
        System.out.println("Main ends.");
    }
}
