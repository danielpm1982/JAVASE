package com.danielpm1982.JAVASE;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySynchedThreadWriter {
	private BufferedWriter bufferedWriter;
	private String pathString;
	private Lock accessLock;
	private Condition canWrite;
	private Path path;
	public MySynchedThreadWriter(String pathString) {
		initiate(pathString);
	}
	private void initiate(String pathString){
		this.pathString = pathString;
		path = Paths.get(pathString);
		try {
			bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		accessLock = new ReentrantLock(true);
	}
	public void writeSynchedWithLock(String threadName, String message) {
		try {
			accessLock.lock();
			canWrite = accessLock.newCondition();
			while(bufferedWriter==null||!path.toFile().exists()) {
				System.out.println(threadName+" ------->>>>> set Thread to WAITING !");
				canWrite.await(2, TimeUnit.SECONDS);
				System.out.println(threadName+" ------->>>>> set Thread back to RUNNABLE and successfully got the locking for MyWriter instance again !");
			}
			System.out.println(this.getClass().getSimpleName()+": "+threadName+" thread writing text at path "+pathString+"...");
			bufferedWriter.write(message);
		} catch (IOException | InterruptedException | NullPointerException e) {
			System.err.println(e.getMessage());
		} finally {
			canWrite.signalAll();
			accessLock.unlock();
		}
	}
	public synchronized void writeSynchedWithSynchronized(String threadName, String message) {
		try {
			while(bufferedWriter==null||!path.toFile().exists()) {
				System.out.println(threadName+" ------->>>>> set Thread to WAITING !");
				wait(2000);
				System.out.println(threadName+" ------->>>>> set Thread back to RUNNABLE and successfully got the locking for MyWriter instance again !");
			}
			System.out.println(this.getClass().getSimpleName()+": "+threadName+" thread writing text at path "+pathString+"...");
			bufferedWriter.write(message);
		} catch (IOException | InterruptedException | NullPointerException e) {
			System.err.println(e.getMessage());
		} finally {
			notifyAll();
		}
	}
	public void close() {
		if(bufferedWriter!=null) {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

/*
This is a simple Writer class, with synchronized writing methods, thread-safe for Threads to call using their respectful functional interfaces.
The initiate method (called at the constructor) takes a local Path String to whose file a created BufferedWriter will write String messages
passed from the Main to the writer methods as arguments. If the file already exists, it is truncated (erased), otherwise it is created. If the
file is not accessible, a sleep waiting time of 2s is imposed on the current Thread using the writing, while it can try again to reach the file. 
There are two writing methods that share the same goal (writing messages to the file), which are the writeSynchedWithLock() and the 
writeSynchedWithSynchronized. The first uses Lock and Condition interface objects and methods, while the second uses the traditional Thread operations: 
synchronized, wait, notify(all).
Other than the initiate and two writing methods, it also has a closing method for the bufferredWriter, which should be called when all threads have
completed using the writing instance of this class to write to the desirable file.
The sharable mutable data here is the file content and the shared object is the writing object. All threads will compete to use a single or some
few instances of it to write to the one or multiple files (only one file to each writing is permitted). The writer is already thread-safe on its
own, regarding each write call. So, even if we were not using any explicit synching here, the writing messages would never end up scrambled amongst 
themselves, if a writer object was used by multiple alternating threads. The objective in using additional synching is to make the whole write 
method atomic, so that the "sout" messages right before each writing is synched only with that writing, and not with any other (from other threads).
The one Thread that gains the writer lock, locks the access to the others, until the whole writing method ends, or until the current Thread enters 
in the sleep waiting state or is interrupted.
I tried to find a way of mixing the string messages up, when not using additional synchronization, but couldn't find a Java IO or NIO standard object 
which wasn't already thread-safe on its own. Writer class and its other specific classes are all synchronized.
For making any of the two writing methods to wait, giving up the lock to the next available competing thread for 2s, and later trying to regain it,
just turn the bufferedWriter instance null for 1 second, then return the original instance to the variable. This can be done by calling the
method makeWriterUnavailableForOneSecond(). As we've only one writer instance here, which all threads compete for, when its value is temporarily
set to null, any other thread that gains the lock will also be suspended... until the writer original instance is restored and the threads can
then access and run the writing methods successfully again. 
*/
