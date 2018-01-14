package adapter2;
import java.security.SecureRandom;

public class RandomNumber {
    public static int getNumber(){
        SecureRandom random = new SecureRandom();
        return random.nextInt(1000);
    }
}
