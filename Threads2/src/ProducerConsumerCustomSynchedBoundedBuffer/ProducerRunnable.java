package ProducerConsumerCustomSynchedBoundedBuffer;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ProducerRunnable implements Runnable{
    BufferInterface<CharSequence> buffer;
    String text;
    
    public ProducerRunnable(BufferInterface<CharSequence> buffer, String text) {
        this.buffer=buffer;
        this.text=text;
    }
    
    public void produceBufferData(String s){
        try {
            //splitting the words from " " (space) and square brackets.
            String[] textArray = s.split("[[ ]|\\[|\\]]");
            System.out.println("Splitted the words according to spaces and '[' ']' (square brackets).");
            Arrays.stream(textArray).forEach(x->System.out.print(x+" ")); System.out.println("");
            for (String word:textArray){
                //selecting only words with or without comma, period or numbers.
                if(Pattern.matches("[0-9]*[a-zA-Z]+[0-9]*.?,?", word)){
                    buffer.putAtBuffer(word);
                }
            }
            System.out.println("Selecting only words with or without comma, period or numbers. Eliminating spaces remaining characters and numeric-only words.");
            System.out.println("Producer Thread Ended!");
        } catch (InterruptedException ex) {
            System.out.println("Producer Thread Interrupted!");
        }
    }

    @Override
    public void run() {
        produceBufferData(text);
    }
    
}
