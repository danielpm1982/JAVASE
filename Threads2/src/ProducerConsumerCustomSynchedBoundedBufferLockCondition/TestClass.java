package ProducerConsumerCustomSynchedBoundedBufferLockCondition;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {
    public static void main(String... args) throws InterruptedException{
//        BufferInterface<CharSequence> bufferShared = new SynchedBoundedBufferLockCondition<>(3);
        Path path = Paths.get("textProducerConsumer.txt");
        String text = ReadWriteNIO.readPath(path).toString();
        System.out.println("Original file text: "+text);
        
        Thread.sleep(1000);
        
//        ProducerRunnable producer1 = new ProducerRunnable(bufferShared,text);
//        ProducerRunnable producer2 = new ProducerRunnable(bufferShared,text);
//        ProducerRunnable producer3 = new ProducerRunnable(bufferShared,text);
//        
//        ConsumerRunnable consumer1 = new ConsumerRunnable(bufferShared);
//        ConsumerRunnable consumer2 = new ConsumerRunnable(bufferShared);
//        ConsumerRunnable consumer3 = new ConsumerRunnable(bufferShared);
        
        BufferInterface<CharSequence> bufferShared1 = new SynchedBoundedBufferLockCondition<>(3);
        BufferInterface<CharSequence> bufferShared2 = new SynchedBoundedBufferLockCondition<>(3);
        BufferInterface<CharSequence> bufferShared3 = new SynchedBoundedBufferLockCondition<>(3);
        
        ProducerRunnable producer1 = new ProducerRunnable(bufferShared1,text);
        ProducerRunnable producer2 = new ProducerRunnable(bufferShared2,text);
        ProducerRunnable producer3 = new ProducerRunnable(bufferShared3,text);
        
        ConsumerRunnable consumer1 = new ConsumerRunnable(bufferShared1);
        ConsumerRunnable consumer2 = new ConsumerRunnable(bufferShared2);
        ConsumerRunnable consumer3 = new ConsumerRunnable(bufferShared3);
        
        ExecutorService executor1 = Executors.newCachedThreadPool();
        ExecutorService executor2 = Executors.newCachedThreadPool();
        ExecutorService executor3 = Executors.newCachedThreadPool();
        
        System.out.println("Starting Producer1:");
        executor1.execute(producer1);
        
        System.out.println("Starting Producer2:");
        executor2.execute(producer2);
        
        System.out.println("Starting Producer3:");
        executor3.execute(producer3);
        
        System.out.println("Starting Consumer1");
        executor1.execute(consumer1);
        
        System.out.println("Starting Consumer2");
        executor2.execute(consumer2);
        
        System.out.println("Starting Consumer3");
        executor3.execute(consumer3);
        
        System.out.println("Shutting down Main thread");
        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
        Thread.sleep(10000);
        executor1.shutdownNow();
        Thread.sleep(1000);
        executor2.shutdownNow();
        Thread.sleep(1000);
        executor3.shutdownNow();
    }
}

class ReadWriteNIO{
    public static List<String> readPath(Path path){
        List<String> list = new ArrayList<>();
        if(Files.exists(path)){
            try (BufferedReader br = Files.newBufferedReader(path)){
                String temp=null;
                while((temp=br.readLine())!=null){
                    list.add(temp);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        return null;
    }
}

/*
As expected for this application, in which one single text file is used
as the source for multiple Producers and Consumers threads to writeAt/readFrom
a single mutable shared data buffer, the synching of this buffer would not produce
a logical final writting/reading for any of the threads, as no control over
each thread scheduling or context switch would be possible... as these are 
ExecutorService's thread pool responsability.
However, the managing of the Lock on the buffer Object for each thread at a time, 
the release of the Lock at the final of the writing/reading (or context change), 
and the buffer state synching in order to await for specific canRead or canWrite 
different conditions (and notifyAll on each of these) could be achieved and shown 
on the screen. 
In suitable examples, timed waits and interruptible waits, as well as the possibility
of unlocking the Lock for the buffer object at different parts (methods or classes)
could make a point in switching from tradicional synchonized statements/methods and 
Object wait and notify/notifyAll to Lock and Condition Interface Objects instead, as
done in this illogical example just for demontration purposes.
For this example to make any sense regarding the text itself, three different buffers
would have to be used, each of those shared amongst a Producer and Consumer 
tasks pair, but not by other pairs. And, for interrupting each Consumer pair
separately, for the final texts not to scramble within each other, also 3 different
ExecutorService objects (pools) would have to be used with different time delays between
their shutdownNow methods. The source text file would be the same.
*/
