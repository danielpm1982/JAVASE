package SynchronizedIOServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedIOServices {
    
    public static void main(String[] args) {
        System.out.println("Main Thread started!");
        ExecutorService executor = Executors.newCachedThreadPool();
        Path path = Paths.get("sharedFile.txt");
        executor.execute(new serviceOne(path));
        executor.execute(new serviceTwo(path));
        executor.execute(new serviceThree(path));
        executor.shutdown();
        try {
            //System.out.println("Main thread ended! Waiting Services Threads to end.");
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
        }
        System.out.println("Main thread and ALL services ended!");
    }
}

class serviceOne implements Runnable{

    Path path;
    public serviceOne(Path path) {
        this.path=path;
    }
    
    @Override
    public void run() {
        System.out.println("ServiceOne Thread started!");
        synchronized(path){
            ReadWriteNIO.writePath(path,ReadWriteNIO.readPath(path),1);
        }
        System.out.println("ServiceOne Thread ended!");
    }
}

class serviceTwo implements Runnable{
    Path path;
    public serviceTwo(Path path) {
        this.path=path;
    }
    
    @Override
    public void run() {
        System.out.println("ServiceTwo Thread started!");
        synchronized(path){
            ReadWriteNIO.writePath(path,ReadWriteNIO.readPath(path),2);       
        }
        System.out.println("ServiceTwo Thread ended!");
    }
}

class serviceThree implements Runnable{
    Path path;

    public serviceThree(Path path) {
        this.path=path;
    }
    
    @Override
    public void run() {
        System.out.println("ServiceThree Thread started!");
        synchronized(path){
            ReadWriteNIO.writePath(path,ReadWriteNIO.readPath(path),3);       
        }
        System.out.println("ServiceThree Thread ended!");
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

    public static void writePath(Path path, List<String> list, int typeOfWriting){
        try (OutputStream ops = Files.newOutputStream(path); PrintWriter pw = new PrintWriter(ops)){
            if(Files.notExists(path)){
                Files.createFile(path);
            } else{
                if(list!=null){
                    list.stream().forEach(pw::println);
                    pw.println("");
                }
            }
            pw.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            switch(typeOfWriting){
                case 1:
                    pw.println("ServiceOne:");
                    for (int i=0;i<51;i++){
                        pw.print(i+" ");
                        Thread.sleep(300);
                    }
                    break;
                case 2:
                    pw.println("ServiceTwo:");
                    for (char c=33;c<127;c++){
                        pw.print(c+" ");
                        Thread.sleep(300);
                    }
                    break;
                case 3:
                    pw.println("ServiceThree:");
                    for (int i=80;i>=0;i--){
                        pw.print(i+" ");
                        Thread.sleep(300);
                    }
                    break;
                default:
                    pw.println("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex2){
            Thread.currentThread().interrupt();
        }
    }
}

/*
An example of mutual exclusion using synchronized access to the object Path,
considering each of the three threads access to one same path file. As file is
not a java data structure or a class, the sync is not done in the inner level of 
the shared data class, but at the intermediate level of the runnable task itself, 
using the object path as the object whose lock (and access) will be got exclusively
by each thread running each runnable service, one at a time.

Originally, the code had been designed to make each runnable service, run by each
thread, use a separate file (path), not a shared one, the prior of which is 
useful to demonstrate parallel processing of the three threads but not sync among 
them regarding access to and modification of one same mutable shared data structure.

For synching to be achieved, either the access to the structure (as the case above) 
or critical parts inside the structure (an "add" method inside a data list, e.g.)
must be synchronized. Inside the data structure itself, either a method or a statement
can be synched, in the case of the statement with synchronized(this). If the synching
is done at a medium level, at the runnable class itself, and not inside the
data structure class, the object synched is not "this", but the object of the data 
structure, like "path" as the reference for the file object in the example above.
The one thing that must be synched is not the runnable or the main class, but the
data structure... either at a medium level (at the access time) or at an inner level
inside the structure class itself. If a custom nonsynched modifieable data structure is 
used, the code should synch the critical methods of it inside the structure class, specially
if it is a complex data structure whose other possible methods could be shared without
synghronization needs... not affecting unnecessarily program overall performance. If the
sync is done at a medium level, at the runnable class, the access to the data structure
is entirely blocked and no method or field inside it can be accessed before the one current
thread liberates the lock to the others. Synching only the critical parts of the data structure
might avoid unecessary locking of the whole structure. In the case above its not possible as
the structure is a file and not a java data structure that could be partially and
programmatically synched from within.

In the case of synchronized data structures, the synching is already coded inside them
and no additional synching is needed, neither inside of them nor at an external level.
*/