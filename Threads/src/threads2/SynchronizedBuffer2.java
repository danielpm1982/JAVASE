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
public class SynchronizedBuffer2 implements Buffer{
    
    private final int[] sharedLocation;
    private int cellsOcuppied;
    private int writeIndex;
    private int readIndex;
    public SynchronizedBuffer2() {
        sharedLocation=new int[3];
        readIndex=0;
        writeIndex=0;
        cellsOcuppied=0;
    }
    
    @Override
    public synchronized void write(Integer i) throws InterruptedException {
        while(cellsOcuppied==sharedLocation.length){
            wait();
        }
        sharedLocation[writeIndex]=i;
        writeIndex=(writeIndex+1)%sharedLocation.length;
        cellsOcuppied++;
        notifyAll();
    }
    
    @Override
    public synchronized Integer read() throws InterruptedException {
        while(cellsOcuppied==0){
            wait();
        }
        int temp = sharedLocation[readIndex];
        readIndex=(readIndex+1)%sharedLocation.length;
        cellsOcuppied--;
        notifyAll();
        return temp;
    }
    
}
