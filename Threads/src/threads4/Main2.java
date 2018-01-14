/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads4;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LongSummaryStatistics;

/**
 *
 * @author Daniel
 */
public class Main2 {
    public static void main(String[] args) {
        
        SecureRandom random = new SecureRandom();
        long[] longArray = random.longs(10_000_000,1,1001).toArray();
        
        Instant instant1 = Instant.now();
        long longCount = Arrays.stream(longArray).count();
        long longSum = Arrays.stream(longArray).sum();
        long longMin = Arrays.stream(longArray).min().getAsLong();
        long longMax = Arrays.stream(longArray).max().getAsLong();
        double longAverage = Arrays.stream(longArray).average().getAsDouble();
        Instant instant2 = Instant.now();
        long duration1 = Duration.between(instant1, instant2).toMillis();
        System.out.println("Individual calculations over long stream from longArray: "+duration1+" ms");
        
        Instant instant3 = Instant.now();
        LongSummaryStatistics statistics1 = Arrays.stream(longArray).summaryStatistics();
        Instant instant4 = Instant.now();
        long duration2 = Duration.between(instant3, instant4).toMillis();
        System.out.println(statistics1.toString());
        System.out.println("LongSummaryStatistics over long sequential stream from longArray: "+duration2+" ms");
        
        Instant instant5 = Instant.now();
        LongSummaryStatistics statistics2 = Arrays.stream(longArray).parallel().summaryStatistics();
        Instant instant6 = Instant.now();
        long duration3 = Duration.between(instant5, instant6).toMillis();
        System.out.println(statistics2.toString());
        System.out.println("LongSummaryStatistics over long parallel stream from longArray: "+duration3+" ms");
        
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        System.out.println("SummaryStatistics method of parallel streams takes only "+numberFormat.format((double)duration3/duration2)+" of the time of the same method with sequential streams");
        System.out.println("SummaryStatistics method of parallel streams takes only "+numberFormat.format((double)duration3/duration1)+" of the time of the individual calcule of each summaryStatistics claculation");
    }
}
