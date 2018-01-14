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

/**
 *
 * @author Daniel
 */
public class Main {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long[] arrayLong1 = random.longs(5_000_000).toArray();
        long[] arrayLong2 = Arrays.copyOfRange(arrayLong1, 0, arrayLong1.length-1);
        
        Instant instant1 = Instant.now();
        Arrays.sort(arrayLong1);
        Instant instant2 = Instant.now();
        long duration1 = Duration.between(instant1, instant2).toMillis();
        
        Instant instant3 = Instant.now();
        Arrays.parallelSort(arrayLong2);
        Instant instant4 = Instant.now();
        long duration2 = Duration.between(instant3, instant4).toMillis();
        
        System.out.println("Time to sort: "+duration1+" ms");
        System.out.println("Time to parallelSort: "+duration2+" ms");
        System.out.println("parallelSort/sort(%): "+NumberFormat.getPercentInstance().format((double)duration2/duration1));
    }
}
