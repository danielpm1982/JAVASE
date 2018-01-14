/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Daniel
 */
public class SynchronizedBuffer implements Buffer{
    ArrayBlockingQueue<Integer> sharedLocation;

    public SynchronizedBuffer() {
        sharedLocation=new ArrayBlockingQueue<>(1);
    }
    
    public SynchronizedBuffer(int i) {
        sharedLocation=new ArrayBlockingQueue<>(i);
    }

    @Override
    public void write(Integer i) throws InterruptedException {
        sharedLocation.put(i);
    }
    
    @Override
    public Integer read() throws InterruptedException {
        return sharedLocation.take();
    }
}
