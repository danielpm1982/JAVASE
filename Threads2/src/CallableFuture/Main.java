package CallableFuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable c1 = new Callable();
        Callable c2 = new Callable();
        Callable c3 = new Callable();
        List<Callable> listCallable = new ArrayList<>(Arrays.asList(c1,c2,c3));
        ExecutorService executor = Executors.newCachedThreadPool();
//        Future<String> future1 = executor.submit(c1);
//        Future<String> future2 = executor.submit(c2);
//        Future<String> future3 = executor.submit(c3);
        List<Future<String>> listFuture = executor.invokeAll(listCallable);
        String futureAny = executor.invokeAny(listCallable);
//        try {
//            System.out.println("Ended. Result: "+future1.get());
//            System.out.println("Ended. Result: "+future2.get());
//            System.out.println("Ended. Result: "+future3.get());
//        } catch (InterruptedException|ExecutionException ex) {
//            ex.printStackTrace();
//        }
//        System.out.println(future1.cancel(true)?"Future1 callable task Cancelled Successfully!":"Future1 callable task Cancelled Failed!");
//        System.out.println(future1.isCancelled()?"Future1 callable task was cancelled!":"Future1 callable task was NEVER cancelled!");
//        System.out.println(future1.isDone()?"Future1 callable task Is already Done!":"Future1 callable task Is NOT done!");
        Thread.sleep(1000);
        for (Future<String> f:listFuture){
            System.out.println("Invoke All Ended. Result: "+f.get());
        }
        System.out.println("Invoke Any Ended. Result: "+futureAny);
        executor.shutdownNow();
        System.out.println("Shutted down!!!!");
    }
}


/*
Callable tasks (call()) are tasks similar to Runnable tasks (run()) that can be passed 
to a Thread, in this example to a ExecutorService thread pool. The executor will execute the
Callable through methods submit(Callable<T> c), invokeAll(Collection<? extends Callable<T>> c) 
or invokeAny(Collection<? extends Callable<T>> c).
--> submit(Callable<T> c) returns a Future<T> object from which method get() it can be
got the result of the task call, other than other informations as if the task has been interrupted
or is done, or even interrupt it if in progress.
--> invokeAll(Collection<? extends Callable<T>> c) returns a List<Future<T>> that
can be iterated to get each Future returned when all tasks complete.
--> invokeAny(Collection<? extends Callable<T>> c) returns a T object which is the exact
return of any of the list's Callable object's task. The call that returns first is
returned and the remaining tasks are cancelled.
The advantage or Callable objects versus Runnable objects is the fact that the return
of the first can be used to get and manipulate its results whenever and how many times needed,
differently from the Runnable objects that do not have results and must do whatever needed
only until the run() method ends... and not at a higher class level or any moment later.
*/
