/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import GenericList.QueueList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class TestClassQueueList {
    public static void main(String[] args) {
        QueueList<Integer> queue = new QueueList<>();
        queue.isEmpty();
        try {
            queue.dequeue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        while (!queue.isEmpty()){
            try {
                Integer i = queue.dequeue();
                System.out.println(i+" removed!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        queue.isEmpty();
    }
}
