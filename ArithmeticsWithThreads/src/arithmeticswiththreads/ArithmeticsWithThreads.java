package arithmeticswiththreads;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class ArithmeticsWithThreads{
    private static final int SUP_BOUND=100;
    public static void main(String[] args) {
        int[] intMutableArray = new SecureRandom().ints(0, SUP_BOUND).limit(1).toArray();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Sum("operation1", SUP_BOUND, intMutableArray));
        executorService.execute(new Sum("operation2", SUP_BOUND, intMutableArray));
        executorService.execute(new Sum("operation3", SUP_BOUND, intMutableArray));
        executorService.execute(new Sum("operation4", SUP_BOUND, intMutableArray));
        executorService.execute(new Sum("operation5", SUP_BOUND, intMutableArray));
        executorService.shutdown();
        System.out.println("Main thread finished... waiting other threads to complete...");
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Main thread and all other threads have completed!");
        System.out.println("Final mutable array:\n"+Arrays.toString(intMutableArray));
    }
}
