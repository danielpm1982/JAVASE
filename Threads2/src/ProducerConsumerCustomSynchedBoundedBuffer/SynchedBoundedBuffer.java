package ProducerConsumerCustomSynchedBoundedBuffer;

import java.util.Arrays;
import java.util.List;

public class SynchedBoundedBuffer <T extends CharSequence> implements BufferInterface{
    List<CharSequence> list;
    int capacity;
    boolean bufferEmpty;
    boolean bufferFull;
    int writeIndex;
    int readIndex;
    int occupiedCells;
    
    public SynchedBoundedBuffer(int capacity) {
        list = Arrays.asList(new CharSequence[capacity]);
        this.capacity=capacity;
        bufferEmpty=true;
        bufferFull=false;
        writeIndex=0;
        readIndex=0;
        occupiedCells=0;    
    }

    @Override
    public synchronized void putAtBuffer(CharSequence s) throws InterruptedException {
        while(bufferFull){
            System.out.println("Buffer full! Waiting to put more data...");
            wait();
        }
        list.set(writeIndex,(T)s);
        System.out.println("PUT: "+s);
        writeIndex=(writeIndex+1)%capacity;
        occupiedCells++;
        if(occupiedCells==capacity){
            bufferFull=true;
        }
        if(occupiedCells==1){
            System.out.println("Buffer not empty anymore! Notifying Consumer...");
            bufferEmpty=false;
        }
        notifyAll();
    }

    @Override
    public synchronized CharSequence getFromBuffer() throws InterruptedException {
        while(bufferEmpty){
            System.out.println("Buffer empty! Waiting to read more data...");
            wait();
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
            System.out.println("Buffer not full anymore! Notifying Producer...");
            bufferFull=false;
        }
        notifyAll();
        return s;
    }
}
