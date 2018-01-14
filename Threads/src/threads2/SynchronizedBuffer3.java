/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Daniel
 */
public class SynchronizedBuffer3 implements Buffer{
    
    private final int[] sharedLocation;
    private int cellsOccupied;
    private int writeIndex;
    private int readIndex;
    Lock lock;
    Condition writeCondition;
    Condition readCondition;
    public SynchronizedBuffer3() {
        sharedLocation=new int[3];
        readIndex=0;
        writeIndex=0;
        cellsOccupied=0;
        lock=new ReentrantLock(true);
        writeCondition=lock.newCondition();
        readCondition=lock.newCondition();
    }
    
    @Override
    public void write(Integer i) throws InterruptedException {
        lock.lock();
        try{
            while(cellsOccupied==sharedLocation.length){
                writeCondition.await();
                
            }
            sharedLocation[writeIndex]=i;
            writeIndex=(writeIndex+1)%sharedLocation.length;
            cellsOccupied++;
            readCondition.signalAll();
        } finally{
            lock.unlock();
        }
    }
    
    @Override
    public Integer read() throws InterruptedException {
        int temp=-1;
        lock.lock();
        try{
            while(cellsOccupied==0){
                readCondition.await();
            }
            temp = sharedLocation[readIndex];
            readIndex=(readIndex+1)%sharedLocation.length;
            cellsOccupied--;
            writeCondition.signalAll();
        } finally{
            lock.unlock();
        }
        return temp;
    }
}


/*
Producer/Consumer Multithreading without synchronized, wait, notify, notifyAll of Monitor Lock... but with ReentrantLock and Condition objects:

1 - lock doens't have to be obtained and realeased in the same block of statement;

2 - lock is not the monitor lock, it's a special one that can be manipulated oriented to multiple Condition object-typed queues, either when method notify or notifyAll is called for THAT condition-type thread queue (the threads waiting on THAT condition) or when method await is also called on THAT type of Condition, which puts the thread on an exclusive queue of THAT type. You put on waiting or put on runnable state only threads related to that Condition type, and not every thread assigned to run that class as when synchronized is used;

3 - thread may be put on a timeWaiting, not only a waiting, for one particular Condition;

4 - threads state can be changed from waiting (or timeWaiting) to interrupted - interruptable waits (by Thread.interrupt()), or the waiting() method of the Condition may be set as uninterruptibly, in which case it will be set only after waiting the time or has been notified, and not as soon as the Thread.interrupt() tries to interrupt it;

5 - unlock is not automatically called at the end of the statement, as with synchronized. Must call unlock for that Lock object.

Neither of these characteristics exist when synchronized monitor lock is used.
*/

