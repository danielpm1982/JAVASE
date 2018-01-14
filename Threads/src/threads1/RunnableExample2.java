/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads1;

/**
 *
 * @author Daniel
 */
public class RunnableExample2 implements Runnable {
    private CalculateSumNOTSynchronized calculatorNotSync=null;
    private CalculateSumSynchronized calculatorSync=null;
    private final int i; 
    private final int j;
    private final String expressionNumber;
    
    public RunnableExample2(CalculateSumNOTSynchronized calculatorNotSync, int i, int j, String expressionNumber) {
        this.calculatorNotSync=calculatorNotSync;
        this.i=i;
        this.j=j;
        this.expressionNumber=expressionNumber;
    }
    
    public RunnableExample2(CalculateSumSynchronized calculatorSync, int i, int j, String expressionNumber) {
        this.calculatorSync=calculatorSync;
        this.i=i;
        this.j=j;
        this.expressionNumber=expressionNumber;
    }
    
    @Override
    public void run() {
        if(calculatorNotSync!=null){
            System.out.println("Calculating int "+i+" + int "+j+" ("+expressionNumber+")...");
            int result = calculatorNotSync.sum(i, j);
            System.out.println("Calculated Result: "+calculatorNotSync.getI()+" + "+calculatorNotSync.getJ()+" = "+result+" ("+expressionNumber+" ?)");
        } else{
            System.out.println("Calculating int "+i+" + int "+j+" ("+expressionNumber+")...");
            int result = calculatorSync.sum(i, j);
            System.out.println("Calculated Result: "+calculatorSync.getI()+" + "+calculatorSync.getJ()+" = "+result+" ("+expressionNumber+" ?)");
        }
    }
}
