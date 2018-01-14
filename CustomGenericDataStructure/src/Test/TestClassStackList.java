/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GenericList.StackList;

/**
 *
 * @author Daniel
 */
public class TestClassStackList {
    public static void main(String[] args){
        StackList<String> stack = new StackList<>();
        stack.isEmpty();
        try {
            stack.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        stack.push("Bosco");
        stack.push("Tina");
        stack.push("Daniel");
        stack.push("Juliana");
        stack.print();
        while (!stack.isEmpty()){
            try {
                String s = stack.pop();
                System.out.println(s+" removed!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        stack.isEmpty();
        stack.print();
    }
}
