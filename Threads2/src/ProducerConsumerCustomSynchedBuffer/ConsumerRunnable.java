package ProducerConsumerCustomSynchedBuffer;

import java.util.ArrayList;
import java.util.List;

public class ConsumerRunnable implements Runnable{
    BufferInterface<CharSequence> buffer;
    List<String> text;
    public ConsumerRunnable(BufferInterface<CharSequence> buffer) {
        this.buffer=buffer;
        text = new ArrayList<>();
    }
    
    public <T extends CharSequence> void consumeBufferData(){
        try {
            do{
                String s = buffer.getFromBuffer().toString();
                text.add(s);
            } while (true);
        } catch (InterruptedException ex) {
            System.out.println("Consumer Thread Interrupted!");
            System.out.print("\" ");
            text.forEach(x-> System.out.print(x+" "));
            System.out.println("\"");
        }
    }

    @Override
    public void run() {
        consumeBufferData();
    }
    
}
