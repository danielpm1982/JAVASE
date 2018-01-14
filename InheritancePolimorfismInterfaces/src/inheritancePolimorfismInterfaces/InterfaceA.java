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
public interface InterfaceA {
    public static Object staticMethod(int i){
        if(i==0){
            return new Object();
        } else{
            return Integer.valueOf(i);
        }
    }
    public default Object defaultMethod(int i){
        if(i==0){
            return new Object();
        } else{
            return Integer.valueOf(i);
        }
    }
    public abstract String abstractMethod();
}
