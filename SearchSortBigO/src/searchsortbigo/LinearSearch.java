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
public class LinearSearch {
    public static int findFirst(int[] array, int key){
        for(int i=0;i<array.length;i++){
            if (array[i]==key){
                return i;
            }
        }
        return -1;
    }
}
