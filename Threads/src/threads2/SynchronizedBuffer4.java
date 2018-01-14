/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Daniel
 */
public class SynchronizedBuffer4 implements Buffer{
    
    private final LinkedBlockingQueue <Integer> sharedLocation;
    Lock lock;
    Condition writeCondition;
    Condition readCondition;
    public SynchronizedBuffer4() {
        sharedLocation=new LinkedBlockingQueue(3);
        lock=new ReentrantLock(true);
        writeCondition=lock.newCondition();
        readCondition=lock.newCondition();
    }
    
    @Override
    public void write(Integer i) throws InterruptedException {
//        lock.lock();
//        try{
//            while(sharedLocation.remainingCapacity()==0){
//                writeCondition.await();
//            }
//            sharedLocation.put(i);
//            readCondition.signalAll();
//        } finally{
//            lock.unlock();
//        }
        
        sharedLocation.put(i);
    }
    
    @Override
    public Integer read() throws InterruptedException {
        int temp=-1;
//        lock.lock();
//        try{
//            while(sharedLocation.size()==0){
//                readCondition.await();
//            }
//            temp = sharedLocation.take();
//            writeCondition.signalAll();
//        } finally{
//            lock.unlock();
//        }
//        return temp;
        
        return sharedLocation.take();
    }
}


//no need to use Lock or Condition as this Collection is thread safe regarding mutual exclusion as well
//as blocking the writing or reading when full or empty respectively. Exactly the same functions of Lock and 
//Condition when used as above. BUT this depends on the methods used. For blocking to occur, the methods
//put() and take() must be the ones. Other methods add or remove elements but with fewer features, not blocking, 
//for example.

