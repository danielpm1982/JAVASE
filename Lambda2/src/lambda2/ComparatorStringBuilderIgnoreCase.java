/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda2;

import java.util.Comparator;

/**
 *
 * @author Daniel
 */
public class ComparatorStringBuilderIgnoreCase implements Comparator<StringBuilder>{
    
    @Override
    public int compare(StringBuilder o1, StringBuilder o2) {
        if(o1.toString().compareToIgnoreCase(o2.toString())==0){
            return 0;
        } else if(o1.toString().compareToIgnoreCase(o2.toString())<0){
            return -1;
        } else{
            return 1;
        }
    }
}
