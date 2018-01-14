package ProducerConsumerCustomSynchedBoundedBufferLockCondition;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchedBoundedBufferLockCondition <T extends CharSequence> implements BufferInterface{
    List<CharSequence> list;
    int capacity;
    boolean bufferEmpty;
    boolean bufferFull;
    int writeIndex;
    int readIndex;
    int occupiedCells;
    Lock lock;
    Condition canRead;
    Condition canWrite;
    
    public SynchedBoundedBufferLockCondition(int capacity) {
        list = Arrays.asList(new CharSequence[capacity]);
        this.capacity=capacity;
        bufferEmpty=true;
        bufferFull=false;
        writeIndex=0;
        readIndex=0;
        occupiedCells=0;
        lock = new ReentrantLock(true);
        canRead=lock.newCondition();
        canWrite=lock.newCondition();
    }

    @Override
    public void putAtBuffer(CharSequence s) throws InterruptedException {
        lock.lock();
        System.out.println("Thread "+Thread.currentThread().getName()+" got the Lock!");
        try{
            while(bufferFull){
                System.out.println("Buffer full! Waiting to put more data...");
                System.out.println("Thread "+Thread.currentThread().getName()+" lost the Lock! Runnable-->Waiting State!");
                canWrite.await();
                System.out.println("Thread "+Thread.currentThread().getName()+" got the Lock again! Waiting State-->Runnable!");
            }
            list.set(writeIndex,(T)s);
            System.out.println("PUT: "+s);
            writeIndex=(writeIndex+1)%capacity;
            occupiedCells++;
            if(occupiedCells==capacity){
                bufferFull=true;
            }
            if(occupiedCells==1){
                System.out.println("Buffer not empty anymore! Notifying Consumer waiting threads...");
                bufferEmpty=false;
            }
            canRead.signalAll();
        } finally{
            System.out.println("Thread "+Thread.currentThread().getName()+" lost the Lock! Writting concluded!");
            lock.unlock();
        }
    }

    @Override
    public CharSequence getFromBuffer() throws InterruptedException {
        lock.lock();
        System.out.println("Thread "+Thread.currentThread().getName()+" got the Lock!");
        try{
            while(bufferEmpty){
                System.out.println("Buffer empty! Waiting to read more data...");
                System.out.println("Thread "+Thread.currentThread().getName()+" lost the Lock! Runnable-->Waiting State!");
                canRead.await();
                System.out.println("Thread "+Thread.currentThread().getName()+" got the Lock again! Waiting State-->Runnable!");
            }
            CharSequence s = list.get(readIndex);
            System.out.println("GOT: "+s);
            list.set(readIndex, null);
            readIndex=(readIndex+1)%capacity;
            occupiedCells--;
            if (occupiedCells==0){
                bufferEmpty=true;
            }
            if(occupiedCells==(capacity-1)){
                System.out.println("Buffer not full anymore! Notifying Producer threads...");
                bufferFull=false;
            }
            canWrite.signalAll();
            return s;
        } finally{
            System.out.println("Thread "+Thread.currentThread().getName()+" lost the Lock! Reading concluded!");
            lock.unlock();
        }
    }
}
