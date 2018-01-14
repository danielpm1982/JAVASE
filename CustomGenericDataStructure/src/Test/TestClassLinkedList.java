/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GenericList.LinkedListSingly;

/**
 *
 * @author Daniel
 */
public class TestClassLinkedList{

    public static void main(String[] args) {
        LinkedListSingly<String> linkedList = new LinkedListSingly<>("MyGenericLinkedList");
        System.out.println(linkedList.isEmpty() ? "Empty List" : "List NOT empty");
        try {
            String s = linkedList.removeFromFront();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{    
            linkedList.insertAtFront("Tina");
            linkedList.insertAtBack("Daniel");
            linkedList.insertAtFront("Bosco");
            linkedList.insertAtBack("Juliana");
            linkedList.print();
            String s = linkedList.removeFromBack();
            System.out.println(s+" removed from back of list!");
            linkedList.print();
            s=linkedList.removeFromFront();
            System.out.println(s+" removed from front of list!");
            linkedList.print();
            s = linkedList.removeFromBack();
            System.out.println(s+" removed from back of list!");
            linkedList.print();
            s=linkedList.removeFromFront();
            System.out.println(s+" removed from front of list!");
            linkedList.print();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
