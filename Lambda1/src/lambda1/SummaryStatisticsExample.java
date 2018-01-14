/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda1;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel
 */
public class SummaryStatisticsExample {
    public static void execute(){
        
        int[] intArray = {2,5,10,25,4,8};
        
        System.out.print("IntArray = {");
        IntStream.of(intArray).sorted().forEach(x->System.out.print(" "+x+" "));
        System.out.println("}");
        
        IntSummaryStatistics statistics = IntStream.of(intArray).summaryStatistics();
        System.out.println(statistics);
        
        long resultCount = IntStream.of(intArray).count();
        System.out.println("Count: "+resultCount);
        //or
        int resultCount2=IntStream.of(intArray).map(x->x=1).sum();
        System.out.println("Count: "+resultCount2);
        
        int resultMin = IntStream.of(intArray).min().orElse(-1);
        System.out.println("Min: "+resultMin);
        
        int resultMax = IntStream.of(intArray).max().getAsInt();
        System.out.println("Max: "+resultMax);
        
        double resultAverage = IntStream.of(intArray).average().getAsDouble();
        System.out.println("Average: "+resultAverage);
    }
}
