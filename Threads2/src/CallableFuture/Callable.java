package CallableFuture;

import java.util.ArrayList;
import java.util.List;

public class Callable implements java.util.concurrent.Callable<String>{
    @Override
    public String call() throws Exception {
        List<Integer> list = new ArrayList<>();
        System.out.println(Thread.currentThread().getName()+" initialized!");
        for (int i=0;i<=5000;i++){
            list.add(i);
            System.out.println(i+" ("+Thread.currentThread().getName()+")");
        }
        System.out.println("*****ENDED THREAD "+Thread.currentThread().getName()+"*****");
        return Thread.currentThread().getName()+": "+list.toString();
    }
}
