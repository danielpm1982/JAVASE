package systemProperties;
public class Main {
    public static void main(String[] args) {
        System.getProperties().forEach((x,y)->System.out.println(x+" "+y));
    }
}
