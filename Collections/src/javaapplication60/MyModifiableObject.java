/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication60;

/**
 *
 * @author Daniel
 */
public class MyModifiableObject {
    private String field;

    public MyModifiableObject(String s) {
        field=s;
    }
    
    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return field;
    }
}
