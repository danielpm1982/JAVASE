package adapter1;
import java.io.PrintStream;

public class Out{
    private static final PrintStream write = System.out;
    public static void write(String text){
        write.println(text);
    }
}
