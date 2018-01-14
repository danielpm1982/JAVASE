/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads2;

/**
 *
 * @author Daniel
 */
public interface Buffer {
    public abstract void write(Integer i) throws InterruptedException;
    public abstract Integer read() throws InterruptedException;
}
