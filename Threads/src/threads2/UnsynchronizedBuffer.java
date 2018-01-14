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
public class UnsynchronizedBuffer implements Buffer{
    private int sharedLocation;

    public UnsynchronizedBuffer() {
        sharedLocation=-1;
    }

    @Override
    public void write(Integer i) throws InterruptedException {
        sharedLocation=i;
    }

    @Override
    public Integer read() throws InterruptedException {
        return sharedLocation;
    }
}
