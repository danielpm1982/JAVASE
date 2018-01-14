/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

import java.security.SecureRandom;

/**
 *
 * @author Daniel
 */
public class Producer implements Runnable{
    private final Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer=buffer;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<=10; i++){
                Thread.sleep(new SecureRandom().nextInt(3000));
                buffer.write(i);
                System.out.println("Thread name: "+Thread.currentThread().getName()+" - Producer written Integer "+i);
            }
            System.out.println("Thread name: "+Thread.currentThread().getName()+" - Producer ends writing...");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
