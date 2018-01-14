/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortbigo;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class InsertionSortTest {
    public static void test(){
        SecureRandom random = new SecureRandom();
        int[] array = new int[50000];
        for (int i=0;i<array.length;i++){
            array[i]=random.nextInt(50);
        }
        System.out.println(Arrays.toString(array));
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        
        long timeInitial = System.nanoTime();
        InsertionSort.sort(array); //O(n^2)
        long timeFinal = System.nanoTime();
        long timeResult1 = timeFinal-timeInitial;
        System.out.println(Arrays.toString(array));
        System.out.println("Sorted in "+timeResult1+" nanoseconds using InsertionSort method.");
        System.out.println("");
        
        System.out.println(Arrays.toString(arrayCopy));
        timeInitial=System.nanoTime();
        Arrays.sort(arrayCopy); //O(nlogn)
        timeFinal=System.nanoTime();
        long timeResult2=timeFinal-timeInitial;
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Sorted in "+timeResult2+" nanoseconds using Arrays QuickSort method.");
        
        System.out.println("\nQuickSort took "+(float)timeResult2/timeResult1+" of InsertionSort time to sort the array.");
        System.out.println("");
    }
}
