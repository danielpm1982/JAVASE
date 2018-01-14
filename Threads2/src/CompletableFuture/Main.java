package CompletableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->anyMethod());
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->anyMethod());
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->anyMethod());
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(()->anyMethodVoid());
        while(!future1.isDone()||!future2.isDone()||!future3.isDone()||!future4.isDone()){
            String s1 = !future1.isDone()?"future1 thread not done yet! ":"";
            String s2 = !future2.isDone()?"future2 thread not done yet! ":"";
            String s3 = !future3.isDone()?"future3 thread not done yet! ":"";
            String s4 = !future4.isDone()?"future4 thread not done yet! ":"";
            System.out.println("Main thread waiting more 0.5 second..."+s1+s2+s3+s4);
            Thread.sleep(500);
        }
        System.out.println("All threads DONE! CompletableFuture results:");
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println("ForkJoinPool.commonPool-worker-4: "+future4.get());
    }
    public static String anyMethod(){
        List<Integer> list = new ArrayList<>();
        System.out.println(Thread.currentThread().getName()+" initialized!");
        for (int i=0;i<=5000;i++){
            list.add(i);
            System.out.println(i+" ("+Thread.currentThread().getName()+")");
        }
        System.out.println("*****ENDED THREAD "+Thread.currentThread().getName()+"*****");
        return Thread.currentThread().getName()+": "+list.toString();
    }
    public static void anyMethodVoid(){
        System.out.println(Thread.currentThread().getName()+" initialized!");
        for (int i=0;i<=5000;i++){
            System.out.println(i+" ("+Thread.currentThread().getName()+")");
        }
        System.out.println("*****ENDED THREAD "+Thread.currentThread().getName()+"*****");
    }
}


/*
When using CompletableFuture, there's no need for using ExecutorService's threadPool or
ExecutorService's methods: execute, supply, invokeAll or invokeAny.
CompletableFuture's factory methods supplyAssync or runAssync are used instead.
These factory methods return a CompletableFuture object:
--> in the case of supplyAssync a CompletableFuture<T> object that can return a T object 
(through a get() method) as the result of the Supplier<T>'s supply() method
of this functional interface, and... 
--> in the case of runAssync a CompletableFuture<Void> object that can return void
(through a get() method) as the result of the Runnable<T>'s run() method
of this functional interface.
In both cases a lambda expression can be used instead of a Supplier or Runnable implemented
classe.
==> With ExecutorService, Runnables and Callables are used calling executor's instance methods execute() 
and supply() (or invokeAll/invokeAny). And, in the case of Callables, with a return type Future<T>.
==> With CompletableFuture, Runnables and Suppliers are used calling CompletableFuture's factory static methods 
runAssync and supplyAssync. And, in the case of BOTH, with a CompletableFuture return (and T or Void type-parameters).
The main difference is that CompletableFuture has its own thread-pool services and the creation of it, and of its threads,
is completely transparent.
*/
