/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 * @param <T>
 */
public class GenericList <T extends Comparable<T>>{
    private List<T> list;

    public GenericList() {
    }
    public GenericList(T[] arrayGeneric) {
        list = createGenericList(arrayGeneric);
    }
    
    public List<T> createGenericList(T[] arrayGeneric){
        list = new ArrayList<>();
        for (T t:arrayGeneric){
            list.add(t);
        }
        return list;
    }

    public List<T> getList() {
        return list;
    }
}
