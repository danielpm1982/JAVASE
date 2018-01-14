/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GenericMethods {
    public static <T extends Comparable<T>> T[] sort(T[] arrayComparable){
        List<T> list = Arrays.asList(arrayComparable);
        Collections.sort(list);
        arrayComparable=list.toArray(arrayComparable);
        return arrayComparable;
    }
    
    public static <T extends Comparable<T>> List<T> sort(List<T> listComparable){
        Collections.sort(listComparable);
        return listComparable;
    }
}
