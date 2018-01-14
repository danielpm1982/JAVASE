package ProducerConsumerCustomSynchedBuffer;

import java.util.Arrays;
import java.util.List;

public class SynchedBuffer <T extends CharSequence> implements BufferInterface{
    List<CharSequence> list;
    boolean bufferEmpty;
    boolean bufferFull;
    public SynchedBuffer() {
        list = Arrays.asList(new CharSequence[1]);
        bufferEmpty=true;
        bufferFull=false;
    }

    @Override
    public synchronized void putAtBuffer(CharSequence s) throws InterruptedException {
        while(bufferFull){
            System.out.println("Buffer full! Waiting to put more data...");
            wait();
        }
        list.set(0,(T)s);
        System.out.println("PUT: "+s);
        bufferFull=true;
        System.out.println("Buffer not empty anymore! Notifying Consumer...");
        bufferEmpty=false;
        notifyAll();
    }

    @Override
    public synchronized CharSequence getFromBuffer() throws InterruptedException {
        while(bufferEmpty){
            System.out.println("Buffer empty! Waiting to read more data...");
            wait();
        }
        CharSequence s = list.get(0);
        System.out.println("GOT: "+s);
        list.set(0, null);
        bufferEmpty=true;
        System.out.println("Buffer not full anymore! Notifying Producer...");
        bufferFull=false;
        notifyAll();
        return s;
    }
}
