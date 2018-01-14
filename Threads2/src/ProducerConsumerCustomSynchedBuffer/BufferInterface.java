package ProducerConsumerCustomSynchedBuffer;

public interface BufferInterface <T extends CharSequence>{
    public abstract void putAtBuffer(T s) throws InterruptedException;
    public abstract T getFromBuffer() throws InterruptedException;
}
