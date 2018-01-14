/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortbigo;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class LinearSearchTest {
    public static void test(){    
        SecureRandom random = new SecureRandom();
        int[] array = new int[100];
        for(int i=0;i<array.length;i++){
            array[i] = random.nextInt(100);
        }
        Arrays.sort(array);
        System.out.print("Array: [ ");
        for (int i :array){
            System.out.print(i+" ");
        }
        System.out.println("]");
        Scanner s = new Scanner(System.in);
        System.out.println("Type an int value, from 0 to 99, to be search at the array:");
        int key = s.nextInt();

        long timeInitial = System.nanoTime();
        //find key int at array using LinearSearch findFirst(int key,int[] array) method
        int result = LinearSearch.findFirst(array,key); 
        long timeFinal = System.nanoTime();
        long resultTime1 = timeFinal-timeInitial;
        
        if (result==-1){
            System.out.println("Key value not found!");
        } else{
            System.out.println("Key "+key+" first found at index ["+result+"]");
        }
        System.out.println(resultTime1+" nanoseconds with Linear Search.");
        
        
        System.out.println("");
        timeInitial = System.nanoTime();
        result = Arrays.binarySearch(array,key);
        timeFinal = System.nanoTime();
        long resultTime2 = timeFinal-timeInitial;
        if (result<0){
            System.out.println("Key value not found!");
        } else{
            System.out.println("Key "+key+" first found at index ["+result+"]");
        }
        System.out.println(resultTime2+" nanoseconds with Binary Search.");
        
        System.out.println("\nBinary Search took "+((float)resultTime2/resultTime1)+" the time of Linear Search!");
    }
}
