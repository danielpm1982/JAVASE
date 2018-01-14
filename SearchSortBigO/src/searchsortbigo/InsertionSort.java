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
public class InsertionSort {
    private static int insertValue;
    private static int indexTemp;
    public static void sort(int[] array){
        for(int i=1;i<array.length;i++){
            insertValue=array[i];
            indexTemp=i;
            while(indexTemp>0&&array[indexTemp-1]>insertValue){
                array[indexTemp]=array[indexTemp-1];
                indexTemp--;
            }
            array[indexTemp]=insertValue;
        }
    }
}
