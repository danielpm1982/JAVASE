package ProducerConsumerSynchedArrayBlockingQueue;

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
        
        BufferInterface<CharSequence> bufferShared = new SynchedBuffer<>(1);
        //String text = "Producer       Consumer Design      pattern     is   a classic concurrency or       threading pattern which reduces coupling between Producer and Consumer by separating Identification of work with Execution of          Work. In producer consumer design pattern, a shared queue is used to control the flow, and this separation allows you to code producer and consumer separately. It also addresses the issue of different timing require to produce item or consuming item. By using producer consumer pattern, both Producer and Consumer Thread can work with different speed.";
        Path path = Paths.get("textProducerConsumer.txt");
        String text = ReadWriteNIO.readPath(path).toString();
        System.out.println("Original file text: "+text);
        ProducerRunnable producer = new ProducerRunnable(bufferShared,text);
        ConsumerRunnable consumer = new ConsumerRunnable(bufferShared);
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("Starting Producer");
        executor.execute(producer);
        System.out.println("Starting Consumer");
        executor.execute(consumer);
        System.out.println("Shutting down Main thread");
        executor.shutdown();
        Thread.sleep(6000);
        executor.shutdownNow();
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
Using one same data structure as a buffer and passing it through Constructors to
Runnable Producers and Consumers who will be run by different simultaneous threads
created through ExecutorServices threads pool. Differently from the other example
at the package "SynchronizedExample", there is no need for using synchronized at
any level, 'cause the custom shared data structure uses, internally, an in built
java data structure (ArrayBlockingQueue) that is already thread safe and synchronized,
not only regarding the lock for each current thread manipulating it, but also a
synching about the full and empty states of the buffer... so that the Producer thread
waits to produce if full and the Consumer thread waits to the buffer to have any element
to consume it. If the inner structure was not a synched one, a similar synching design 
should be applied, as in the other example, either at intermediate levels (involving the whole
inner data structure access or the whole outter data structure that uses it) or inside 
the inner data structure at its critical mutable methods or statements. And, in this example,
a buffer control regarding its states should also be implemented, if the inner data structure
didn't do it by default.
*/