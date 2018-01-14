/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortbigo;

/**
 *
 * @author Daniel
 */
public class BinarySearch {
    private static int low;
    private static int high;
    private static int middle;
    private static int result =-1;
    public static int findFirst(int[] array, int key){
        low=0;
        high=array.length-1;
        middle=(low+high+1)/2;
        do{
            if(key==array[middle]){
                result=middle;
                return result;
            } else if(key<array[middle]){
                high=middle-1;
            } else{
                low=middle+1;
            }
            middle=(low+high+1)/2;
        } while (low<=high&&result==-1);
        return result;
    }
}
