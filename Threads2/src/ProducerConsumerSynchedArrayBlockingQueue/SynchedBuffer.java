package ProducerConsumerSynchedArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class SynchedBuffer <T extends CharSequence> implements BufferInterface{
    ArrayBlockingQueue<T> abq;
    
    public SynchedBuffer(int size) {
        abq = new ArrayBlockingQueue<T>(size);
    }

    @Override
    public void putAtBuffer(CharSequence s) throws InterruptedException {
        abq.put((T)s);
    }

    @Override
    public CharSequence getFromBuffer() throws InterruptedException {
        return abq.take();
    }
}
