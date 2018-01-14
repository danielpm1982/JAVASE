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
public class SelectionSort {
    public static void sort(int[] array){
        for (int i=0; i<array.length-1;i++){
            for (int j=i+1; j<array.length; j++){
                if(array[j]<array[i]){
                    int temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
}
