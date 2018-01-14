/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads1;

import java.security.SecureRandom;

/**
 *
 * @author Daniel
 */
public class RunnableExample implements Runnable {
    String nameThread;
    int sleepTime;
    SecureRandom ramdom;
    public RunnableExample(String nameThread) {
        this.nameThread=nameThread;
        ramdom= new SecureRandom();
        sleepTime = ramdom.nextInt(20000);
    }

    @Override
    public void run() {
        System.out.println(nameThread+" starts executing. And is put to sleep for "+sleepTime+" miliseconds...");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("Sleeping of thread "+nameThread+" interrupted. Thread terminates.");
    }
    
}
