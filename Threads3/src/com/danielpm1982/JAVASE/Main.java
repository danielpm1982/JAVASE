package com.danielpm1982.JAVASE;
import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Main {
	private static final String PATH_STRING="/home/daniel/eclipse-workspace/Threads3/src/com/danielpm1982/JAVASE/text.txt";
	private static final int NUMBER_OF_STREAM_ELEMENTS=100_000;
	private static final int INFERIOR_LIMIT_OF_STREAM=0;
	private static final int SUPERIOR_LIMIT_OF_STREAM=2_000_000_000;
	private static final int WAIT_TIME_TO_SHUTDOWN_IN_SECONDS=5;
	private static ExecutorService executorService;
	private static MySynchedThreadWriter mySynchedThreadWriter;
	private static long threadCreationId;
	public static void main(String[] args) {
		initiate();
		SecureRandomStreamGenerator.getSecureRandomIntStream(INFERIOR_LIMIT_OF_STREAM, SUPERIOR_LIMIT_OF_STREAM, NUMBER_OF_STREAM_ELEMENTS).forEach(x->{
			try {
				callRunnableWithExecutorService(createWriterRunnable(++threadCreationId+" - RunnableExecutorServiceThread_"+LocalTime.now(), "A - Number: "+x+" written by "+threadCreationId+" - RunnableExecutorServiceThread_"+LocalTime.now()+"\n"));
				callRunnableWithCompletableFuture(createWriterRunnable(++threadCreationId+" - RunnableCompletableFutureThread_"+LocalTime.now(), "B - Number: "+x+" written by "+threadCreationId+" - RunnableCompletableFutureThread_"+LocalTime.now()+"\n"));
				System.out.println(callCallableWithExecutorService(createWriterCallable(++threadCreationId+" - CallableExecutorServiceThread_"+LocalTime.now(), "C - Number: "+x+" written by "+threadCreationId+" - CallableExecutorServiceThread_"+LocalTime.now()+"\n")).get());
				System.out.println(callSupplierWithCompletableFuture(createWriterSupplier(++threadCreationId+" - SupplierCompletableFutureThread_"+LocalTime.now(), "D - Number: "+x+" written by "+threadCreationId+" - SupplierCompletableFutureThread_"+LocalTime.now()+"\n")).get());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		});
		terminate();
	}
	private static void initiate() {
		executorService = Executors.newCachedThreadPool();
		mySynchedThreadWriter = new MySynchedThreadWriter(PATH_STRING);
	}
	private static Runnable createWriterRunnable(String threadName, String message) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					mySynchedThreadWriter.writeSynchedWithSynchronized(threadName, message);
				} catch (Exception e) {
					System.err.println("Exception at Runnable call "+threadName+": "+message+": "+e.getMessage());
				}
			}
		};
	}
//	private static Runnable createWriterRunnableWithLambda(String threadName, String message) {
//		return ()-> 
//				{
//					try {
//						mySynchedThreadWriter.writeSynchedWithSynchronized(threadName, message);
//					} catch (Exception e) {
//						System.err.println("Exception at Runnable call "+threadName+": "+message+": "+e.getMessage());
//					}
//				};
//	}
	private static Callable<String> createWriterCallable(String threadName, String message) {
		return new Callable<String>() {
			@Override
			public String call() throws Exception {
				try {
					mySynchedThreadWriter.writeSynchedWithLock(threadName, message);
				} catch (Exception e) {
					System.err.println("Exception at Callable call "+threadName+": "+message+": "+e.getMessage());
				}
				return "Callable call threadName: "+threadName+" message: "+message+" successfully executed !";
			}
		};
	}
//	private static Callable<String> createWriterCallableWithLambda(String threadName, String message) {
//		return ()->
//				{
//					try {
//						mySynchedThreadWriter.writeSynchedWithLock(threadName, message);
//					} catch (Exception e) {
//						System.err.println("Exception at Callable call "+threadName+": "+message+": "+e.getMessage());
//					}
//					return "Callable call threadName: "+threadName+" message: "+message+" successfully executed !";
//				};
//	}
	private static Supplier<String> createWriterSupplier(String threadName, String message) {
		return new Supplier<String>() {
			@Override
			public String get() {
				try {
					mySynchedThreadWriter.writeSynchedWithLock(threadName, message);
				} catch (Exception e) {
					System.err.println("Exception at Supplier get call "+threadName+": "+message+": "+e.getMessage());
				}
				return "Supplier get call threadName: "+threadName+" message: "+message+" successfully executed !";
			}
		};
	}
//	private static Supplier<String> createWriterSupplierWithLambda(String threadName, String message) {
//		return ()->
//				{
//					try {
//						mySynchedThreadWriter.writeSynchedWithLock(threadName, message);
//					} catch (Exception e) {
//						System.err.println("Exception at Supplier get call "+threadName+": "+message+": "+e.getMessage());
//					}
//					return "Supplier get call threadName: "+threadName+" message: "+message+" successfully executed !";
//				};
//	}
	private static void callRunnableWithExecutorService(Runnable runnable) {
		executorService.execute(runnable);
	}
	private static CompletableFuture<Void> callRunnableWithCompletableFuture(Runnable runnable) {
		return CompletableFuture.runAsync(runnable).thenAccept(x->System.out.println("Runnable successfully executed !"));
	}
	private static Future<?> callCallableWithExecutorService(Callable<?> callable){
		return executorService.submit(callable);
	}
	private static CompletableFuture<?> callSupplierWithCompletableFuture(Supplier<?> supplier){
		CompletableFuture<?> completableFuture = CompletableFuture.supplyAsync(supplier);
		completableFuture.thenAccept(x->System.out.println("Supplier successfully executed !"));
		return completableFuture;
	}
	private static void terminate() {
		try {
			executorService.awaitTermination(WAIT_TIME_TO_SHUTDOWN_IN_SECONDS, TimeUnit.SECONDS);
			executorService.shutdown();
			System.out.println("ExecutorService terminating in 3s...");
			executorService.awaitTermination(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(executorService.shutdownNow().size()==0?"All threads completed!":"Not all threads terminated on their own and have been forced to do so!");
			System.out.println("Threads created/recycled: "+threadCreationId+".");
			mySynchedThreadWriter.close();
			System.out.println("Application terminated !");
		}
	}
}

/*
This class uses the custom SecureRandomStreamGenerator class to get a stream of ints.
For each int in the stream, it creates Runnables, Callables and Suppliers, which are called by an instance of ExecutorService and by static methods 
of CompletableFuture class.
At the calling of each Runnable, Callable and Supplier functional interface unique method, a threadName string and a printing message is sent to
the MySynchedThreadWriter unique instance and to its unique method, in order to, respectively, print the threadName at the console output and the 
printing message at the file.
While the application terminates, the created/recycled total number of threads used are displayed.
*/
