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
public class CalculateSumSynchronized {
    private int i;
    private int j;
    private int result;
    
    public synchronized int sum(int i, int j){
        try {
            Thread.sleep(new SecureRandom().nextInt(5000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        this.i=i;
        this.j=j;
        try {
            Thread.sleep(new SecureRandom().nextInt(5000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        result=this.i+this.j;
        try {
            Thread.sleep(new SecureRandom().nextInt(5000));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return result;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
}
