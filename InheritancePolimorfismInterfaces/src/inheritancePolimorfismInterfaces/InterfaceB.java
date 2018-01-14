/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancePolimorfismInterfaces;

/**
 *
 * @author Daniel
 */
public interface InterfaceB extends InterfaceA{
    public default Object defaultMethod(int i){
        if(i==0){
            return new String("defaultMethod2");
        } else{
            return Integer.valueOf(i).toString();
        }
    }
}
