package javaapplication55;

public class JavaApplication55{
    public static void main(String... args){
        try {
            for (String s:args){
                System.out.println(s+" ");
            }
            Thread.sleep(200);
            method1(-1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static void method1(int i){
        try{
            assert i>=0:"AssertionError: int i must be > 0!";
            if (!(i>=0)){
                throw new Exception("ExceptionCatched: int i must be > 0!");
            }
        } catch(Exception e){
            System.out.println("Exception catched:");
            e.printStackTrace();
        }
    }
}

//must enable -ea or -enableassertions at jvm line (project>properties>execute>VM Options)
//to enable assertion statements.

