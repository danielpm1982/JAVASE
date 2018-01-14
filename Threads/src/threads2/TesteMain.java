/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Daniel
 */
public class TesteMain {
    
    public static void main(String[] args) {
        Buffer bufferUnSync = new UnsynchronizedBuffer();
        Buffer bufferSync = new SynchronizedBuffer();
        Buffer bufferSyncOverloaded = new SynchronizedBuffer(3);
        Buffer bufferSync2 = new SynchronizedBuffer2();
        Buffer bufferSync3 = new SynchronizedBuffer3();
        Buffer bufferSync4 = new SynchronizedBuffer4();
         
        Consumer consumerUnSync = new Consumer(bufferUnSync);
        Producer producerUnSync = new Producer(bufferUnSync);
        
        Consumer consumerSync = new Consumer(bufferSync);
        Producer producerSync = new Producer(bufferSync);
        
        Consumer consumerSyncOverloaded = new Consumer(bufferSyncOverloaded);
        Producer producerSyncOverloaded = new Producer(bufferSyncOverloaded);
        
        Consumer consumerSync2 = new Consumer(bufferSync2);
        Producer producerSync2 = new Producer(bufferSync2);
        
        Consumer consumerSync3_1 = new Consumer(bufferSync3);
        Consumer consumerSync3_2 = new Consumer(bufferSync3);
        Consumer consumerSync3_3 = new Consumer(bufferSync3);
        Producer producerSync3_1 = new Producer(bufferSync3);
        Producer producerSync3_2 = new Producer(bufferSync3);
        Producer producerSync3_3 = new Producer(bufferSync3);
        
        Consumer consumerSync4_1 = new Consumer(bufferSync4);
        Consumer consumerSync4_2 = new Consumer(bufferSync4);
        Consumer consumerSync4_3 = new Consumer(bufferSync4);
        Producer producerSync4_1 = new Producer(bufferSync4);
        Producer producerSync4_2 = new Producer(bufferSync4);
        Producer producerSync4_3 = new Producer(bufferSync4);
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        //UNCOMMENT ONE OF BELLOW SERVICE GROUPS BASED ON THE DIFFERENT BUFFERS ABOVE...
        
        //UnSynchronized Producer/Consumer Buffers (without synchronization).
//        executorService.execute(producerUnSync);
//        executorService.execute(consumerUnSync);
        
        //Synchronized Producer/Consumer Buffers (through thread safe inner java data structure - ArrayBlockingQueue).
//        executorService.execute(producerSync);
//        executorService.execute(consumerSync);
        
        //Synchronized Producer/Consumer Buffers Bounded Buffer (through thread safe inner java data structure - ArrayBlockingQueue, with overloaded Buffer constructor to define the number of buffer elements or data spaces).
//        executorService.execute(producerSyncOverloaded);
//        executorService.execute(consumerSyncOverloaded);
        
        //Synchronized2 Producer/Consumer Buffers (through synchronized, wait, notify and notifyAll).
//        executorService.execute(producerSync2);
//        executorService.execute(consumerSync2);
        
        //Synchronized3 Producer/Consumer Buffers (through Lock and Condition interfaces; and multiple Producer and Consumer threads).
        // in the case of this example, all 10 numbers will be written and read, but, if used more than one Consumer, there is no control over which data each one will read, or if any of them will read in order the 10 numbers. Some might read number values more than one time (distinctly written numbers, not the same!) and some might not read some values at all, if the other consumers have firstly read them. There would have to be a kind of indexing in the array ou map to associate produced numbers with particular threads, so that each thread would read only the number associated with it, like as a user acessing a map through its login or key.
        // if used only 1 Producer and 1 Consumer it will work properly as with the other Synced Buffers above.
        // time of execution, in this case, was basically the same regardless of using fairness policy true or false at the ReentrantLock constructor. It might need lots of threads to this policy be of any use, like in a client-server system.
//        executorService.execute(producerSync3_1);
//        executorService.execute(producerSync3_2);
//        executorService.execute(producerSync3_3);
//        executorService.execute(consumerSync3_1);
//        executorService.execute(consumerSync3_2);
//        executorService.execute(consumerSync3_3);
        
        //Synchronized4 Producer/Consumer Buffers (through concurrent Collection LinkedBlockingQueue).
        executorService.execute(producerSync4_1);
        executorService.execute(producerSync4_2);
        executorService.execute(producerSync4_3);
        executorService.execute(consumerSync4_1);
        executorService.execute(consumerSync4_2);
        executorService.execute(consumerSync4_3);
        
        System.out.println("\n\nShutting down Main Thread");
        executorService.shutdown();
        
        System.out.println("Waiting 1 min...");
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            //no re-thrown or re-interrupt needed at Main final.
        }
        
        System.out.println("Main terminated. Possible threads still running...");
        
        /*PS.: While synchronization is successfully obtained through the use of a thread safe inner data structure 
        (ArrayBlockingQueue) at the Runnable buffer run by each thread, which guarantees a correct write/reading 
        sequence, the System.out.prints of Producer/Consumer may not alternate perfectly as expected, showing two 
        followed Producer's writings and after two Consumer's respective readings, for instance, but it is safe 
        that the value sequence produced and consumed is correct and is in the expected order regarding the writing and 
        reading inside the thread safe data structure inside the Buffer. This is because the System.out.print is
        not an atomic task together with the data defacto reading or writing inside the structure. System.out.print
        is external to the data structure inner synchronization. The thread lock blocking is only implemented inside
        the ArrayBlockingQueue, and not extended to the System.out.print outside it. Other kinds of explicit synchronization 
        that involved both the data structure inside and the System.out.print outside might be necessary to show exactly 
        the alternating order for printing the producing/consuming data managed by the inner buffer structure. 
        Even if we synchonized the statement of write() or read() at the Buffer with the System.out.print inside,
        there would still be delays os printing because print and the inner classes reading and writing would not be
        synchronized, only the writing and reading at the structure itself, at the lower level. Printing would be at
        a higher level which might bring out the delay at printing, but not at writing and reading themselves.
        
        Syncing the producing writing and consuming reading inside the thread safe data structure garantees that
        neither the consumer would consume garbage from an empty buffer or make reading of the same data, in both cases
        by an eventual delay of the producing writer e.g., nor would the producing writer advances the reading task in 
        writing two or more sequential data at the buffer, what would cause all previous not read data to be lost by the 
        consumer reader when it does read at a next time (considering for example a one length space buffer as above).
        
        For approximate speed Producer and Consumer threads, and for smoothing temporary variations of their executing 
        speeds, use a BOUNDED BUFFER, with custom or JAVA inner synchronized data structures. The buffer, thus, would 
        have more than 1 element (or space cell) to accommodate such fine variations and optimize performance, avoinding
        either thread becoming idle.
        */
    }
}
