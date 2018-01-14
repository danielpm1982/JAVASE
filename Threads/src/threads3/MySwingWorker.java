/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads3;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Daniel
 */
public class MySwingWorker extends SwingWorker<BigInteger, String>{
    
    private final BigInteger bigInt;
    private final JTextField field;
    private final JTextArea resultArea; 
    private final JTextArea intermediateResultArea; 
    
    public MySwingWorker(BigInteger bigInt, JTextField field, JTextArea resultArea, JTextArea intermediateResultArea) {
        this.bigInt=bigInt;
        this.field=field;
        this.resultArea=resultArea;
        this.intermediateResultArea=intermediateResultArea;
        if(bigInt.compareTo(new BigInteger("0"))==0){
            publish("0");
        } else {
            publish("0 1");
        }
    }

    @Override
    protected BigInteger doInBackground() throws Exception {
        //calculate iteratively to show intermediate values...
        return calculateIterativelyInstance(bigInt);
    }

    @Override
    protected void done() {
        try {
            resultArea.setText(resultArea.getText()+" "+"Fib("+bigInt+"): "+get().toString());
            field.setText("Fib("+bigInt+") DONE!");
            field.setEnabled(true);
        } catch (InterruptedException | ExecutionException ex) {
            field.setText("Fib("+bigInt+") ERROR!");
            Thread.currentThread().interrupt();
            ex.printStackTrace();
        }
    }

    @Override
    protected void process(List<String> publishedVals) {
        publishedVals.stream().forEach(x->intermediateResultArea.setText(intermediateResultArea.getText()+""+x+" "));
    }

    public BigInteger calculateIterativelyInstance(BigInteger bigInt){
        if(bigInt.intValue()==0){
            return new BigInteger("0");
        }
        BigInteger i = new BigInteger("0");
        BigInteger j = new BigInteger("1");
        BigInteger total;        
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        int progress=0;
        for (int k = 1; k < bigInt.intValue(); k++){	
            try {  
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            total = new BigInteger(i.add(j).toString());
            i = j;
            j = total;
            publish(total.toString()); // send intermediate results.
            progress=Integer.valueOf(numberFormat.format((k/bigInt.floatValue())*100));
            setProgress(progress);
        }
        setProgress(100);
        return j;
    }
}
