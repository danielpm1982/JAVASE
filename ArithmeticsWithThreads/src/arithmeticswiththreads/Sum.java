package arithmeticswiththreads;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Sum implements Runnable{
    private final int[] intArray;
    private final int SUP_BOUND;
    private final String operationName;
    public Sum(String operationName, int supBound, int... intArray) {
        this.operationName=operationName;
        this.SUP_BOUND=supBound;
        this.intArray=intArray;
    }
    @Override
    public void run() {
        System.out.println(operationName+" Sum started!");
        System.out.println(operationName+" Old array: "+Arrays.toString(intArray));
        System.out.println(operationName+" Old total sum: "+IntStream.of(intArray).reduce(0, (a,b)->a+b));
        int[] valuesToSum = new SecureRandom().ints(0, SUP_BOUND).limit(intArray.length).toArray();
        System.out.println(operationName+" Values to sum: "+Arrays.toString(valuesToSum));
        System.out.println(operationName+" Summing...");
        IntStream.range(0, intArray.length).forEach(i->intArray[i]+=valuesToSum[i]);
        System.out.println(operationName+" Summing done!");
        System.out.println(operationName+" New array: "+Arrays.toString(intArray));
        int newTotalSum = IntStream.of(intArray).reduce(0, (a,b)->a+b);
        System.out.println(operationName+" New total sum: "+newTotalSum);
    }
}
