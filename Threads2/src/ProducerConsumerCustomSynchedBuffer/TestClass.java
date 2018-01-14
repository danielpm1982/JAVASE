package ProducerConsumerCustomSynchedBuffer;

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
        BufferInterface<CharSequence> bufferShared = new SynchedBuffer<>();
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
        Thread.sleep(10000);
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